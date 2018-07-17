package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

	WebDriver driver;
	private String noResultMsj = "No results were found for your search".toUpperCase();
	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElements
	@FindBy(how = How.CSS, using= ".product_list")
	private WebElement searchResultItems;
	
	@FindBy(how = How.CSS, using = ".alert")
	private WebElement noResultAlert;
	
	@FindBy(how = How.CSS, using = ".logo")
	private WebElement logo;
	
	
	//Methods
	
	public void clickLogo() {
		logo.click();
	}
	
	public boolean areResultsAfterSearch() {
		boolean result = false;
		if(searchResultItems.isDisplayed()) {
			List<WebElement> elements = searchResultItems.findElements(By.tagName("li"));
			if(elements.size() >= 1) {
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}


	public boolean isNoResultMessage() {
		boolean result = false;
		if(noResultAlert.isDisplayed()) {
			if(noResultAlert.getText().toUpperCase().contains(noResultMsj)) {
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}
	
	
}
