package mainprojectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	public WebDriver driver;
	public CategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
	@FindBy(xpath="//input[@id='category']") WebElement category;
	public NewCategoryPage clickOnNew()
	{
		newbutton.click();
		return new NewCategoryPage(driver);
	}
	public boolean isCategorydisplayed()
	{
		return category.isDisplayed();
	}

}
