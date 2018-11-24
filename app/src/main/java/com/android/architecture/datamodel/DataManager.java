package com.android.architecture.datamodel;



public class DataManager  {

	SharedPreferenceHelper mSharedPrefsHelper;

	public DataManager(SharedPreferenceHelper sharedPrefsHelper) {
		mSharedPrefsHelper = sharedPrefsHelper;
	}

	public void clear() {
		mSharedPrefsHelper.clear();
	}

	public void saveEmailId(String email) {
		mSharedPrefsHelper.putEmail(email);

	}

	public String getEmailId() {
		return mSharedPrefsHelper.getEmail();
	}

	public void setLoggedIn() {
		mSharedPrefsHelper.setLoggedInMode(true);
	}

	public Boolean getLoggedInMode() {
		return mSharedPrefsHelper.getLoggedInMode();
	}
}
