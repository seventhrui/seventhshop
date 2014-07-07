package com.seventh.seventhshop.bean;

public class ProductListBean {
	private int id;
	private String name; //����
	private String pic; //ͼƬ
	private double marketprice; //�м�
	private double price; //��Ա��
	private int comment_count; //��������

	public ProductListBean() {
	}

	public ProductListBean(int id, String name, String pic, double marketprice,
			double price, int comment_count) {
		this.id = id;
		this.name = name;
		this.pic = pic;
		this.marketprice = marketprice;
		this.price = price;
		this.comment_count = comment_count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public double getMarketprice() {
		return marketprice;
	}

	public void setMarketprice(double marketprice) {
		this.marketprice = marketprice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
}
