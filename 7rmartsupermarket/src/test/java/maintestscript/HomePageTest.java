package maintestscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import mainprojectpages.HomePage;
import mainprojectpages.MainLoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base {
	HomePage homepage;
  @Test
  public void verifyLogoutFromApplicationIsWorking() throws IOException {
	  MainLoginPage login=new MainLoginPage(driver);
	  String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(1, 1, "LoginPage");
	  login.enterUserNameAndPassword(username,password);
	  homepage=login.clickOnSignIn();
	  homepage.clickOnAdmin();
	  homepage.clickOnLogout();
	  boolean displayCondition=homepage.isUsernameDisplayed();
	  Assert.assertTrue(displayCondition,Constant.ERRORMESSAGEFORHOMEPAGE);
	  
  }
}
