package com.Equarz.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pageobjects.BannerCart;
import com.Pageobjects.CategoryCart;
import com.Pageobjects.Footerbanner;
import com.Pageobjects.Login_Functionality;
import com.Pageobjects.SearchProduct;
import com.Pageobjects.Wishlist;
import com.base.Testbase;

public class Search  extends Testbase{
	Login_Functionality LF;
	SearchProduct sp;
	CategoryCart Cat;
	BannerCart bc;
	Footerbanner fb;
	Wishlist ws;
	
	public  Search () {
		super();
	}

	@BeforeMethod 
	public void Intialzation () throws Exception {
		Setup();
		sp = new SearchProduct(driver);
		
		LF= new Login_Functionality(driver);
		Cat = new CategoryCart(driver);
		bc= new BannerCart(driver);
		fb = new Footerbanner(driver);
		ws= new Wishlist(driver);
		LF.logindata();
		
		
		
		
   }
	@Test  
	public void  Verifysearch() throws Exception {
		
		//sp.Searchprod();
			
			bc.Bannercart1();
			
	}
		
		
	
	@Test 
	public void Verifysearch1() throws Exception {
	sp.Searchprod();
	}
	@Test 
	public void Verifysearch3() {
		Cat.AddCart();
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
	public void verfy() {
		ws.VerifyWish();
	}
	
	@AfterMethod
	public void clos() {
		driver.close();
	}
}
