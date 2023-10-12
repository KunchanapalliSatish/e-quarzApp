package com.Equarz.Testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Pageobjects.CartFunctionality;
import com.Pageobjects.Login_Functionality;
import com.base.Testbase;

public class AddToCart {
	public class Addcart extends Testbase{
		Login_Functionality lg;
		CartFunctionality cart;
		
		public Addcart()
		{
			super();
		}
		@BeforeClass
		public void Initialisation() throws Throwable
		{
			Setup();
			lg=new Login_Functionality(driver);
			cart= new CartFunctionality(driver);
			lg.validateLogin();
			}
		
		@Test(priority = 1)
		public void CategoryTest() throws Throwable
		{
			cart.categoryCart();
		}
		@Test(priority = 2)
		public void BannerTest()
		{
			cart.BannerCart();
		}
		@Test(priority = 3)
		public void footerbannerTest()
		{
			cart.footbanCart();
		}
		@Test(priority = 4)
		public void dealofdayTest() throws Throwable
		{
			cart.dealdayCart();
		}
		@Test(priority = 5)
		public void HompageproductTest()
		{
			cart.Homepage_product();
		}
		@Test(priority = 6)
		public void SearchboxCartTest() throws Throwable
		{
			cart.SearchprodtCart();
		}
		@Test(priority = 7)
		public void wishlist_product()
		{
			cart.WishlistCart();
		}
		
		@AfterClass
		public void Teardown()
		{
		
			driver.close();
		}

	}


}
