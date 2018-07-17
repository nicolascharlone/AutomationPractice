package PageObjects;

import java.net.SocketTimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {
	
	WebDriver driver;
	private String heading = "Customer service - Contact us".toUpperCase();
	private String messageSuccessfullySentMsj = "Your message has been successfully sent to our team.".toUpperCase();
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	//WebElements
	
	@FindBy(how = How.CSS, using = ".page-heading")
	private WebElement pageHeading;
	
	@FindBy(how = How.CSS, using = "#id_contact")
	private WebElement SubjectHeadingSlc;
	
	@FindBy(how = How.CSS, using = "#email")
	private WebElement emailTxt;
	
	@FindBy(how = How.CSS, using = "#id_order")
	private WebElement orderReferenceTxt;
	
	@FindBy(how = How.CSS, using = "#message")
	private WebElement messageTxt;
	
	@FindBy(how = How.CSS, using = "#submitMessage")
	private WebElement sendBtn;
	
	@FindBy(how = How.CSS, using = ".alert")
	private WebElement alertSuccessMsj;
	
	//Methods
	public void selectSubject(String subject) {
		Select subSelect = new Select(SubjectHeadingSlc);
		subSelect.selectByVisibleText(subject);
	}

	public boolean pageIsLoaded() {
		return pageHeading.getText().toUpperCase().contains(heading);
	}

	public void sendMessage(String subject, String email, String order, String message) {
		selectSubject(subject);
		emailTxt.sendKeys(email);
		orderReferenceTxt.sendKeys(order);
		messageTxt.sendKeys(message);
		sendBtn.click();	
	}
	
	public boolean isMessageSuccessfullySent() {
		return alertSuccessMsj.getText().toUpperCase().contains(messageSuccessfullySentMsj);
	}
	


}
