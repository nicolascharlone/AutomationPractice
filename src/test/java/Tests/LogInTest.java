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

public class LogInTest {
	
	WebDriver driver;
	private String url = "http://automationpractice.com/index.php";
	private IndexPage indexPage;
	private AuthenticationPage authenticationPage;
	private MyAccountHomePage myAccountHomePage;
	
	private String username = "ncharlone@altimetrik.com";
	private String password = "Altimetrik123";
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		indexPage = new IndexPage(driver);
		authenticationPage = new AuthenticationPage(driver);
		myAccountHomePage = new MyAccountHomePage(driver);
		indexPage.clickSignIn();
	}
	
	@Test(priority=0)
	public void signIn() {
		authenticationPage.signIn(username, password);
		Assert.assertTrue(myAccountHomePage.accountSuccessfullySignedIn());
	}
	

}
