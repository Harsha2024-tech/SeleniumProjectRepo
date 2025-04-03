package maintestscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import mainprojectpages.CategoryPage;
import mainprojectpages.HomePage;
import mainprojectpages.MainLoginPage;
import mainprojectpages.NewCategoryPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class NewCateGoryPageTest extends Base {
	HomePage home;
	CategoryPage category;
	NewCategoryPage newCategory;
	FakerUtility fakerutility=new FakerUtility();
  @Test
  public void verifyNewCategoryButtonIsWorking() throws IOException {
	  MainLoginPage login=new MainLoginPage(driver);
	  String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(1, 0, "LoginPage");
	  login.enterUserNameAndPassword(username,password);
	  home=login.clickOnSignIn();
	  category=home.clickOnMoreInfoOnCategoryPage();
	  newCategory=category.clickOnNew();
	  boolean iscategoryresult=category.isCategorydisplayed();
	  Assert.assertTrue(iscategoryresult,Constant.ERRORMESSAGEFORCATEGORYPAGEFIELDS);
  }
  @Test
  public void verifyThatUserCanEnterValuesInAllfieldsOfCategory() throws AWTException, IOException
  {
	  MainLoginPage login=new MainLoginPage(driver);
	  String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(1, 0, "LoginPage");
	  login.enterUserNameAndPassword(username,password);
	  home=login.clickOnSignIn();
	  category=home.clickOnMoreInfoOnCategoryPage();
	  newCategory=category.clickOnNew();
	  //String categoryname=ExcelUtility.getStringData(1, 0, "Category");
	  String categoryName=fakerutility.getFakeCategoryName();
	  newCategory.enterCategory(categoryName).selectGroups().chooseFile().clickOnSave();
	  boolean alertDisplayed=newCategory.isAlertdisplayed();
	  Assert.assertTrue(alertDisplayed,Constant.ERRORMESSAGEFORCATEGORYPAGEFIELDSALET);
	  
	  
  }
}
