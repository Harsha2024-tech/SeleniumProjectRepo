package mainprojectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubCategoryPage {
	public WebDriver driver;
	public SubCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newsub;
	@FindBy(xpath="//select[@id='cat_id']") WebElement category;
	public NewSubCategoryPage clickOnNew()
	{
		newsub.click();
		return new NewSubCategoryPage(driver);
	}
	public boolean isCategoryfielddisplayed()
	{
		return category.isDisplayed();
	}

}
