package mainprojectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchAdminUser {
	public WebDriver driver;
	public SearchAdminUser(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='un']") WebElement username;
	@FindBy(xpath="//select[@id='ut']") WebElement usertype;
	@FindBy(xpath="(//button[@class='btn btn-block-sm btn-danger'])[1]") WebElement searchUser;
	@FindBy(xpath="(//a[text()='Reset'])[1]") WebElement reset;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']") WebElement table;
	public SearchAdminUser enterUsername(String username1)
	{
		username.sendKeys(username1);
		return this;
	}
	public SearchAdminUser selectUserType()
	{
		Select select=new Select(usertype);
		select.selectByVisibleText("Admin");
		return this;
	}
	public SearchAdminUser clickOnSearchUser()
	{
		searchUser.click();
		return this;
	}
	public SearchAdminUser clickOnReset()
	{
		reset.click();
		return this;
	}
	public boolean isSearchdisplayed()
	{
		return searchUser.isDisplayed();
	}
	public boolean isTabledisplayed()
	{
		return table.isDisplayed();
	}

}
