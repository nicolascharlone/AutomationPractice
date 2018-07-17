package PageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

	WebDriver driver;
	private List<String> optionsNavBar = Arrays.asList("WOMEN","DRESSES","T-SHIRTS");
	
	public IndexPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// WebElements
	@FindBy(how = How.CSS, using = ".login")
	private WebElement signInBtn;
	
	@FindBy(how = How.CSS, using = "#contact-link")
	private WebElement contactBtn;
	
	@FindBy(how = How.CSS, using = ".sf-menu")
	private WebElement navBar;
	
	@FindBy(how = How.CSS, using = "#search_query_top")
	private WebElement searchTxt;
	
	@FindBy(how = How.CSS, using = "#searchbox > button")
	private WebElement searchBtn;
	
	//Methods
	public void clickSignIn() {
		signInBtn.click();
	}
	
	public void clickContactUs() {
		contactBtn.click();
	}
	
	public boolean allOptionsAreShownInNavBar() {
		List<WebElement> optionsInNav = navBar.findElements(By.cssSelector("li>a"));
		boolean allAreDisplayed = false;
		
		for(WebElement element : optionsInNav) {
			if(optionsNavBar.contains(element.getAttribute("title").toUpperCase())) {
				allAreDisplayed = true;
			} 
			else {
				allAreDisplayed = false;
			}
		}
		return allAreDisplayed;
	}
	
	public void search(String search) {
		searchTxt.sendKeys(search);
		searchBtn.click();	
	}
	
}
