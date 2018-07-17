package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.AuthenticationPage;
import PageObjects.IndexPage;
import PageObjects.MyAccountHomePage;
import PageObjects.SearchResultsPage;

public class SearchTests {
	
	WebDriver driver;
	private IndexPage indexPage;
	private SearchResultsPage searchResultsPage;
	private String url = "http://automationpractice.com/index.php";
	private String validSearchStr = "dress";
	private String invalidSearchStr = "women";
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		indexPage = new IndexPage(driver);
		searchResultsPage = new SearchResultsPage(driver);
	}
	
	@Test(priority=0)
	public void searchValidString() {
		indexPage.search(validSearchStr);
		Assert.assertTrue(searchResultsPage.areResultsAfterSearch());
	}
	
	@Test(priority=1)
	public void searchInvalidString() {
		searchResultsPage.clickLogo();
		indexPage.search(invalidSearchStr);
		Assert.assertTrue(searchResultsPage.isNoResultMessage());
	}
	

}
