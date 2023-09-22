package com.Equarz.Testcases;

	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import com.Pageobjects.Buynow_Functionality;
	import com.Pageobjects.Login_Functionality;
	import com.Pageobjects.Wishlist_Functionality;
	import com.base.Testbase;

	public class BuynowTest  extends Testbase {
		Buynow_Functionality bf;
		Login_Functionality lg;
	    
		public BuynowTest() {
			super();
		}
		@BeforeMethod
		public void initialize() throws Throwable {
			
			Setup();
			lg= new Login_Functionality(driver);
			lg.validateLogin();
			bf = new Buynow_Functionality(driver);
		}
		@Test
		public void Buynow() throws Throwable
		{
			 bf.Buynow();
		}
	}


