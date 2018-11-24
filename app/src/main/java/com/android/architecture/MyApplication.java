package com.android.architecture;

import android.app.Application;

import com.android.architecture.datamodel.DataManager;
import com.android.architecture.datamodel.SharedPreferenceHelper;

public class MyApplication extends Application {

	DataManager dataManager;

	@Override
	public void onCreate() {
		super.onCreate();

		SharedPreferenceHelper sharedPrefsHelper = new SharedPreferenceHelper(getApplicationContext());
		dataManager = new DataManager(sharedPrefsHelper);

	}

	public  DataManager getDataManager() {
		return dataManager;
	}

}
