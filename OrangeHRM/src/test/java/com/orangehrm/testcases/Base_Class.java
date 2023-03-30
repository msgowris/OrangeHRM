package com.orangehrm.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.orangehrm.utilities.Read_Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

	public static WebDriver driver;
	static Read_Configuration rc = new Read_Configuration();

	@Parameters("Browser")
	@BeforeTest
	public void launch_Browser(String Browser) {

		if (Browser.equals("chrome")) {
			driver = WebDriverManager.chromedriver().create();
		} else if (Browser.equals("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
		} else if (Browser.equals("edge")) {
			driver = WebDriverManager.edgedriver().create();
		}

		driver.get(rc.get_Application_URL());
		driver.manage().window().maximize();

	}

	@AfterTest
	public void close_Browser() {
		driver.close();
	}
}
