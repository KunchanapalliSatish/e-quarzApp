package com.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Categories_Functionality {
	//@FindBy(xpath = "//button[@class='close __close']")
	//WebElement popup;
		   @FindBy(xpath="//span[text()='Books']")
	WebElement category;
		@FindBy(xpath="//span[text()='Exam central']")
	   WebElement subcategory;
	@FindBy(xpath="//a[@href='http://e-quarz.com/product/capf-paper-2-general-studies-essay-comprehension-0zUwES']")
	WebElement product;
	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement cart;

	public Categories_Functionality(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public Homepage Category_product(WebDriver driver) throws Exception {
		//popup.click();
		Actions act = new Actions(driver);
		act.moveToElement(category).build().perform();
		Thread.sleep(2000);
		act.moveToElement(subcategory).build().perform();
		subcategory.click();
		Thread.sleep(2000);
		product.click();
		cart.click();

		return new Homepage();
	}
}
