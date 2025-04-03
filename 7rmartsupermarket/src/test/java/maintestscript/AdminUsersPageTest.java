package maintestscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import mainprojectpages.AdminUsersPage;
import mainprojectpages.HomePage;
import mainprojectpages.MainLoginPage;
import utilities.ExcelUtility;

public class AdminUsersPageTest extends Base {
	HomePage homepage;
	AdminUsersPage adminUsers;
  @Test
  public void verifyUserCanClickOnAdminUsers() throws IOException {
	  MainLoginPage loginPage=new MainLoginPage(driver);
	  String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(1, 1, "LoginPage");
	  loginPage.enterUserNameAndPassword(username,password);
	  homepage=loginPage.clickOnSignIn();
	  adminUsers=homepage.clickOnAdminMoreInfo();
	  boolean displaycondition=adminUsers.isNewButtonDisplayed();
	  Assert.assertTrue(displaycondition,Constant.ERRORMESSAGEFORADMINUSERSPAGE);
	  
	  
	  
  }
}
