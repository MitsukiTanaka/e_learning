package jp.practice.sales;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping(value = "/system")
public class SalesSystemController {

	private static final String INIT = "init";
	private static final String ADD = "add";

	private static final String INIMSG = "";
	private static final String ADDMSG = "明細に追加しました。";

	@RequestMapping(value = "/start")
	public String init(SalesForm form, Model model){
		model.addAttribute("message", INIMSG);
		model.addAttribute("nameList", RecordManager.makeNameList());
		return INIT;
	}
	@RequestMapping(params = "add")
	public String add(SalesForm form , Model model) {

		Item item  = RecordManager.findItem(form.getGoodsName());
		if (item != null) {
			model.addAttribute("allList", RecordManager.getItemList());
			model.addAttribute("nameList", RecordManager.makeNameList());
			form.setGoodsName(RecordManager.getFirstItemName());
			model.addAttribute("message", ADDMSG);
			return ADD;
		} else {
			return INIT;

		}
	}
	@RequestMapping(params = "toInit")
	public String firm(SalesForm form, Model model) {
		model.addAttribute("message", INIMSG);
		model.addAttribute("nameList", RecordManager.makeNameList());
		form.setGoodsName(RecordManager.getFirstItemName());
		return INIT;
	}
}
