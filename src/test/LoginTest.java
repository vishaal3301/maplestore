package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;


public class LoginTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://www.maplestore.in/account/login?rUrl=/account");
	}
	
	@Test(priority = 0)
	public void testLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("vishalkhairnarSDET@gmail.com", "vishal@1234");
		
		loginPage.searchProduct("iphone 11");
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Successfull");
	}
	

}
