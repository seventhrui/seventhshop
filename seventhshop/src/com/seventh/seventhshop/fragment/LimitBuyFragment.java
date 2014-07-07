package com.seventh.seventhshop.fragment;

import java.util.ArrayList;
import java.util.List;

import com.seventh.seventhshop.R;
import com.seventh.seventhshop.adapter.LimitbuyLVItemAdapter;
import com.seventh.seventhshop.bean.LimitbuyInfoBean;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class LimitBuyFragment extends Fragment {
	private Context context;
	private View rootView = null;
	
	private List<LimitbuyInfoBean> limitbuyList;
	private ListView lv_promBulldtin;
	LimitbuyLVItemAdapter limitbuyAdapter;
	public LimitBuyFragment(Context c) {
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
		limitbuyList = new ArrayList<LimitbuyInfoBean>();
		limitbuyList.add(new LimitbuyInfoBean(1,"ÍÁ¶¹","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690",15.5,13.9,1000*60));
		limitbuyList.add(new LimitbuyInfoBean(2,"·¬ÇÑ","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690",12.1,11.9,1000*60));
		limitbuyList.add(new LimitbuyInfoBean(3,"Ñó´Ð","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690",11.5,10.9,1000*60));
		limitbuyList.add(new LimitbuyInfoBean(4,"éÙ×Ó","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690",20.9,18.9,1000*60));
		limitbuyList.add(new LimitbuyInfoBean(5,"Æ»¹û","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690",21.8,20.9,1000*60));
		lv_promBulldtin.setAdapter(new LimitbuyLVItemAdapter(context,limitbuyList));
	}
}
