package com.android.architecture;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MVVMLoginActivity extends AppCompatActivity {

	@BindView(R.id.email)
	AutoCompleteTextView mEmail;
	@BindView(R.id.password)
	EditText mPassword;
	@BindView(R.id.email_sign_in_button)
	Button mEmailSignInButton;
	private MVVMLoginViewModel mViewModel;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		ButterKnife.bind(this);

		mViewModel = ViewModelProviders.of(this).get(MVVMLoginViewModel.class);
		mViewModel.setDataManager(((MyApplication)getApplication()).getDataManager());
		mViewModel.getErrorState().observe(this, new Observer<String>() {
			@Override
			public void onChanged(@Nullable String s) {
				Toast.makeText(MVVMLoginActivity.this, s, Toast.LENGTH_LONG).show();
			}
		});

		mViewModel.getLoginState().observe(this, new Observer<Boolean>() {
			@Override
			public void onChanged(@Nullable Boolean isLoggedIn) {
				if (isLoggedIn) {
					openMainActivity();
				}
			}
		});

	}

	private void openMainActivity() {
		startActivity(new Intent(this, MainActivity.class));
	}

	@OnClick(R.id.email_sign_in_button)
	public void onViewClicked() {
		mViewModel.login(mEmail.getText().toString(), mPassword.getText().toString());
	}
}
