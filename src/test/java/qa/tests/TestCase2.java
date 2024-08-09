package qa.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.DriverInstance;
import datagenerator.DataGenerator;
import pageevents.LoginPage;
import utils.Utility;

public class TestCase2 extends DriverInstance{

	@Test(dataProvider = "Data",dataProviderClass = DataGenerator.class)
	public void createAccount(String firstName, String lastName, String mobile) throws Exception {
		
		LoginPage login = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		login.clickCreateNewAccount();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocatorValue("createaccount_fname_xpath"))));
		login.enterFirstName(firstName);
		login.enterLastName(lastName);
		login.enterMobile(mobile);
	}
}
