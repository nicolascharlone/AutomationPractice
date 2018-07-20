package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.AddressesPage;
import PageObjects.AuthenticationPage;
import PageObjects.IndexPage;
import PageObjects.SearchResultsPage;
import PageObjects.ShippingPage;
import PageObjects.ShoppingCartSummaryPage;
import junit.framework.Assert;

public class BuyShortTest {
	
	WebDriver driver;
	
	private String url = "http://automationpractice.com/index.php";
	private String searchStr = "short";
	private String productName = "Printed Dress";
	private IndexPage indexPage;
	private SearchResultsPage searchResultsPage;
	private ShoppingCartSummaryPage shoppingCartSummaryPage;
	private AuthenticationPage authenticationPage;
	private AddressesPage addressesPage;
	private ShippingPage shippingPage;
	
	private String username = "ncharlone@altimetrik.com";
	private String password = "Altimetrik123"; 
	private String commentAddress = "This is a comment for the address";
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		indexPage = new IndexPage(driver);
		searchResultsPage = new SearchResultsPage(driver);	
		shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
		authenticationPage = new AuthenticationPage(driver);
		addressesPage = new AddressesPage(driver);
		shippingPage = new ShippingPage(driver);
	}
	
	@Test(priority=0)
	public void searchProduct() {
		indexPage.search(searchStr);
		Assert.assertTrue(searchResultsPage.areResultsAfterSearch());
	}
	
	@Test(priority=1)
	public void addToCartCheckOut() {
		searchResultsPage.addToCartCheckOut(productName);
		searchResultsPage.clickProceedToCheckoutBtn();
		Assert.assertTrue(shoppingCartSummaryPage.isCartSummaryDisplayed());
	}
	
	@Test(priority=2)
	public void proceedFromCartSummary() {
		shoppingCartSummaryPage.clickCheckoutBnt();
		Assert.assertTrue(authenticationPage.isRowDisplayed());
	}
	
	@Test(priority=3)
	public void signIn() {
		authenticationPage.signIn(username, password);
		Assert.assertTrue(addressesPage.isRowDisplayed());
	}
	
	@Test(priority=4)
	public void addCommentAndProceed() {
		addressesPage.addComment(commentAddress);
		addressesPage.clickCheckoutBnt();
		Assert.assertTrue(shippingPage.isShippingDisplayed());
	}
	
	@Test(priority=5)
	public void proceedFromShipping() {
		shippingPage.checkAgreeTerms();
		shippingPage.clickCheckoutBnt();
	}
	

	
	
}
