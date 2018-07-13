package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyAccountHomePage {
	
	WebDriver driver;
	private static String welcomeMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";
	
	public MyAccountHomePage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	
	//WebElements
	@FindBy(how = How.CSS, using = ".info-account")
	private WebElement infoAccountTxt;
	
	//Methods
	public boolean accountSuccessfullySignedIn() {
		return infoAccountTxt.getText().contains(welcomeMessage);
	}
	
}
