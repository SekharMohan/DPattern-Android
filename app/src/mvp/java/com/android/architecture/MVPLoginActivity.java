package com.android.architecture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MVPLoginActivity extends AppCompatActivity implements LoginPresenter.View {

	@BindView(R.id.email)
	AutoCompleteTextView mEmail;
	@BindView(R.id.password)
	EditText mPassword;
	@BindView(R.id.email_sign_in_button)
	Button mEmailSignInButton;
	private  LoginPresenter mPresenter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		ButterKnife.bind(this);
		mPresenter = new LoginPresenter(this, ((MyApplication)getApplication()).getDataManager());
	}

	@Override
	public void setError(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
	}

	@Override
	public void setLoginState(boolean isLoggedIn) {
		if (isLoggedIn) {

			openMainActivity();
		}
	}


	@OnClick(R.id.email_sign_in_button)
	public void onViewClicked() {
		mPresenter.doLogin(mEmail.getText().toString(), mPassword.getText().toString());
	}


	private void openMainActivity() {
		startActivity(new Intent(this, MainActivity.class));
	}

}
