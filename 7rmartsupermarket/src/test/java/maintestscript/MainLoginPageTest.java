package maintestscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import mainprojectpages.AdminUsersPage;
import mainprojectpages.HomePage;
import mainprojectpages.MainLoginPage;
import utilities.ExcelUtility;

public class MainLoginPageTest extends Base {
	HomePage homepage;
  @Test(dataProvider="credientials")
  public void verifyUserCanLoginWithValidCredientials(String username,String password) {
	  MainLoginPage mainLogin=new  MainLoginPage(driver);
	  mainLogin.enterUserNameAndPassword(username,password);
	  homepage=mainLogin.clickOnSignIn();
	  String expected="Dashboard | 7rmart supermarket";
	  String actual=driver.getTitle();
	  Assert.assertEquals(actual, expected,Constant.ERRORMESSAGEFORLOGIN);
  }
  @Test
  @Parameters({"username","password"})
  public void verifyUserCanLoginWithValidUsernameAndInvalidPassword(String username,String password)
  {
	  MainLoginPage mainLogin=new  MainLoginPage(driver);
	  mainLogin.enterUserNameAndPassword(username,password);
	  homepage=mainLogin.clickOnSignIn();
	  String expected="Dashboard | 7rmart supermarket";
	  String actual=driver.getTitle();
	  Assert.assertEquals(actual, expected,Constant.ERRORMESSAGEFORLOGIN);
  }
  @Test(retryAnalyzer = retry.RetryClass.class,groups = {"smoke"})
  public void verifyUserCanLoginWithInvalidUsernameAndValidPassword() throws IOException
  {
	  MainLoginPage mainLogin=new  MainLoginPage(driver);
	  String username=ExcelUtility.getStringData(2, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(2, 1, "LoginPage");
	  mainLogin.enterUserNameAndPassword(username,password);
	  homepage=mainLogin.clickOnSignIn();
	  String expected="Dashboard | 7rmart supermarket";
	  String actual=driver.getTitle();
	  Assert.assertEquals(actual, expected,Constant.ERRORMESSAGEFORLOGIN);
  }
  @Test(groups = {"smoke"})
  public void verifyUserCanLoginWithInvalidUsernameAndInvalidPassword() throws IOException
  {
	  MainLoginPage mainLogin=new  MainLoginPage(driver);
	  String username=ExcelUtility.getStringData(2, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(2, 1, "LoginPage");
	  mainLogin.enterUserNameAndPassword(username,password);
	  homepage=mainLogin.clickOnSignIn();
	  String expected="Dashboard | 7rmart supermarket";
	  String actual=driver.getTitle();
	  Assert.assertEquals(actual, expected,Constant.ERRORMESSAGEFORLOGIN);
  }
  @DataProvider(name="credientials")
  public Object verifyUserCanLogin()
  {
	  Object data[][]= {{"admin","admin"},{"admin","123"},{"1234","admin"},{"admin1","admin2"}};
	  return data;
  }
}
