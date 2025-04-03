package mainprojectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtilities;

public class NewAdminUserPage {
	public WebDriver driver;
	PageUtilities pageutilities=new PageUtilities();
	public NewAdminUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@type='password']") WebElement password;
	@FindBy(xpath="//input[@id='username']") WebElement username;
	@FindBy(xpath="//select[@id='user_type']") WebElement dropdown;
	@FindBy(xpath="(//button[@type='submit'])[2]") WebElement save;
	@FindBy(xpath="(//a[text()='Reset'])[2]") WebElement reset;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert1;
	
	public boolean isPasswordDisplayed()
	{
		return password.isDisplayed();
	}
	public NewAdminUserPage enterUsernameAndPasswordToCreateNewAdmin(String username1,String password1)
	{
		username.sendKeys(username1);
		password.sendKeys(password1);
		return this;
	}
	public NewAdminUserPage selectValues()
	{
		pageutilities.selectByVisibleTest(dropdown, "Admin");
		return this;
		
		
	}
	public NewAdminUserPage clickOnSave()
	{
		save.click();
		return this;
	}
	public boolean isAlertDisplayed()
	{
		return alert1.isDisplayed();
	}
	public NewAdminUserPage clickOnReset()
	{
		reset.click();
		return this;
	}

}
