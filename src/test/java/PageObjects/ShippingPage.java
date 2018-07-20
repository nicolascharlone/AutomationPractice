package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {

	WebDriver driver;
	
	public ShippingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS, using = ".order_carrier_content")
	private WebElement shippingRow;
	
	@FindBy(how = How.CSS, using = "#cgv")
	private WebElement agreeTermsChk;
	
	@FindBy(how = How.CSS, using = ".standard-checkout")
	private WebElement proceedToCheckoutBtn;
	
	
	public void checkAgreeTerms() {
		agreeTermsChk.click();
	}
	
	public boolean isShippingDisplayed() {
		return shippingRow.isDisplayed();
	}
	
	public void clickCheckoutBnt() {
		proceedToCheckoutBtn.click();
	}
}
