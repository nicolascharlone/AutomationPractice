package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {

	WebDriver driver;
	private String noResultMsj = "No results were found for your search".toUpperCase();
	private String addToCartBtnLocator = ".product-container > .row > .right-block > .row > .button-container > a:nth-child(1)";
	private String productSuccessfullyAddedMsj = "Product successfully added to your shopping cart".toUpperCase();
	
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
	
	@FindBy(how = How.CSS, using = ".icon-th-list")
	private WebElement viewAsList;
	
	@FindBy(how = How.CSS, using = "#layer_cart")
	private WebElement addedToCartConfirmation;
	
	@FindBy(how = How.CSS, using = ".layer_cart_product > h2:nth-child(2)")
	public WebElement addedConfirmation;
	
	@FindBy(how = How.CSS, using = "a.button-medium > span:nth-child(1)")
	public WebElement proceedToCheckoutBtn;
	
	//Methods
	
	public void clickLogo() {
		logo.click();
	}
	
	public void clickProceedToCheckoutBtn() {	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutBtn));		
		proceedToCheckoutBtn.click();
	}
	
	public List<WebElement> getSearchResultElements(){
		List<WebElement> elements = null;
		if(searchResultItems.isDisplayed()) {
			elements = searchResultItems.findElements(By.tagName("li"));
		}		
		return elements;
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
	
	private String getProductName(WebElement element) {
		String productName = "";
		WebElement productNameElement = element.findElement(By.tagName("a"));
		productName = productNameElement.getAttribute("title").toUpperCase();		
		return productName;
	}
	
	private WebElement getProductElement(String productName) {
		List<WebElement> elements = getSearchResultElements();
		WebElement element = null;
		if(elements.size() > 0) {
			for(WebElement e : elements) {
				if(getProductName(e).contains(productName.toUpperCase())) {
					element = e;
				}
			}
		}	
		return element;
	}
	
	public void clickAddToCart(WebElement element) {
		WebElement button = element.findElement(By.cssSelector(addToCartBtnLocator));
		button.click();
	}
	
	public void seeProductsAsList() {
		viewAsList.click();
	}

	public void addToCartCheckOut(String productName) {
		if(areResultsAfterSearch()) {
			seeProductsAsList();
			WebElement element = getProductElement(productName);
			if(element != null) {
				clickAddToCart(element);
			}
		}
	}
	

	
}
