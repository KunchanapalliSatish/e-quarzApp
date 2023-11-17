package com.Equarz.Testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Pageobjects.Login_Functionality;
import com.Pageobjects.ProfileFunctionality;
import com.Utils.Utils;
import com.base.Testbase;

public class Profile extends Testbase {
	Login_Functionality Login;
	ProfileFunctionality pf;
	Utils uts;
	private final String sheetname = "Profile";

	public Profile() {
		super();
	}

	@DataProvider
	public String[][] setdata1() throws Throwable {
		return uts.setdata(sheetname);
	}

	@BeforeMethod
	public void initialise() throws Throwable {
		Setup();
		Login = new Login_Functionality(driver);
		pf = new ProfileFunctionality(driver);
		Login.validateLogin();
	}

	@Test(priority = 1, dataProvider = "setdata1", dataProviderClass = Profile.class)
	public void edit(String name2, String last2, String num2, String password12, String password22) throws Throwable {
		pf.profileedit(name2, last2, num2, password12, password22);
	}
}
