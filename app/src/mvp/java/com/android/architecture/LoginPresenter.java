package com.android.architecture;

import com.android.architecture.datamodel.DataManager;
import com.android.architecture.utils.CommonUtils;

public class LoginPresenter {

	private View view;
	private DataManager mDataManager;

	public LoginPresenter(View v, DataManager dataManager) {
		view = v;
		mDataManager = dataManager;
	}

	public void doLogin(String email, String psw) {
		if(isValidCredentials(email,psw)) {
			// api calls / external world interation.
			mDataManager.saveEmailId(email);
			view.setLoginState(true);
			return;
		}
		view.setError("Invalid Credentials");
	}


	private boolean isValidCredentials(String email, String psw){
		return CommonUtils.isEmailValid(email) && !psw.isEmpty();
	}

	public interface View {
		void setError(String msg);
		void setLoginState(boolean isLogedIn);
	}
}
