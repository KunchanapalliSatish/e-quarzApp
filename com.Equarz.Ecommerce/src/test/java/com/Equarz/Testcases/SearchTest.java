package com.Equarz.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pageobjects.Banner_Functionality;
import com.Pageobjects.Categories_Functionality;
import com.Pageobjects.Login_Functionality;
import com.Pageobjects.Search_functionality;
import com.base.Testbase;

public class SearchTest extends Testbase{
Login_Functionality Login;
Categories_Functionality category1;
Search_functionality product;
Banner_Functionality banner1;

	
	public SearchTest() {
		super();
		
	}
	@BeforeMethod
	
	public void initialize() {
		Setup();
		Login=new Login_Functionality(driver);
		//category1=new Categories_Functionality(driver);
		product=new Search_functionality(driver);
		banner1=new Banner_Functionality(driver);
	}
	@Test
	public void cat() throws Exception {
		Login.validateLogin();
		//category1.Category_product(driver);
		product.Search_product();
		//banner1.Banner_add(driver);
		
	}
	@AfterMethod
	public void shutdown() 
	{
		driver.close();
	}
	

}
