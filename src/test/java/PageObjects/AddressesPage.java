package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage {

	WebDriver driver;
	
	public AddressesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.CSS, using = ".row")
	private WebElement row;
	
	@FindBy(how = How.CSS, using = "#ordermsg > textarea")
	private WebElement addCommentTxt;
	
	@FindBy(how = How.CSS, using = "button.button:nth-child(4)")
	private WebElement proceedToCheckoutBtn;
	
	
	public boolean isRowDisplayed() {
		return row.isDisplayed();
	}
	
	public void addComment(String comment) {
		addCommentTxt.sendKeys(comment);
	}
	
	public void clickCheckoutBnt() {
		proceedToCheckoutBtn.click();
	}
}
