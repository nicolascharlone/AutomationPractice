package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage {
	
	WebDriver driver;
	
	public AuthenticationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElements
	@FindBy(how = How.CSS, using =  "#email_create")
	private WebElement emailCreateTxt;
	
	@FindBy(how = How.CSS, using = "#SubmitCreate")
	private WebElement submitCreateBtn;
	
	@FindBy(how = How.CSS, using = "#email")
	private WebElement emailTxt;
	
	@FindBy(how = How.CSS, using = "#passwd")
	private WebElement passwordTxt;
	
	@FindBy(how = How.CSS, using = "#SubmitLogin")
	private WebElement signInBtn;
	
	//Methods
	
	public void signIn(String username, String password) {
		emailTxt.sendKeys(username);
		passwordTxt.sendKeys(password);
		signInBtn.click();
	}
	
	public void clickCreateAnAccountBtn() {
		submitCreateBtn.click();
	}

}
