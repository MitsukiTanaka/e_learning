package jp.practice.sales;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/** Controllerクラス */
@Controller @RequestMapping(value = "/system")
@SessionAttributes(types = {SalesForm.class})
public class SalesSystemController {

    /**  */
    private static final String INIT = "init";
    /**  */
    private static final String ADD = "add";
    /**  */
    private static final String FIRM = "firm";
    /**  */
    private static final String INIMSG = "";
    /** 追加メッセージ */
    private static final String ADDMSG = "明細に追加しました。";
    /** エラーメッセージ1 */
    private static final String ERRMSG = "点数には1以上100以下の整数を入力してください。";
    /** 登録メッセージ */
    private static final String FIRMMSG = "以下のように売上登録しました。";
    /** 削除メッセージ */
    private static final String REMMSG = "選択された明細行を削除しました。";
    /** エラーメッセージ2 */
    private static final String ERRMSG2 = "明細行を選択してください。";
    /** フラグ */
    private int flag = 0;
    /** 入力された点数 */
    private int tensuu = 0;
    /** 点数の最大値 */
    private static final int POINT_MAX = 100;


    /**
     * 初期画面を表示する
     * @param form フォームクラス
     * @param model モデル
     * @return Viewとしてinit.jspを指定
     */
    @RequestMapping(value = "/start")
    public String init(SalesForm form, Model model) {
        model.addAttribute("message", INIMSG);
        form.setPoint("1");
        model.addAttribute("nameList", RecordManager.makeNameList());
        return INIT;
    }

    /**
     * 明細追加画面を表示する
     * @param form フォームクラス
     * @param model モデル
     * @return Viewとしてadd.jspを表示する
     */
    @RequestMapping(params = "add")
    public String add(SalesForm form, Model model) {
        Item item  = RecordManager.findItem(form.getGoodsName());

        try {
            tensuu = Integer.parseInt(form.getPoint());

            if (tensuu <= POINT_MAX && 1 <= tensuu) {
                flag = 1;
                Item item2 = new Item(item.getId(), item.getName(), item.getPrice(), tensuu, (item.getPrice() * tensuu));
                form.setPoint("1");
                form.addToAllList(item2);
                form.setDelNumber(0);
                model.addAttribute("allList", form.getAllList());
                model.addAttribute("nameList", RecordManager.makeNameList());
                //model.addAttribute("message", item.getId());
                model.addAttribute("message", ADDMSG);
                form.setGoodsName(RecordManager.getFirstItemName());
                model.addAttribute("total", form.makeTotal());
                return ADD;
            } else {
                if (flag == 1) {
                    model.addAttribute("alertmessage", ERRMSG);
                    form.setDelNumber(0);
                    model.addAttribute("nameList", RecordManager.makeNameList());
                    model.addAttribute("allList", form.getAllList());
                    model.addAttribute("total", form.makeTotal());
                    return ADD;
                } else {
                    model.addAttribute("alertmessage", ERRMSG);
                    model.addAttribute("nameList", RecordManager.makeNameList());
                    return INIT;
                }
            }
        } catch (NumberFormatException e) {
        }
        if (flag == 1) {
            model.addAttribute("alertmessage", ERRMSG);
            form.setDelNumber(0);
            model.addAttribute("nameList", RecordManager.makeNameList());
            model.addAttribute("allList", form.getAllList());
            model.addAttribute("total", form.makeTotal());
            return ADD;
        } else {
            model.addAttribute("alertmessage", ERRMSG);
            model.addAttribute("nameList", RecordManager.makeNameList());
            return INIT;
        }
    }

    /**
     * 削除機能
     * @param form フォームクラス
     * @param model モデル
     * @return init.jspもしくはadd.jspへ遷移
     */
    @RequestMapping(params = "remove")
    public String remove(SalesForm form, Model model) {
        if (0 < form.getDelNumber()) {
            form.removeToAllList(form.getDelNumber() - 1);
            form.setDelNumber(0);
            model.addAttribute("total", form.makeTotal());
            model.addAttribute("allList", form.getAllList());
            model.addAttribute("nameList", RecordManager.makeNameList());
            model.addAttribute("message", REMMSG);
            if (0 < form.getAllList().size()) {
                return ADD;
            } else {
                flag = 0;
                model.addAttribute("message", REMMSG);
                model.addAttribute("nameList", RecordManager.makeNameList());
                return INIT;
            }
        } else {
            model.addAttribute("alertmessage", ERRMSG2);
            model.addAttribute("nameList", RecordManager.makeNameList());
            model.addAttribute("allList", form.getAllList());
            model.addAttribute("total", form.makeTotal());
            return ADD;
        }
    }

    /**
     * 売上登録画面を表示する
     * @param form フォームクラス
     * @param model モデル
     * @return Viewとしてfirm.jspを指定
     */
    @RequestMapping(params = "firm")
    public String firm(SalesForm form, Model model) {
        model.addAttribute("message", FIRMMSG);
        model.addAttribute("milli", form.makeMilli());
        model.addAttribute("allList", form.getAllList());
        model.addAttribute("total", form.makeTotal());
        return FIRM;
    }

    /**
     * 初期画面へ戻る
     * @param form フォームクラス
     * @param model モデル
     * @return Viewとしてinit.jspを指定
     */
    @RequestMapping(params = "end")
    public String end(SalesForm form, Model model) {
        flag = 0;
        form.flushAllList();
        model.addAttribute("message", INIMSG);
        model.addAttribute("nameList", RecordManager.makeNameList());
        return INIT;
    }
}
