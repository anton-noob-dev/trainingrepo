package pageevents;

import pageobjects.HomePageElements;
import utils.ElementFetch;

public class HomePage {
	
	ElementFetch element = new ElementFetch();
	
	public void clickSignInBtn() {
		
		element.getWebElement("XPATH", HomePageElements.signInBtn).click();
	}
}
