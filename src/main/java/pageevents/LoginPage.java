package pageevents;

import pageobjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPage {

	ElementFetch element = new ElementFetch();
	
	public void enterCredentials() {
		
		element.getWebElement("NAME", LoginPageElements.emailTextField).sendKeys("dummytest@test.com");
		element.getWebElement("NAME", LoginPageElements.passwordTextField).sendKeys("12345");
		element.getWebElement("XPATH", LoginPageElements.loginBtn).click();
	}
}
