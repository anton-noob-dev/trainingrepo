package pageevents;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Utility;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	public void enterUsername(String username) throws Exception {

		driver.findElement(By.id(Utility.fetchLocatorValue("login_username_id"))).sendKeys(username);
	}

	public void enterPassword(String password) throws Exception {

		driver.findElement(By.id(Utility.fetchLocatorValue("login_password_id"))).sendKeys(password);
	}

	public void clickSignIn() throws Exception {

		driver.findElement(By.name(Utility.fetchLocatorValue("login_signin_name"))).click();
	}

	public void clickCreateNewAccount() throws Exception {

		driver.findElement(By.xpath(Utility.fetchLocatorValue("createaccount_create_xpath"))).click();
	}

	public void enterFirstName(String firstName) throws Exception {

		driver.findElement(By.xpath(Utility.fetchLocatorValue("createaccount_fname_xpath"))).sendKeys(firstName);
	}

	public void enterLastName(String lastName) throws Exception {

		driver.findElement(By.xpath(Utility.fetchLocatorValue("createaccount_lname_xpath"))).sendKeys(lastName);
	}
	
	public void enterMobile(String mobile) throws Exception {

		driver.findElement(By.xpath(Utility.fetchLocatorValue("createaccount_mobile_xpath"))).sendKeys(mobile);
	}
}
