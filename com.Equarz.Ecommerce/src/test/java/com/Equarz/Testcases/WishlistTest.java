package com.Equarz.Testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pageobjects.Login_Functionality;
import com.Pageobjects.Wishlist_Functionality;
import com.base.Testbase;

public class WishlistTest extends Testbase {
		
	Wishlist_Functionality wl;
		Login_Functionality lg;
		
		public WishlistTest() {
			super();
		}
		
//		@BeforeClass
//		public void open()
//		{
//			lg= new Login_Functionality(driver);
//			lg.validateLogin();
//		}
		@BeforeMethod
		public void initialize() throws Throwable {
			
			Setup();
			lg= new Login_Functionality(driver);
			//lg.validateLogin(props.getProperty("username"),props.getProperty("password"));
			lg.validateLogin();
			 wl = new Wishlist_Functionality(driver);
		
		}
		
		@Test
		public void categorywishlist() 
		{
			wl.categorylist();
		}
		@Test
		public void bannerwishlist() throws Throwable 
		{
			wl.bannerlist();
		}
		@Test
		public void searchwishlist() throws Throwable 
		{
			wl.searchlist();
		}
		@Test
		public void homewishlist()
		{
			wl.homelist();
		}
		@Test
		public void footbanwishlist()
		{
			wl.footerbannerlist();
		}
		@Test
		public void deallist() throws Throwable
		{
			wl.dealoflist();
		}
}