package com.seventh.seventhshop.fragment;

import com.seventh.seventhshop.R;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment{
	private static final String TAG = "MainFragment";
	
	private View rootView = null;
	private Context context;
	private static int num = 0;

	public MainFragment(Context c) {
		this.context=c;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		initView(inflater, container);
		return rootView;
	}

	private void initView(LayoutInflater i, ViewGroup c) {
		num = getArguments().getInt("type");
		Log.v(TAG, num+"");
		Fragment fragment=null;
		switch (num){
		case 0:
			fragment=new LimitBuyFragment(context);
			break;
		case 1:
			fragment=new BulletinFragment(context);
			break;
		case 2:
			fragment=new NewproductFragment(context);
			break;
		case 3:
			fragment=new HotproductFragment(context);
			break;
		case 4:
			fragment=new BrandFragment(context);
			break;
		}
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
		String planet = getResources().getStringArray(R.array.planets_array)[num];
		getActivity().setTitle(planet);
	}
}
