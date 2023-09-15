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

public class BannerCart extends Testbase {
//	@FindBy(xpath ="//button[@class='close __close']")
//	WebElement Ad1;
	
	@FindBy(xpath = "//li[@data-slide-to='2']")
	WebElement slide;
	
	
	@FindBy(xpath = "//img[@src='http://e-quarz.com/storage/app/public/banner/2023-07-21-64ba5d58940f6.png']")
	WebElement banner;
	
	
	@FindBy(xpath = "//a[@href='http://e-quarz.com/product/raymond-mens-flat-front-slim-fit-dark-grey-formal-trouser-a5Q5y1']")
	WebElement Pant;
	
	@FindBy(xpath = "//span[text()='Add to cart']")
    WebElement cart2;
	
	@FindBy(xpath = "//div[@class='toast toast-success']")
	WebElement success;
	
	public  BannerCart (WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	public void Bannercart1() {
		//Ad1.click();
		slide.click();
//		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.visibilityOf(banner));
		banner.click();
		Pant.click();
		cart2.click();
		 wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		 String msg=wait.until(ExpectedConditions.visibilityOf(success)).getText();
	 	assertEquals("Successfully added!", msg);
	}
	
	
}
