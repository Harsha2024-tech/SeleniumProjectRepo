package maintestscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import mainprojectpages.AdminUsersPage;
import mainprojectpages.HomePage;
import mainprojectpages.MainLoginPage;
import mainprojectpages.SearchAdminUser;
import utilities.ExcelUtility;

public class SearchAdminUserPageTest extends Base {
	HomePage homepage;
	AdminUsersPage admin;
	SearchAdminUser searchUser;
  @Test
  public void verifySearchButtondisplayedInAdminUsersPageIsWorking() throws IOException {
	  MainLoginPage login1=new MainLoginPage(driver);
	  String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(1, 0, "LoginPage");
	  login1.enterUserNameAndPassword(username,password);
	  homepage=login1.clickOnSignIn();
	  admin=homepage.clickOnAdminMoreInfo();
	  searchUser=admin.clickOnSearch();
	  boolean expected=searchUser.isSearchdisplayed();
	  Assert.assertTrue(expected,Constant.ERRORMESSAGEFORSEARCHUSER);
	  
  }
  @Test
  public void verifyUserCansearchUserDetails() throws IOException
  {
	  MainLoginPage login1=new MainLoginPage(driver);
	  String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(1, 0, "LoginPage");
	  login1.enterUserNameAndPassword(username,password);
	  homepage=login1.clickOnSignIn();
	  admin=homepage.clickOnAdminMoreInfo();
	  searchUser=admin.clickOnSearch();
	  String username1=ExcelUtility.getStringData(1, 0, "SearchUser");
	  searchUser.enterUsername(username1).selectUserType().clickOnSearchUser();
	 boolean expected=searchUser.isTabledisplayed();
	  Assert.assertTrue(expected,Constant.ERRORMESSAGEFORSEARCHUSER);
	  
  }
}
