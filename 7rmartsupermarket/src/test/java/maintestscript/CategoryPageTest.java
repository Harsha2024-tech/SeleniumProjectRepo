package maintestscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import mainprojectpages.CategoryPage;
import mainprojectpages.HomePage;
import mainprojectpages.MainLoginPage;
import utilities.ExcelUtility;

public class CategoryPageTest extends Base {
	HomePage home;
	CategoryPage category;
  @Test
  public void verifyUserCanClickOnCategory() throws IOException {
	  MainLoginPage loginPage=new MainLoginPage(driver);
	  String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(1, 0, "LoginPage");
	  loginPage.enterUserNameAndPassword(username,password);
	  home=loginPage.clickOnSignIn();
	  category=home.clickOnMoreInfoOnCategoryPage();
	  String expected="List Categories | 7rmart supermarket";
	  String actual=driver.getTitle();
	  Assert.assertEquals(actual, expected,Constant.ERRORMESSAGEFORCATEGORYPAGE);
  }
}
