package com.seventh.seventhshop.bean;

public class BulletinInfoBean {
	private int id;
	private String name;
	private String pic;

	public BulletinInfoBean() {

	}

	public BulletinInfoBean(int id,String name,String pic) {
		this.id=id;
		this.name=name;
		this.pic=pic;
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

}
