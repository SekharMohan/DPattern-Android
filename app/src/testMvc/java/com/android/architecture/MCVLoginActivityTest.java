package com.android.architecture;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.android.architecture.utils.CommonUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class MCVLoginActivityTest {

	@Mock
	private Context mContext;
	@Mock
	private Bundle mBundle;

	@Mock
	private  MCVLoginActivity mMvcLoginActivity;

	@Before
	public void setUp() throws Exception {
		//mMvcLoginActivity = new MCVLoginActivity();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void isValidEmail() {
		assertTrue(CommonUtils.isEmailValid("sekr@gmail.com"));
	}
}