package com.Pageobjects;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Testbase;

public class SearchProduct extends Testbase {
//	@FindBy(xpath ="//button[@class='close __close']")
//	WebElement Ad;

	
	@FindBy(xpath ="//input[@placeholder='Search here ...']")
	WebElement searchbox;
	
	@FindBy(xpath="//i[@class='czi-search text-white']")
	WebElement searchbutton;
	
	@FindBy(name  = "//a[@href='http://e-quarz.com/product/hp-247-g8-laptop-amd-athlon-p-3045b-hd-14-inches355cm-hd-8gb-ram-ddr4-1tb-hddwindows-11-home-w11-sl-one-year-warranty-bl']//*")
	WebElement prod;
	
	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement cart;
	
	@FindBy(xpath = "//div[@class='toast toast-success']")
	WebElement success;
	
	
	public  SearchProduct (WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	public productpage Searchprod () throws Exception {
		//Ad.click();
		searchbox.sendKeys(props.getProperty("searchboxtext"));
		searchbutton.click();
		prod.clear();
		Thread.sleep(3000);
		cart.click();
		 wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		 String msg=wait.until(ExpectedConditions.visibilityOf(success)).getText();
	 	assertEquals("Successfully added!", msg);
		return new productpage();
		
	}
	

}
