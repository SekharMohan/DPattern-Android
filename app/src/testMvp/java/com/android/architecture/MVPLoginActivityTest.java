package com.android.architecture;

import com.android.architecture.datamodel.DataManager;

import org.junit.After;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class MVPLoginActivityTest {

	@Mock
	LoginPresenter.View view;

	@Mock
	DataManager dataManager;

	private LoginPresenter presenter;

	@Before
	public void setUp() throws Exception {
		presenter = new LoginPresenter(view,dataManager);
	}

	@After
	public void tearDown() throws Exception {
	}
}