package com.seventh.seventhshop.adapter;

import java.util.List;

import com.seventh.seventhshop.R;
import com.seventh.seventhshop.bean.HomeCategoryBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeLVItemAdapter extends BaseAdapter {
	
	private Context context;
	private LayoutInflater layoutInflater;
	private List<HomeCategoryBean> list;

	// 构造方法，参数list传递的就是这一组数据的信息
	public HomeLVItemAdapter(Context context, List<HomeCategoryBean> list) {
		this.context = context;
		layoutInflater = LayoutInflater.from(context);
		this.list = list;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.list != null ? this.list.size() : 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return this.list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = layoutInflater.inflate(
					R.layout.item_lv_home, null);
		}
		
		((TextView) convertView.findViewById(R.id.textContent)).setText(list.get(position).getTitle());
		((ImageView)convertView.findViewById(R.id.imgIcon)).setBackgroundResource(list.get(position).getImgresid());
		
		return convertView;
	}

}
