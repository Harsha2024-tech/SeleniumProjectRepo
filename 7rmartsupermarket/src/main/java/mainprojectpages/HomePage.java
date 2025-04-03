package mainprojectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	WaitUtility waitutility=new WaitUtility();
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[@class='nav-link'])[2]") WebElement link;
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]") WebElement logout;
	@FindBy(xpath="//input[@placeholder='Username']") WebElement username;
	@FindBy(xpath="(//a[@class='small-box-footer'])[1]") WebElement adminUsers;
	@FindBy(xpath="(//a[@class='small-box-footer'])[3]") WebElement category;
	@FindBy(xpath="(//a[@class='small-box-footer'])[4]") WebElement subcategory;
	public AdminUsersPage clickOnAdminMoreInfo()
	{
		adminUsers.click();
		return new AdminUsersPage(driver);
	}
	public HomePage clickOnAdmin()
	{
		waitutility.waitForElementToBeClick(driver, link);
		link.click();
		return this;
	}
	public HomePage clickOnLogout()
	{
		logout.click();
		return this;
	}
	public CategoryPage clickOnMoreInfoOnCategoryPage()
	{
		category.click();
		return new CategoryPage(driver);
	}
	public boolean isUsernameDisplayed()
	{
		return username.isDisplayed();
		 
	}
	public SubCategoryPage clickOnMoreInfoOnSubCategory()
	{
		subcategory.click();
		return new SubCategoryPage(driver);
	}
	

}
