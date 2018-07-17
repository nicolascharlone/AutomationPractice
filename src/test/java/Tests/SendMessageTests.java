package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.ContactUsPage;
import PageObjects.IndexPage;

public class SendMessageTests {
	
	WebDriver driver;
	private IndexPage indexPage;
	private ContactUsPage contactUsPage;
	private String url = "http://automationpractice.com/index.php";
	
	//Data
	String subject = "Customer service";
	String email = "test@test.com";
	String order = "this is a test";
	String message = "this is a test message";
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		indexPage = new IndexPage(driver);
		contactUsPage = new ContactUsPage(driver);
		driver.get(url);
	}
	
	
	@Test
	public void clickContactUs() {
		indexPage.clickContactUs();
		Assert.assertTrue(contactUsPage.pageIsLoaded());
	}
	
	@Test
	public void sendMessage() {
		contactUsPage.sendMessage(subject, email, order, message);
		Assert.assertTrue(contactUsPage.isMessageSuccessfullySent());
		
	}
	

}
