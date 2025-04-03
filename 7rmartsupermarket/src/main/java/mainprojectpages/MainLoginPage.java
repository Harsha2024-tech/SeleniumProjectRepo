package mainprojectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainLoginPage {
	public WebDriver driver;
	public MainLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@placeholder='Username']") WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement password;
	@FindBy(xpath="//button[text()='Sign In']") WebElement signin;
	public MainLoginPage enterUserNameAndPassword(String username1,String password1)
	{
		username.sendKeys(username1);
		password.sendKeys(password1);
		return this;
	}
	public HomePage clickOnSignIn()
	{
		signin.click();
		return new HomePage(driver);
	}

}
