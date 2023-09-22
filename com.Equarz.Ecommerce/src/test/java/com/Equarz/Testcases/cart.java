package com.Equarz.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pageobjects.BannerCart;
import com.Pageobjects.CategoryCart;
import com.Pageobjects.Footerbanner;
import com.Pageobjects.Homesearch;
import com.Pageobjects.Login_Functionality;
import com.Pageobjects.SearchProduct;
import com.Pageobjects.Wishlistcart;
import com.base.Testbase;


public class cart  extends Testbase{
	Login_Functionality LF;
	Homesearch Hs;
	SearchProduct sp;
	CategoryCart Cat;
	BannerCart bc;
	Footerbanner fb;
	Wishlistcart ws;
	
	public  cart () {
		super();
	}
	
	@BeforeMethod 
	public void Intialzation () throws Exception {
		Setup();
		LF= new Login_Functionality(driver);
		Hs = new Homesearch(driver);
	    sp = new SearchProduct(driver);
		Cat = new CategoryCart(driver);
		bc= new BannerCart(driver);
		fb = new Footerbanner(driver);
		ws= new Wishlistcart(driver);
		LF.logindata();


}
	@Test
	public void Verifycart() {
		Hs.Homeserrch();
	}
	
	@Test 
	public void Verifysearchcart() throws Exception {
	sp.Searchprod();
	}
	
	@Test 
	public void Verifycatgrycart() {
		Cat.AddCart();
	}
	@Test  
	public void  Verifybancart() throws Exception {
		
		bc.Bannercart1();
			
     }
	@Test 
	public void  Verifyfootbanr() throws Exception {
		
		fb.footban();
	}
	@Test 
	public void  Verifydeal() throws Exception {
		
		fb.dealday();
	}
	@Test
	public void verifywishcart() {
		ws.VerifyWish();
	}
	
	@AfterMethod
	public void clos() {
		driver.close();
	}

	
}
