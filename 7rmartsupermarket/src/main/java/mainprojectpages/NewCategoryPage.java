package mainprojectpages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtilities;
import utilities.WaitUtility;

public class NewCategoryPage {
	public WebDriver driver;
	WaitUtility waitutility=new WaitUtility();
	FileUploadUtility fileupload=new FileUploadUtility();
	PageUtilities pageutility=new PageUtilities();
	public NewCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='category']") WebElement category;
	@FindBy(id="134-selectable") WebElement groups;
	@FindBy(xpath="//input[@type='file']") WebElement file1;
	@FindBy(xpath="//button[@type='submit']") WebElement save;
	@FindBy(xpath="(//input[@type='radio'])[2]") WebElement radio1;
	@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']") WebElement alert1;
	public NewCategoryPage enterCategory(String category1) 
	{
		category.sendKeys(category1);
		return this;
	}
	public NewCategoryPage selectGroups()
	{
		groups.click();
		return this;
	}
	public NewCategoryPage chooseFile() throws AWTException
	{
		waitutility.waitForElementToBeClick(driver, file1);
		
		fileupload.fileUploadForSendKey(file1, Constant.PATH);
		return this;
	}
	public NewCategoryPage clickonRadioButton()
	{
		
		waitutility.waitForElementToBeClick(driver, radio1);
		radio1.click();
		return this;
	}
	public NewCategoryPage clickOnSave()
	{
		JavascriptExecutor javascript=(JavascriptExecutor) driver;
		javascript.executeScript("window.scrollBy(0, 500)");
		javascript.executeScript("arguments[0].click();",save);
		waitutility.waitForElementToBeClick(driver, save);
		return this;
	}
	public boolean isAlertdisplayed()
	{
		return alert1.isDisplayed();
	}
	
}
