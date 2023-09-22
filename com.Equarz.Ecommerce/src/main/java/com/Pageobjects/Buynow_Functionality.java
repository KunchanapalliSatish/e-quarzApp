package com.Pageobjects;

	import static org.testng.Assert.assertEquals;

	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import com.Utils.Utils;
	import com.base.Testbase;

	public class Buynow_Functionality  extends Testbase{
		@FindBy(xpath="//a[@href='http://e-quarz.com/product/earpods-boat-W0CoIT']")
		WebElement product;
		
		@FindBy(xpath="//span[text()='Buy now']")
		WebElement buynow;
		@FindBy(xpath="//select[@class='form-control']")
		WebElement chooseshippingmethod;
		Utils ul;
		
		//@FindBy(xpath="//select[@class='form-control']")
	    //WebElement companyvehicle;
		@FindBy(id="order_note")
		WebElement  ordernote;
		@FindBy (xpath="//a[@class='btn btn--primary']")
		WebElement continueshopping;
		
		@FindBy(xpath="//a[@onclick='checkout()']")
		WebElement checkout;
		
	public Buynow_Functionality (WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}
	 

	         public Homepage Buynow( ) throws Throwable {
	        	JavascriptExecutor js =(JavascriptExecutor)driver;
	    		  js.executeScript("window.scrollBy(0,1100)","");
	    		
	        	 product.click();
	        	 Thread.sleep(2000);
	        	 buynow.click();
	        	 
	        	
	        	// Actions act =new Actions(driver);
	     		//act.moveToElement(buynow).build().perform();
	     		
	     		//JavascriptExecutor js =(JavascriptExecutor)driver;
	     		  //js.executeScript("window.scrollBy(0,550)","");
	     		
	     		//cartQuantity.click();
	     		chooseshippingmethod.click();
	     		ul=new Utils ();
	     		ul.dropdown(chooseshippingmethod, "2");
	     		//ordernote.click();
	     	JavascriptExecutor jd =(JavascriptExecutor)driver;
	  		  jd.executeScript("window.scrollBy(0,500)","");

	   		  
	     		continueshopping.click();
	     		checkout.click();
	    		return new Homepage();

	     		
	     		
	         }
		

	}


