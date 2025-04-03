package maintestscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import mainprojectpages.AdminUsersPage;
import mainprojectpages.HomePage;
import mainprojectpages.MainLoginPage;
import mainprojectpages.NewAdminUserPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class NewAdminUserPageTest extends Base {
	HomePage homepage;
	AdminUsersPage adminusers;
	NewAdminUserPage newUser1;
	FakerUtility fakerutility=new FakerUtility();
	
  @Test
  public void verifyNewAdminUserCreationWorking() throws IOException {
	  MainLoginPage login=new MainLoginPage(driver);
	  String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(1, 1, "LoginPage");
	  login.enterUserNameAndPassword(username,password);
	  homepage=login.clickOnSignIn();
	  adminusers=homepage.clickOnAdminMoreInfo();
	  newUser1=adminusers.clickOnNew();
	  boolean isPassworddisplayed=newUser1.isPasswordDisplayed();
	  Assert.assertTrue(isPassworddisplayed,Constant.ERRORMESSAGEFORNEWADMINUSERPAGE);
	  
  }
  @Test
  public void verifyValuesEnteredInAllFieldsForCreatiingNewUser() throws IOException
  {
	  MainLoginPage login=new MainLoginPage(driver);
	  String username1=ExcelUtility.getStringData(1, 0, "LoginPage");
	  String password1=ExcelUtility.getStringData(1, 1, "LoginPage");
	  login.enterUserNameAndPassword(username1,password1);
	  homepage=login.clickOnSignIn();
	  adminusers=homepage.clickOnAdminMoreInfo();
	  newUser1=adminusers.clickOnNew();
	  String user1=fakerutility.getUsernamee();
	  String pass1=fakerutility.getPassword();
	  newUser1.enterUsernameAndPasswordToCreateNewAdmin(user1,pass1).selectValues().clickOnSave();
	  boolean isAlertDisplaying=newUser1.isAlertDisplayed();
	  Assert.assertTrue(isAlertDisplaying,Constant.ALERTFORNEWADMINUSER);
	  
  }
  @Test
  public void verifyValuesEnteredInAllFieldsForCreatiingNewUserCanReset() throws IOException
  {
	  MainLoginPage login=new MainLoginPage(driver);
	  String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(1, 1, "LoginPage");
	  login.enterUserNameAndPassword(username,password);
	  homepage=login.clickOnSignIn();
	  adminusers=homepage.clickOnAdminMoreInfo();
	  newUser1=adminusers.clickOnNew();
	  String username1=ExcelUtility.getStringData(1, 0, "NewAdminUser");
	  String password1=ExcelUtility.getStringData(1, 1, "NewAdminUser");
	  newUser1.enterUsernameAndPasswordToCreateNewAdmin(username1,password1).selectValues().clickOnReset();
	  String expected="Admin Users | 7rmart supermarket";
	  String actual=driver.getTitle();
	  Assert.assertEquals(actual, expected,Constant.ERRORMESSAGEFORADMINUSERSPAGE);
	  
  }
}
