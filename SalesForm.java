package jp.practice.sales;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/** Formクラス */
public class SalesForm {
    /** 商品名 */
    private String goodsName;
    /** 商品点数 */
    private String point;
    /** ラジオボタンによる削除番号 */
    private int delNumber;
    /** 小計 */
    private int subtotal;
    /** 売上明細リスト */
    private List<Item> allList = new ArrayList<Item>();

    /** コンストラクタ */
    public SalesForm() {

    }

    /**
     * @return goodsName
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * @param goodsName セットする goodsName
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * @return point
     */
    public String getPoint() {
        return point;
    }

    /**
     * @param point
     * @param point セットする point
     */
    public void setPoint(String point) {
        this.point = point;
    }

    /**
     * @return delNumber
     */
    public int getDelNumber() {
        return delNumber;
    }

    /**
     * @param delNumber セットする delNumber
     */
    public void setDelNumber(int delNumber) {
        this.delNumber = delNumber;
    }

    /**
     * @return allList
     */
    public List<Item> getAllList() {
        return allList;
    }

    /**
     * @return subtotal
     */
    public int getSubTotal() {
        return subtotal;
    }

    /**
     * @param subtotal セットする subtotal
     */
    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    /**
     *  商品情報を1件追加するメソッド
     *  @param item 追加する
     */
    public void addToAllList(Item item) {
        allList.add(item);
    }

    /**
     * 商品情報を1件削除するメソッド
     * @param delNumber 削除番号
     */
    public void removeToAllList(int delNumber) {
        allList.remove(allList.get(delNumber));
    }

    /**
     * AllListを空にする
     */
    public void flushAllList() {
        allList.clear();
    }

    /**
     * 数値を3桁区切りにする
     * @param num long型の引数
     * @return String型を返す
     */
    public final String formatNumber(long num) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        return nf.format(num);
    }

    /**
     *  各小計を合計するメソッド
     *  @return total
     */
    public String makeTotal() {
        int total = 0;
        for (int i = 0; i < allList.size(); i++) {
            total += (allList.get(i)).getSubtotal();
        }
        return formatNumber(total);
    }

    /**
     * ミリ秒を表示するメソッド
     * @return milli
     */
    public long makeMilli() {
        long milli = System.currentTimeMillis();
        return milli;
    }

}
