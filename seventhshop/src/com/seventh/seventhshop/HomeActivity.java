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
		
		// home ����ͼƬ
		viewFlow = (ViewFlow) findViewById(R.id.viewflow);
		viewFlow.setAdapter(new HomeImageAdapter(getApplicationContext()));
		viewFlow.setmSideBuffer(3);

		CircleFlowIndicator indic = (CircleFlowIndicator) findViewById(R.id.viewflowindic);
		viewFlow.setFlowIndicator(indic);
		viewFlow.setTimeSpan(4500);
		viewFlow.setSelection(3 * 1000); // ���ó�ʼλ��
		viewFlow.startAutoFlowTimer(); // �����Զ�����

		mCategoryListView = (ListView) findViewById(R.id.lv_home_type);
	}

	private void initData() {
		List<HomeCategoryBean> categroy = new ArrayList<HomeCategoryBean>();
		categroy.add(new HomeCategoryBean(R.drawable.home_classify_01, "��ʱ����"));
		categroy.add(new HomeCategoryBean(R.drawable.home_classify_02, "�����챨"));
		categroy.add(new HomeCategoryBean(R.drawable.home_classify_03, "��Ʒ�ϼ�"));
		categroy.add(new HomeCategoryBean(R.drawable.home_classify_04, "������Ʒ"));
		categroy.add(new HomeCategoryBean(R.drawable.home_classify_05, "�Ƽ�Ʒ��"));
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
				Toast.makeText(getApplicationContext(), "������ؼ���", Toast.LENGTH_LONG).show();
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
			case 0:// ��ʱ����
				name = "��ʱ����";
				fragmentid=0;
				break;
			case 1:// �����챨
				name = "�����챨";
				fragmentid=1;
				break;
			case 2:// ��Ʒ�ϼ�
				name = "��Ʒ�ϼ�";
				fragmentid=2;
				break;
			case 3:// ������Ʒ
				name = "������Ʒ";
				fragmentid=3;
				break;
			case 4:// �Ƽ�Ʒ��
				name = "�Ƽ�Ʒ��";
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
