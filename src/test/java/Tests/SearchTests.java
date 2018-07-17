package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.AuthenticationPage;
import PageObjects.IndexPage;
import PageObjects.MyAccountHomePage;

public class SearchTests {
	
	WebDriver driver;
	private IndexPage indexPage;
	private String url = "http://automationpractice.com/index.php";
	private String searchStr = "women";
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		indexPage = new IndexPage(driver);
	}
	
	@Test
	public void search() {
		indexPage.search(searchStr);
	}
	

}
