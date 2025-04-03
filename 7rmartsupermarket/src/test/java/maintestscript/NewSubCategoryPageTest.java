package maintestscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import mainprojectpages.HomePage;
import mainprojectpages.MainLoginPage;
import mainprojectpages.NewSubCategoryPage;
import mainprojectpages.SubCategoryPage;
import utilities.ExcelUtility;

public class NewSubCategoryPageTest extends Base {
	HomePage home;
	SubCategoryPage sub;
	NewSubCategoryPage newSub;
  @Test
  public void verifyWhetherUserCanEnterSubCategoryDetailsSuccessfully() throws IOException {
	  MainLoginPage login=new MainLoginPage(driver);
	  String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(1, 1, "LoginPage");
	  login.enterUserNameAndPassword(username, password);
	  home=login.clickOnSignIn();
	  sub=home.clickOnMoreInfoOnSubCategory();
	  newSub=sub.clickOnNew();
	  boolean expected=sub.isCategoryfielddisplayed();
	  Assert.assertTrue(expected,Constant.ERRORMESSAGEFORSUBCATEGORYPAGEFIELDSALET);
	 
  }
}
