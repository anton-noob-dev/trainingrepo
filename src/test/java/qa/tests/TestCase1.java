package qa.tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pageevents.HomePage;
import pageevents.LoginPage;
import utils.ElementFetch;

public class TestCase1 extends BaseTest{
	
	ElementFetch element = new ElementFetch();
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	
  @Test
  public void sampleTestNGRun() {
	  
	  homePage.clickSignInBtn();
	  loginPage.enterCredentials();
	  
  }
}
