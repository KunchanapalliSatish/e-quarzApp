package com.Pageobjects;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Testbase;

public class Wishlistcart extends Testbase{
	
	@FindBy(xpath ="//button[@class='close __close']")
	WebElement Ad1;
	
	
	@FindBy(xpath = "//i[@class='navbar-tool-icon czi-heart']" )
	  WebElement wish;
	  
	@FindBy (xpath ="//a[@href='http://e-quarz.com/product/rts-2-pack-mini-usb-c-type-c-adapter-plug-type-c-female-to-usb-a-male-charger-charging-cable-adapter-converter-compatibl']")
	  WebElement pdct;
	
	@FindBy(xpath = "//span[text()='Add to cart']")
    WebElement cart2;
	
	@FindBy(xpath = "//div[@class='toast toast-success']")
	WebElement success;
	
	public  Wishlistcart (WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	public void VerifyWish() {
		Ad1.click();
		wish.click();
		pdct.click();
		cart2.click();
		 wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		 String msg=wait.until(ExpectedConditions.visibilityOf(success)).getText();
	 	assertEquals("Successfully added!", msg);
	}
	}
	
	


