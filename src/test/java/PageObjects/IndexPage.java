package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

	WebDriver driver;
	
	public IndexPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// WebElements
	@FindBy(how = How.CSS, using = ".login")
	private WebElement signInBtn;
	
	//Methods
	public void clickSignIn() {
		signInBtn.click();
	}
	
}
