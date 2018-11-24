package com.android.architecture;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.android.architecture.datamodel.DataManager;
import com.android.architecture.utils.CommonUtils;

public class MVVMLoginViewModel extends ViewModel {
	MutableLiveData<Boolean> loginStateLiveData = new MutableLiveData<Boolean>();
	DataManager mDataManager;

	MutableLiveData<String> mErrorStateLiveData = new MutableLiveData<>();

	public void setDataManager( DataManager dataManager) {
		mDataManager = dataManager;
	}


	public void login(String email, String psw) {

	if(isValidCredentials(email,psw)) {

		// api calls / external world interation.
		mDataManager.saveEmailId(email);
		mDataManager.getLoggedInMode();
		loginStateLiveData.setValue(true);
		return;
	}

	mErrorStateLiveData.setValue("Invalid credentials");

}

public LiveData<Boolean> getLoginState() {
		return loginStateLiveData;

}


public LiveData<String> getErrorState() {
		return mErrorStateLiveData;
}


private boolean isValidCredentials(String email, String psw){
	return CommonUtils.isEmailValid(email) && !psw.isEmpty();
}

}
