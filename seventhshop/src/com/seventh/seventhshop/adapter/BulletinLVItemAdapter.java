package com.seventh.seventhshop.adapter;

import java.util.List;

import com.seventh.seventhshop.R;
import com.seventh.seventhshop.bean.BulletinInfoBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BulletinLVItemAdapter  extends BaseAdapter {
	private Context context;
	private LayoutInflater layoutInflater;
	private List<BulletinInfoBean> list;
	
	// 构造方法，参数list传递的就是这一组数据的信息
	public BulletinLVItemAdapter(Context context, List<BulletinInfoBean> list) {
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
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = layoutInflater.inflate(R.layout.item_lv_pro_bulletin, null);
			holder.imIcon = (ImageView) convertView.findViewById(R.id.iv_icon);
			holder.tvContext = (TextView) convertView.findViewById(R.id.tv_content);
			
			convertView.setTag(holder);
		}
		else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		BulletinInfoBean bib=list.get(position);
		
		//holder.goodsIconIv.setImageBitmap(HttpUtil.getHttpBitmap(bib.getPic()));
		holder.imIcon.setBackgroundResource(R.drawable.ic_launcher);
		holder.tvContext.setText(bib.getName());;
		
		return convertView;
	}
	static class ViewHolder {
		TextView tvContext;
		ImageView imIcon;
	}
}
