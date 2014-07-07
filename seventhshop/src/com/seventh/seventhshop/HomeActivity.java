package com.seventh.seventhshop;

import java.util.ArrayList;
import java.util.List;

import org.taptwo.android.widget.CircleFlowIndicator;
import org.taptwo.android.widget.ViewFlow;

import com.seventh.seventhshop.adapter.HomeImageAdapter;
import com.seventh.seventhshop.adapter.HomeLVItemAdapter;
import com.seventh.seventhshop.bean.HomeCategoryBean;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class HomeActivity extends Activity {
	private static final String TAG = "HomeActivity";
	
	private EditText et_searchinfo;
	private ImageButton ibtn_search;
	private ViewFlow viewFlow;
	private ListView mCategoryListView;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		initView();
		initData();
		setListener();
	}

	private void initView() {
		et_searchinfo = (EditText) findViewById(R.id.et_searchinfo);
		ibtn_search = (ImageButton) findViewById(R.id.ibtn_search);
		
		// home 滚动图片
		viewFlow = (ViewFlow) findViewById(R.id.viewflow);
		viewFlow.setAdapter(new HomeImageAdapter(getApplicationContext()));
		viewFlow.setmSideBuffer(3);

		CircleFlowIndicator indic = (CircleFlowIndicator) findViewById(R.id.viewflowindic);
		viewFlow.setFlowIndicator(indic);
		viewFlow.setTimeSpan(4500);
		viewFlow.setSelection(3 * 1000); // 设置初始位置
		viewFlow.startAutoFlowTimer(); // 启动自动播放

		mCategoryListView = (ListView) findViewById(R.id.lv_home_type);
	}

	private void initData() {
		List<HomeCategoryBean> categroy = new ArrayList<HomeCategoryBean>();
		categroy.add(new HomeCategoryBean(R.drawable.home_classify_01, "限时抢购"));
		categroy.add(new HomeCategoryBean(R.drawable.home_classify_02, "促销快报"));
		categroy.add(new HomeCategoryBean(R.drawable.home_classify_03, "新品上架"));
		categroy.add(new HomeCategoryBean(R.drawable.home_classify_04, "热卖单品"));
		categroy.add(new HomeCategoryBean(R.drawable.home_classify_05, "推荐品牌"));
		mCategoryListView.setAdapter(new HomeLVItemAdapter(getApplicationContext(), categroy));
	}

	private void setListener() {
		ibtn_search.setOnClickListener(myocl);
		mCategoryListView.setOnItemClickListener(myoicl);

	}
	private OnClickListener myocl = new OnClickListener(){
		@Override
		public void onClick(View v) {
			String words = et_searchinfo.getText().toString();
			if (TextUtils.isEmpty(words)) {
				Toast.makeText(getApplicationContext(), "请输入关键词", Toast.LENGTH_LONG).show();
				return ;
			}
			Intent Intent = new Intent(getApplicationContext(), SearchProductListActivity.class);
			Intent.putExtra("keyWord", words);
			startActivity(Intent);
		}
		
	};
	private OnItemClickListener myoicl = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			String name = "";
			int fragmentid=0;
			Intent intent = new Intent();
			switch (position) {
			case 0:// 限时抢购
				name = "限时抢购";
				fragmentid=0;
				break;
			case 1:// 促销快报
				name = "促销快报";
				fragmentid=1;
				break;
			case 2:// 新品上架
				name = "新品上架";
				fragmentid=2;
				break;
			case 3:// 热卖单品
				name = "热卖单品";
				fragmentid=3;
				break;
			case 4:// 推荐品牌
				name = "推荐品牌";
				fragmentid=4;
				break;
			}
			Bundle bundle = new Bundle();
			bundle.putInt("fragmentid", fragmentid);
			Log.v(TAG, fragmentid+"");
			intent.putExtras(bundle);
			intent.setClass(getApplicationContext(), MainActivity.class);
			startActivity(intent);
			getActionBar().setTitle(name);
		}
	};
}
