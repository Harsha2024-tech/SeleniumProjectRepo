package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {
	public WebDriver driver;
	public void selectByVisibleTest(WebElement element,String Text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(Text);
	}
	public void selectByIndexValue(WebElement element,int value)
	{
		Select select=new Select(element);
		select.selectByIndex(value);
	}
	public void selectByValue(WebElement element,String text)
	{
		Select select=new Select(element);
		select.selectByValue(text);
	}
	public void scrollDown()
	{
		JavascriptExecutor javascript=(JavascriptExecutor) driver;
		javascript.executeScript("window.scrollBy(0, 500)");
	}

}
