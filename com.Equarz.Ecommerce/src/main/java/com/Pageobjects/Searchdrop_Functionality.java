package com.Pageobjects;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;

public class Searchdrop_Functionality extends Testbase{
@FindBy(xpath="//input[@class='form-control appended-form-control search-bar-input']")
WebElement search;
@FindBy(xpath="//li[@class='list-group-item']")
List<WebElement> dynamic;

public Searchdrop_Functionality(WebDriver driver) {
PageFactory.initElements(driver,this );
}

public void search() throws Throwable
{
	search.sendKeys(props.getProperty("searchboxtext"),Keys.ENTER);
	String str=driver.getCurrentUrl();
	assertEquals("http://e-quarz.com/products?name=laptop&data_from=search&page=1", str);
}
public void dropdown() throws Throwable
{
	search.sendKeys(props.getProperty("searchboxtext"));
	
	for(WebElement dyn:dynamic) {
		Thread.sleep(3000);
		if (dyn.getText().equals("HP Laptop 14s, 12th Gen Intel Core i3-1215U, 14-inch (35.6 cm), FHD, 8GB DDR4, 5")) {
			dyn.click();
			String str1=driver.getCurrentUrl();
			assertEquals("http://e-quarz.com/product/hp-14s-12th-gen-intel-core-i5-16gb-ram512gb-ssd-14-inch356-cm-micro-edge-fhd-laptopintel-iris-xe-graphicsalexadual-speak", str1);
	}
	}
}
}