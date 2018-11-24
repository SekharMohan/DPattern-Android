package com.android.architecture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.architecture.datamodel.DataManager;
import com.android.architecture.utils.CommonUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MCVLoginActivity extends AppCompatActivity {

	@BindView(R.id.login_progress)
	ProgressBar loginProgress;
	@BindView(R.id.email)
	AutoCompleteTextView email;
	@BindView(R.id.password)
	EditText edtPassword;
	@BindView(R.id.email_sign_in_button)
	Button emailSignInButton;
	DataManager dataManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		ButterKnife.bind(this);
		dataManager = ((MyApplication)getApplication()).getDataManager();

	}

	@OnClick(R.id.email_sign_in_button)
	public void onViewClicked() {
		String emailId = email.getText().toString();
		String password = edtPassword.getText().toString();

		if (!CommonUtils.isEmailValid(emailId)) {
			Toast.makeText(this, "Enter correct Email", Toast.LENGTH_LONG).show();
			return;
		}

		if (password == null || password.isEmpty()) {
			Toast.makeText(this, "Enter Password", Toast.LENGTH_LONG).show();
			return;
		}

		//external world interations.
		dataManager.saveEmailId(emailId);
		dataManager.setLoggedIn();
		openMainPage();

	}

	private void openMainPage() {
		startActivity(new Intent(this,MainActivity.class));
	}
}
