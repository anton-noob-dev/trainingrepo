package qa.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.DriverInstance;
import datagenerator.DataGenerator;
import pageevents.LoginPage;

public class TestCase1 extends DriverInstance{
	
	@Test(dataProvider="Data",dataProviderClass = DataGenerator.class)
	public void login(String user, String pw) throws Exception {
		
		LoginPage login = new LoginPage(driver);
		
		login.enterUsername(user);
		login.enterPassword(pw);
		login.clickSignIn();
	}
	
}
