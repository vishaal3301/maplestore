package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='property3']") WebElement emailField;
	@FindBy(xpath ="//input[@id='property4']") WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit' and @class='tf-btn w-100 radius-3 btn-fill animate-hover-btn justify-content-center']") WebElement loginButton;
	@FindBy(xpath = "(//i[@class='icon icon-search'])[1]") WebElement searchBtn;
	@FindBy(xpath = "//input[@placeholder='Search']") WebElement searchBar;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String userName, String password) {
		emailField.sendKeys(userName);
		passwordField.sendKeys(password);
		loginButton.click();
	}
	
	public void searchProduct(String productName) {
		searchBtn.click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

         // Click on the search icon in the header
         WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(
             By.className("site-header-search-trigger")
         ));
         searchIcon.click();

         // Wait for the search input field to appear in the sliding panel
         WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
             By.cssSelector(".offcanvas .search-field")));
		searchBar.sendKeys(productName);
		searchBtn.click();
	}
	
}
