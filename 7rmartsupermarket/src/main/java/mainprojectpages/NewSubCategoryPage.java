package mainprojectpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtilities;
import utilities.WaitUtility;

public class NewSubCategoryPage {
	public WebDriver driver;
	PageUtilities pageutilities=new PageUtilities();
	FileUploadUtility file1=new FileUploadUtility();
	WaitUtility waitutility=new WaitUtility();
	public NewSubCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//select[@id='cat_id']") WebElement dropdown;
	@FindBy(xpath="//input[@type='text']") WebElement subcat;
	@FindBy(xpath="//input[@type='file']") WebElement upload;
	@FindBy(xpath="//button[@type='submit']") WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement success;
	public NewSubCategoryPage clickonSelect()
	{
		pageutilities.selectByVisibleTest(dropdown, "veggies");
		return this;
	}
	public NewSubCategoryPage clickonSubCategory(String item)
	{
		subcat.sendKeys(item);
		return this;
	}
	public NewSubCategoryPage clickonchooseFile()
	{
		file1.fileUploadForSendKey(upload, Constant.PATH);
		return this;
	}
	public NewSubCategoryPage clickonSave()
	{
		JavascriptExecutor javascript=(JavascriptExecutor) driver;
		javascript.executeScript("window.scrollBy(0, 500)");
		javascript.executeScript("arguments[0].click();",save);
		waitutility.waitForElementToBeClick(driver, save);
		return this;
		
	}
	public boolean isSuccessAlertDisplayed()
	{
		return success.isDisplayed();
	}
	

}
