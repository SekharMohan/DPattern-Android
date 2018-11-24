package com.android.architecture;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.android.architecture.datamodel.DataManager;
import com.android.architecture.datamodel.SharedPreferenceHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static com.android.architecture.datamodel.SharedPreferenceHelper.EMAIL;
import static org.junit.Assert.*;

public class MVVMLoginActivityTest {

	MVVMLoginViewModel mvvmLoginViewModel;



	@Mock
	Context mContext;

	SharedPreferences preferences;

	@Before
	public void setUp() throws Exception {
		preferences = Mockito.mock(SharedPreferences.class);
        mContext = Mockito.mock(Context.class);

	}


	@Test
	public  void test_login() {

		assertTrue(mvvmLoginViewModel.getLoginState().getValue());
	}

	@After
	public void tearDown() throws Exception {

		mvvmLoginViewModel = null;
	}
}