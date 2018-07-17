package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.IndexPage;

public class NavigationBarTests {

	WebDriver driver; 
	
	private IndexPage indexPage; 
	private String url = "http://automationpractice.com/index.php";
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver ();
		indexPage = new IndexPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}

	
	
	@Test(priority=1)
	public void checkOptionsNavBar() {
		Assert.assertTrue(indexPage.allOptionsAreShownInNavBar());
	}
	
	
}
