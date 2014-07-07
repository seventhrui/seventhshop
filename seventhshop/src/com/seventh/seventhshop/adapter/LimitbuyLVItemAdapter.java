package com.seventh.seventhshop.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.seventh.seventhshop.R;
import com.seventh.seventhshop.bean.LimitbuyInfoBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LimitbuyLVItemAdapter  extends BaseAdapter {
	
	private Context context;
	private LayoutInflater layoutInflater;
	private List<LimitbuyInfoBean> list;

	private SimpleDateFormat simpleDateFormat;
	
	// 构造方法，参数list传递的就是这一组数据的信息
	public LimitbuyLVItemAdapter(Context context, List<LimitbuyInfoBean> list) {
		this.context = context;
		layoutInflater = LayoutInflater.from(context);
		this.list = list;
		simpleDateFormat = new SimpleDateFormat("dd 天  HH:mm:ss");
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
			convertView = layoutInflater.inflate(R.layout.item_lv_timelimit_goods, null);
			holder.goodsIconIv = (ImageView) convertView.findViewById(R.id.iv_goodsIcon);
			holder.textClothesName = (TextView) convertView.findViewById(R.id.tv_ClothesName);
			holder.textClothesPrice = (TextView) convertView.findViewById(R.id.tv_ClothesPrice);
			holder.textMarketPrice = (TextView) convertView.findViewById(R.id.tv_MarketPrice);
			holder.textProductCommentNum = (TextView) convertView.findViewById(R.id.tv_ProductComment);
			
			convertView.setTag(holder);
		}
		else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		LimitbuyInfoBean lbb=list.get(position);
		
		//holder.goodsIconIv.setImageBitmap(HttpUtil.getHttpBitmap(lbb.getPic()));
		holder.goodsIconIv.setBackgroundResource(R.drawable.ic_launcher);
		holder.textClothesName.setText(lbb.getName());;
		holder.textClothesPrice.setText("￥" + lbb.getLimitprice()+"");
		holder.textMarketPrice.setText("原价：￥" + lbb.getPrice()+"");
		// 定时器
		long v = lbb.getLefttime() - System.currentTimeMillis();
		Date date = new Date(v);
		holder.textProductCommentNum.setText(simpleDateFormat.format(date));
		
		return convertView;
	}
	static class ViewHolder {
		ImageView goodsIconIv;
		TextView textClothesName;
		TextView textClothesPrice;
		TextView textMarketPrice;
		TextView textProductCommentNum;
	}
}
