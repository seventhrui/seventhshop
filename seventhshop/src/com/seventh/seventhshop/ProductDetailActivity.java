package com.seventh.seventhshop;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailActivity extends Activity {
	private static final String TAG = "ProductDetailActivity";
	private TextView titleBack;
	private Gallery productGallery;
	private ImageView imgPoint;
	private TextView textProductNameValue;
	private TextView textProductIdValue;
	private TextView textOriginalPriceValue;
	private TextView textProdGradeValue;
	private TextView textPriceValue;
	private EditText prodNumValue;
	private TextView textPutIntoShopcar;
	private ImageView imgServiceImg;
	private TextView textProdIsStock;
	private TextView textProductCommentNum;
	private TextView orderTelTv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_detail);
		initView();
	}
	private void initView(){
		productGallery = (Gallery) findViewById(R.id.productGallery);
		textProductIdValue = (TextView) findViewById(R.id.textProductIdValue);
		textProductNameValue = (TextView) findViewById(R.id.textProductNameValue);
		textOriginalPriceValue = (TextView) findViewById(R.id.textOriginalPriceValue);
		textPriceValue = (TextView) findViewById(R.id.textPriceValue);
		textProductCommentNum = (TextView) findViewById(R.id.textProductCommentNum);
		prodNumValue = (EditText) findViewById(R.id.prodNumValue);
		textPutIntoShopcar = (TextView) findViewById(R.id.textPutIntoShopcar);
		orderTelTv = (TextView) findViewById(R.id.orderTelTv);
	}
}
