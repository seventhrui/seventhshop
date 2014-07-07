package com.seventh.seventhshop.fragment;

import java.util.ArrayList;
import java.util.List;

import com.seventh.seventhshop.R;
import com.seventh.seventhshop.adapter.BrandLVItemAdapter;
import com.seventh.seventhshop.bean.BrandBean;
import com.seventh.seventhshop.bean.BrandCategoryBean;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class BrandFragment extends Fragment {
	private Context context;
	private View rootView = null;
	
	private List<BrandCategoryBean> bcblist;
	private TextView textBrandInfoNull;
	private TextView textTitle;
	private ExpandableListView expandableLV;
	public BrandFragment(Context c) {
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
		rootView = i.inflate(R.layout.fragment_listview_brand, c, false);
		expandableLV = (ExpandableListView) rootView.findViewById(R.id.elv_BrandInfo);
	}
	private void getData(){
		bcblist = new ArrayList<BrandCategoryBean>();
		List<BrandBean> bbl1=new ArrayList<BrandBean>();
		bbl1.add(new BrandBean(11,"一一","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690"));
		bbl1.add(new BrandBean(12,"一二","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690"));
		bbl1.add(new BrandBean(13,"一三","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690"));
		bbl1.add(new BrandBean(14,"一四","pic"));
		bbl1.add(new BrandBean(15,"一五","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690"));
		bcblist.add(new BrandCategoryBean("eat",bbl1));
		List<BrandBean> bbl2=new ArrayList<BrandBean>();
		bbl2.add(new BrandBean(21,"二一","pic"));
		bbl2.add(new BrandBean(22,"二二","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690"));
		bbl2.add(new BrandBean(23,"二三","pic"));
		bbl2.add(new BrandBean(24,"二四","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690"));
		bbl2.add(new BrandBean(25,"二五","pic"));
		bcblist.add(new BrandCategoryBean("drink",bbl2));
		expandableLV.setAdapter(new BrandLVItemAdapter(context,expandableLV,bcblist));
	}
}
