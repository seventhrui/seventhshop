package com.seventh.seventhshop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.seventh.seventhshop.adapter.ProductLVItemAdapter;
import com.seventh.seventhshop.bean.ProductListBean;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SearchProductListActivity extends Activity {
	private TextView tv_RankSale;
	private TextView tv_RankPrice;
	private TextView tv_RankGood;
	private TextView tv_RankTime;
	private ListView lvproduct;

	private List<ProductListBean> productList;
	private ProductLVItemAdapter plviaadapter=null;
	private static boolean SORTFLAG = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_product_list);
		initView();
		getData();
		initListener();
	}

	private void initView() {
		tv_RankSale = (TextView) findViewById(R.id.tv_ranksale);
		tv_RankPrice = (TextView) findViewById(R.id.tv_rankprice);
		tv_RankGood = (TextView) findViewById(R.id.tv_rankgood);
		tv_RankTime = (TextView) findViewById(R.id.tv_ranktime);
		lvproduct = (ListView) findViewById(R.id.lv_product);
	}

	private void getData() {
		productList = new ArrayList<ProductListBean>();
		productList.add(new ProductListBean(1, "����", "http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690", 29, 28.9, 15));
		productList.add(new ProductListBean(2, "����", "http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690", 30, 29.9, 26));
		productList.add(new ProductListBean(3, "��֦", "http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690", 40, 35.9, 2));
		productList.add(new ProductListBean(4, "����", "http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690", 11, 10.9, 3));
		productList.add(new ProductListBean(5, "ƻ��", "http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690", 9.5, 8.9, 8));
		plviaadapter=new ProductLVItemAdapter(getApplicationContext(),productList);
		lvproduct.setAdapter(plviaadapter);
	}

	private void initListener() {
		tv_RankSale.setOnClickListener(splaocl);
		tv_RankPrice.setOnClickListener(splaocl);
		tv_RankGood.setOnClickListener(splaocl);
		tv_RankTime.setOnClickListener(splaocl);
		lvproduct.setOnItemClickListener(sploicl);
	}
	
	private OnClickListener splaocl = new OnClickListener() {
		@Override
		public void onClick(View v) {
			String name = "";
			switch (v.getId()) {
			case R.id.tv_ranksale://����
				name = "1";
				Collections.sort(productList,new Comparator<ProductListBean>() {
					@Override
					public int compare(ProductListBean lhs,
							ProductListBean rhs) {
						double price1 = lhs.getPrice();
						double price2 = rhs.getPrice();
						if (price1 > price2)
							return 1;
						else
							return -1;
					}
				});
				break;
			case R.id.tv_rankprice://�۸�
				Collections.sort(productList,new Comparator<ProductListBean>() {
					@Override
					public int compare(ProductListBean lhs,
							ProductListBean rhs) {
						double price1 = lhs.getPrice();
						double price2 = rhs.getPrice();
						if (price1 > price2)
							return -1;
						else
							return 1;
					}
				});
				break;
			case R.id.tv_rankgood://����
				Collections.sort(productList,new Comparator<ProductListBean>() {
					@Override
					public int compare(ProductListBean lhs,
							ProductListBean rhs) {
						int content1 = lhs.getComment_count();
						int content2 = rhs.getComment_count();
						if (content1 > content2)
							return 1;
						else
							return -1;
					}
				});
				break;
			case R.id.tv_ranktime://�ϼ�ʱ��
				Collections.sort(productList,new Comparator<ProductListBean>() {
					@Override
					public int compare(ProductListBean lhs,
							ProductListBean rhs) {
						int content1 = lhs.getComment_count();
						int content2 = rhs.getComment_count();
						if (content1 > content2)
							return -1;
						else
							return 1;
					}
				});
				break;
			}
			
			plviaadapter=new ProductLVItemAdapter(getApplicationContext(),productList);
			plviaadapter.notifyDataSetChanged();
			lvproduct.setAdapter(plviaadapter);

			//Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
		}
	};
	
	private OnItemClickListener sploicl = new OnItemClickListener(){
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent intent = new Intent(getApplicationContext(), ProductDetailActivity.class);
			intent.putExtra("id", ((ProductListBean)plviaadapter.getItem(position)).getId());
			startActivity(intent);
		}
	};
}
