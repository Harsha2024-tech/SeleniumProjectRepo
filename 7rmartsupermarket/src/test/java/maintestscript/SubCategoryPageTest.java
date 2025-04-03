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

public class SubCategoryPageTest extends Base{
	HomePage home;
	SubCategoryPage sub;
	NewSubCategoryPage newsub;
  @Test
  public void verifyWhetherUserCanenterSubCategoryPage() throws IOException {
	  MainLoginPage login=new MainLoginPage(driver);
	  String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(1, 1, "LoginPage");
	  login.enterUserNameAndPassword(username, password);
	  home=login.clickOnSignIn();
	  sub=home.clickOnMoreInfoOnSubCategory();
	  newsub=sub.clickOnNew();
	  String item=ExcelUtility.getStringData(4, 0, "SubCategory");
	  newsub.clickonSelect().clickonSubCategory(item).clickonchooseFile().clickonSave();
	  boolean expected=newsub.isSuccessAlertDisplayed();
	  Assert.assertTrue(expected,Constant.ERRORMESSAGEFORSUBCATEGORYPAGECREATEDSUCCESSFULLY);
	  
  }
}
