package com.Equarz.Testcases;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pageobjects.Login_Functionality;
import com.Reports.ExtentReports1;
import com.Utils.Utils;
import com.aventstack.extentreports.ExtentTest;
import com.base.Testbase;

public class LoginTest extends Testbase{
	int testid;

Login_Functionality lg;
ExtentReports1 extentreports;
	
	public LoginTest() {
		super();
		
	}
	@BeforeMethod
	
	public void initialize() {
		Setup();
		lg=new Login_Functionality(driver);
	}
	@Test  (testName = "test1")
	public void verifylog() throws Throwable {
		
		lg.validateLogin();
		String url=driver.getCurrentUrl();
		Assert.assertEquals("http://e-quarz.com/", url);
		
	}
	@AfterMethod
	public void shutdown() throws Exception 
	{
		driver.close();
		
		
	}
	@Test
	public void verifyurl() throws Throwable {
		lg.validateLogin();
		String url=driver.getCurrentUrl();
		Assert.assertEquals("http://e-quarz.com/", url);
		
	   
		
	}
	@AfterSuite
	
	public void report() throws IOException {
		 Desktop.getDesktop().browse(new File("Extent.html").toURI());
		
	}
	
//	    @AfterSuite
//	    public void tearDown() {
//	        ExtentReportManager.getInstance().flush();
//	    }
	}





