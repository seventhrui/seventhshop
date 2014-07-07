package com.seventh.seventhshop.fragment;

import java.util.ArrayList;
import java.util.List;

import com.seventh.seventhshop.R;
import com.seventh.seventhshop.adapter.ProductLVItemAdapter;
import com.seventh.seventhshop.bean.ProductListBean;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class NewproductFragment extends Fragment {
	private Context context;
	private View rootView = null;
	
	private List<ProductListBean> productList;
	private ListView lv_promBulldtin;
	public NewproductFragment(Context c) {
		this.context = c;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		initView(inflater, container);
		getData();
		return rootView;
	}

	/**
	 * Initialize the View
	 * 
	 * @param i
	 * @param c
	 */
	private void initView(LayoutInflater i, ViewGroup c) {
		rootView = i.inflate(R.layout.prom_bulletin_fragment, c, false);
		lv_promBulldtin = (ListView) rootView.findViewById(R.id.lv_promBulldtin);
	}
	private void getData(){
		productList = new ArrayList<ProductListBean>();
		productList.add(new ProductListBean(1,"ÍÁ¶¹","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690",29,28.9,15));
		productList.add(new ProductListBean(2,"·¬ÇÑ","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690",30,28.9,26));
		productList.add(new ProductListBean(3,"ÀóÖ¦","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690",40,35.9,2));
		productList.add(new ProductListBean(4,"Î÷¹Ï","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690",11,10.9,3));
		productList.add(new ProductListBean(5,"Æ»¹û","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690",9.5,8.9,8));
		lv_promBulldtin.setAdapter(new ProductLVItemAdapter(context,productList));
	}
}
