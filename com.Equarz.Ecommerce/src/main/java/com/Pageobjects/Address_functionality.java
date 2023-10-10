package com.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.Utils;
import com.base.Testbase;


public class Address_functionality extends Testbase{
Utils uts =new Utils() ;
	Actions act=new	Actions(driver);
@FindBy(xpath="//small[text()='Hello, sairam']")
WebElement dashboard;
@FindBy(xpath="//a[text()=' My profile']")
WebElement profile;
@FindBy(xpath="//a[text()='Address '] ")
WebElement address;
@FindBy(xpath="//label[text()='Permanent']")
WebElement type;
@FindBy(id="add_new_address")
WebElement newaddress;
@FindBy(id="name")
WebElement name;
@FindBy(id="phone")
WebElement number;
@FindBy(id="address-city")
WebElement city;
@FindBy(xpath="//select[@name='country']")
WebElement drop1;
@FindBy(xpath="//input[@role='textbox']")
WebElement box;
@FindBy(id="zip")
WebElement zipcode;
@FindBy(xpath="//button[@class='btn dropdown-toggle btn-light']")
WebElement button;
@FindBy(xpath="//span[text()='India']")
WebElement countryname;
@FindBy(id="address")
WebElement ouraddress;
public Address_functionality(WebDriver driver)
{
PageFactory.initElements(driver,this);	
}
public void Addressselection(String personname,String phonenumber,String cityname,
		String pincode,String addressofperson) throws Throwable
{
act.moveToElement(dashboard).build().perform();
Thread.sleep(2000);
profile.click();
address.click();
newaddress.click();
type.click();
name.sendKeys(personname);
number.sendKeys(phonenumber);
city.sendKeys(cityname);
zipcode.sendKeys(pincode);
button.click();
box.sendKeys(props.getProperty("Country"));
countryname.click();
//uts.dropdown(address, "India");
ouraddress.sendKeys(addressofperson);

}

}

