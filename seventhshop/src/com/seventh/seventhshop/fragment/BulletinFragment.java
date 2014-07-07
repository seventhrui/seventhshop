package com.seventh.seventhshop.fragment;

import java.util.ArrayList;
import java.util.List;

import com.seventh.seventhshop.R;
import com.seventh.seventhshop.adapter.BulletinLVItemAdapter;
import com.seventh.seventhshop.bean.BulletinInfoBean;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class BulletinFragment extends Fragment {
	private Context context;
	private View rootView = null;
	
	private List<BulletinInfoBean> bulletinList;
	private ListView lv_promBulldtin;
	public BulletinFragment(Context c) {
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
		rootView = i.inflate(R.layout.fragment_prom_bulletin, c, false);
		lv_promBulldtin = (ListView) rootView.findViewById(R.id.lv_promBulldtin);
	}
	private void getData(){
		bulletinList = new ArrayList<BulletinInfoBean>();
		bulletinList.add(new BulletinInfoBean(1,"ÍÁ¶¹","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690"));
		bulletinList.add(new BulletinInfoBean(2,"·¬ÇÑ","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690"));
		bulletinList.add(new BulletinInfoBean(3,"ÀóÖ¦","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690"));
		bulletinList.add(new BulletinInfoBean(4,"Î÷¹Ï","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690"));
		bulletinList.add(new BulletinInfoBean(5,"Æ»¹û","http://s16.sinaimg.cn/orignal/89429f6dhb99b4903ebcf&690"));
		lv_promBulldtin.setAdapter(new BulletinLVItemAdapter(context,bulletinList));
	}
}
