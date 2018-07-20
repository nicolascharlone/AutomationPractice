package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSummaryPage {

	WebDriver driver;
	
	public ShoppingCartSummaryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElements	
	@FindBy(how = How.CSS, using = "#order-detail-content")
	private WebElement cartSummary;
	
	@FindBy(how = How.CSS, using = ".standard-checkout")
	private WebElement proceedToCheckoutBtn;
	
	public void clickCheckoutBnt() {
		proceedToCheckoutBtn.click();
	}
	
	public boolean isCartSummaryDisplayed() {
		return cartSummary.isDisplayed();
	}
}
