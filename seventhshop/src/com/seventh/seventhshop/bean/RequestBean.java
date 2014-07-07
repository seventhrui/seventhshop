package com.seventh.seventhshop.bean;

import java.util.HashMap;

import com.seventh.seventhshop.parser.BaseParser;

import android.content.Context;

public class RequestBean {
	public int requestUrl;
	public Context context;
	public HashMap<String, String> requestDataMap;
	public BaseParser<?> jsonParser;

	public RequestBean() {
	}

	public RequestBean(int requestUrl, Context context, HashMap<String, String> requestDataMap, BaseParser<?> jsonParser) {
		super();
		this.requestUrl = requestUrl;
		this.context = context;
		this.requestDataMap = requestDataMap;
		this.jsonParser = jsonParser;
	}
}
