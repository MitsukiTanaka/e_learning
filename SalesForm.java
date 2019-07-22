package jp.practice.sales;

public class SalesForm {
	private String goodsName;
	private int point;
	private int delNumber;

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
	public int getPoint() {
		return point;
	}

	/**
	 * @param point セットする point
	 */
	public void setPoint(int point) {
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

}
