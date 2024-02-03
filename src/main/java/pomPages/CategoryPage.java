package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CategoryPage {
	
	//Declaration
		@FindBy(xpath = "//h1[normalize-space(text())='C List']")
		private WebElement pageHeader;
		
		@FindBy(xpath = "//a[text()=' New']")
		private WebElement newButton;
		
		@FindBy(name = "delete")
		private WebElement deleteButton;
		
		private String deletePath =("//td[text()='%s']/ancestor::tr"
				+"/desendent::button[text()='Delete']");
		
		@FindBy(xpath = "//h4[text()=' Success!']")
		private WebElement successMessage;
		
		//Initialization
		public CategoryPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Utilization
		public String getPageHeader() {
			return pageHeader.getText();
		}
		
		public void clickNewButton() {
			newButton.click();
		} 
		
		public void deleteCategory(WebDriverUtility web,String categoryName) {
			web.convertPathToWebElement(deletePath, categoryName).click();
			deleteButton.click();
		}
		
		public String getsuccessMessage() {
			return successMessage.getText();
		}
    
}
