package com.Pageobjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;

public class Wishlist_Functionality extends Testbase {
	int i, j;

	@FindBy(xpath = " (//span[text()='Books'])[1]")
	WebElement category;
	@FindBy(xpath = "(//span[text()='School text books'])[1]") // FROM CATEGORY
	WebElement subcat;
	@FindBy(xpath = "//a[@href='http://e-quarz.com/product/ncert-text-bookexemplar-problems-solutions-mathematics-class-10-8C8xbH']")
	WebElement book;
	@FindBy(xpath = "//button[@class='btn __text-18px text-danger'] ")
	WebElement wishlist;

	@FindBy(xpath = "//span[@class='carousel-control-next-icon']")
	WebElement sidearrow;
	@FindBy(xpath = "(//img[@class='d-block w-100 __slide-img'])[2]")
	WebElement banner;
	@FindBy(xpath = "//a[@href='http://e-quarz.com/product/selvia-women-dress-isfrnK']")
	WebElement dress;

	@FindBy(xpath = "//input[@class='form-control appended-form-control search-bar-input']")
	WebElement search;
	@FindBy(xpath = "//button[@class='input-group-append-overlay search_button']") // SEARCHWISLIST
	WebElement searchbtn;
	@FindBy(xpath = "//a[@href='http://e-quarz.com/product/mouse-hp-hHfrUI']")
	WebElement product;

	@FindBy(xpath = "(//a[@href='http://e-quarz.com/product/esd-safe-pcb-magazine-rack-ByUIpG'])[1]")
	WebElement homeproduct;
	@FindBy(xpath = "//a[@class='navbar-tool-icon-box bg-secondary dropdown-toggle']")
	WebElement icon;
	@FindBy(id = "set-wish-list")
	List<WebElement> wishitem;
	@FindBy(xpath = "//span[@class='countWishlist']")
	WebElement wishcount;
	@FindBy(xpath = " //img[@class='d-block footer_banner_img __inline-63'] ")
	WebElement footban;

	@FindBy(xpath = "//a[@href='http://e-quarz.com/product/aurelia-womens-cotton-kurta-cWdeUS']")
	WebElement prdt;
	@FindBy(xpath = "//button[@class='buy_btn']")
	WebElement dealbuy;
	@FindBy(xpath = "//i[@class='czi-close-circle']")
	WebElement remove;
	@FindBy(xpath = "//div[@aria-labelledby='swal2-title']")
	List<WebElement> popup;
	@FindBy(xpath = "//button[text()='OK']")
	WebElement ok;

	public Wishlist_Functionality(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void categorylist() {

		Actions act = new Actions(driver);
		act.moveToElement(category).build().perform();
		subcat.click();
		book.click();
		wishlist.click();

	}

	public void bannerlist() throws Throwable {
		sidearrow.click();
		banner.click();
		dress.click();
		wishlist.click();
		Thread.sleep(2000);
		icon.click();
		for (WebElement wish : wishitem) {
			String str = wish.getText();
			Thread.sleep(2000);
			remove.click();
			for (WebElement pop : popup) {
				String str1 = pop.getText();
				System.out.println(str1);
				assertTrue(str1.contains("Product has been remove from wishlist!"), str1);
			}
	}
	}
	public void searchlist() throws Throwable {
		search.sendKeys("Mouse Hp");
		searchbtn.click();
		product.click();
		wishlist.click();
		Thread.sleep(2000);
		icon.click();
		for (WebElement wish : wishitem) {
			String str = wish.getText();
			Thread.sleep(2000);
			remove.click();
			for (WebElement pop : popup) {
				String str1 = pop.getText();
				System.out.println(str1);
				assertTrue(str1.contains("Product has been remove from wishlist!"), str1);
//	driver.navigate().refresh();
			}
		}
	}

	public void homelist() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)", "");
		homeproduct.click();
		wishlist.click();
	}

	public void footerbannerlist() {
		String str=wishcount.getText();
    	i=Integer.parseInt(str);
    	//i=i+1;
		footban.click();
		prdt.click();
		wishlist.click();
		String str1=wishcount.getText();
    	j=Integer.parseInt(str1);
	   assertEquals(j,i);
	}

	public void dealoflist() throws Throwable {
		String str=wishcount.getText();
    	i=Integer.parseInt(str);
    			Thread.sleep(2000);
		dealbuy.click();
		wishlist.click();
		String str1=wishcount.getText();
    	j=Integer.parseInt(str1);
	   assertEquals(j,i);
	}
}
