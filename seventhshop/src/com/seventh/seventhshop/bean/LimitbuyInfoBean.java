package com.seventh.seventhshop.bean;

public class LimitbuyInfoBean {
	private int id;
	/** ��Ʒ���� */
	private String name;
	
	/** ��ƷͼƬ·��*/
	private String pic;
	
	/** ��Ա�� */
	private double price;
	
	/**��ʱ�ؼ�  */
	private double limitprice;
	
	/** ʣ��ʱ�䣬��λΪ��*/
	private long lefttime;
	
	public LimitbuyInfoBean() {
		// TODO Auto-generated constructor stub
	}
	
	public LimitbuyInfoBean(int id, String name, String pic, double price, double limitprice, long lefttime) {
		super();
		this.id = id;
		this.name = name;
		this.pic = pic;
		this.price = price;
		this.limitprice = limitprice;
		this.lefttime = lefttime;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getLimitprice() {
		return limitprice;
	}

	public void setLimitprice(double limitprice) {
		this.limitprice = limitprice;
	}

	public long getLefttime() {
		return lefttime;
	}

	public void setLefttime(long lefttime) {
		this.lefttime = lefttime;
	}
	
}
