package com.Equarz.Testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pageobjects.Login_Functionality;
import com.Pageobjects.Searchdrop_Functionality;
import com.base.Testbase;

public class Dropdowntest extends Testbase{
	Searchdrop_Functionality sf;
	Login_Functionality Login;
	public Dropdowntest() {
		super();
		
	}
	@BeforeMethod
	public void initialize() throws Throwable {
		Setup();
		Login=new Login_Functionality(driver);
		sf=new Searchdrop_Functionality(driver);
		Login.validateLogin();
	}
@Test
public void search1() throws Throwable 
{
sf.search();	
}
	@Test
public void drop() throws Throwable
{
sf.dropdown();	
}
}