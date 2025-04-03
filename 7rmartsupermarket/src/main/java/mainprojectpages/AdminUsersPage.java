package mainprojectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminUsersPage {
	public WebDriver driver;
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newButton;
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newUser;
	@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement search;
	public SearchAdminUser clickOnSearch()
	{
		search.click();
		return new SearchAdminUser(driver);
	}
	public  NewAdminUserPage clickOnNew()
	{
		newUser.click();
		return new NewAdminUserPage(driver);
	}
	
	public boolean isNewButtonDisplayed()
	{
		return newButton.isDisplayed();
	}

}
