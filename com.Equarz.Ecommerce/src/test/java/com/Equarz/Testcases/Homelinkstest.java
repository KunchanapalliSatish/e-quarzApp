package com.Equarz.Testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Pageobjects.Homepagelinks;
import com.Pageobjects.Login_Functionality;
import com.base.Testbase;

public class Homelinkstest extends Testbase{
	Login_Functionality Login;
	Homepagelinks hl;
	public Homelinkstest()
	{
		super();
	}
@BeforeClass
public void initialise() throws Throwable
{
Setup();
Login= new Login_Functionality(driver);
hl=new Homepagelinks(driver);
Login.validateLogin();
}
@Test
public void feature()
{
	hl.feature();	
}
@Test
public void twitter() throws Throwable
{
hl.tweet();	
}
@Test
public void Instagram() throws Throwable
{
hl.insta();	
}
@AfterClass
public void teardown()
{
driver.close();	
}
}
