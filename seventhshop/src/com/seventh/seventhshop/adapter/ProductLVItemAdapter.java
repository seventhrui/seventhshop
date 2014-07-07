package com.seventh.seventhshop.adapter;

import java.util.List;

import com.seventh.seventhshop.R;
import com.seventh.seventhshop.bean.ProductListBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductLVItemAdapter extends BaseAdapter{
	private Context context;
	private LayoutInflater layoutInflater;
	private List<ProductListBean> list;
	
	// 构造方法，参数list传递的就是这一组数据的信息
	public ProductLVItemAdapter(Context context, List<ProductListBean> list) {
		this.context = context;
		layoutInflater = LayoutInflater.from(context);
		this.list = list;
	}
	
	public void setItemList(List list) {
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
			convertView = layoutInflater.inflate(R.layout.item_lv_product, null);
			holder.goodsIv = (ImageView) convertView.findViewById(R.id.iv_goodsicon);
			holder.tvName = (TextView) convertView.findViewById(R.id.tv_ClothesName);
			holder.tvPrice = (TextView) convertView.findViewById(R.id.tv_ClothesPrice);
			holder.tvMkPrice = (TextView) convertView.findViewById(R.id.tv_MarketPrice);
			holder.commNum = (TextView) convertView.findViewById(R.id.tv_ProductCommentNum);
			convertView.setTag(holder);
		}
		else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		ProductListBean pib=list.get(position);
		
		//holder.goodsIconIv.setImageBitmap(HttpUtil.getHttpBitmap(pib.getPic()));
		holder.goodsIv.setBackgroundResource(R.drawable.ic_launcher);
		holder.tvName.setText(pib.getName());;
		holder.tvPrice.setText("会员价:￥" + pib.getPrice());
		holder.tvMkPrice.setText("市场价:￥"+pib.getMarketprice());
		holder.commNum.setText(pib.getComment_count()+"");
		return convertView;
	}
	static class ViewHolder {
		ImageView goodsIv;
		TextView tvName;
		TextView tvPrice;
		TextView tvMkPrice;
		TextView commNum;
	}
}
