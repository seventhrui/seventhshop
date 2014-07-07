package com.seventh.seventhshop.bean;

import java.util.ArrayList;
import java.util.List;

public class BrandCategoryBean {
	/** 分区名称 */
	private String key;
	
	/** 栏目下所有的 Brands*/
	private List<BrandBean> value = new ArrayList<BrandBean>();

	public BrandCategoryBean() {

	}
	public BrandCategoryBean(String key, List<BrandBean> value) {
		super();
		this.key = key;
		this.value = value;
	}


	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<BrandBean> getValue() {
		return value;
	}

	public void setValue(List<BrandBean> value) {
		this.value = value;
	}
}
