package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utils.Screenshots;
import com.aventstack.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {

	FileInputStream file;
	public static Properties props;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static EventFiringWebDriver edriver;
	Screenshots event;


	public Testbase() {
		
		props = new Properties();
		//ExtentReports

		try {
			file = new FileInputStream("./src/main/java/com/PropertiesConfig/Propfile");
					} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			props.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Setup() {

		String browsername = props.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
             WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browsername.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		}

		else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
//		edriver = new EventFiringWebDriver(driver);
//		event = new Screenshots();
//		edriver.register(event);
//		driver= edriver;

		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.get(props.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//driver.manage().deleteAllCookies();

		
	}
}
