package datagenerator;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataGenerator {

	@DataProvider(name="Data")
	public static Object[][] testDataGenerator(Method method) throws Exception {
		
		if(method.getName().equalsIgnoreCase("login")) {
			
			FileInputStream file = new FileInputStream("./testdata/TestData.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Login");

			int numberOfData = sheet.getPhysicalNumberOfRows();
			Object[][] testData = new Object[numberOfData - 1][2]; // Adjust size for the exclusion of the first row

			for (int i = 1; i < numberOfData; i++) { // Start from 1 to skip the first row
			    XSSFRow row = sheet.getRow(i);
			    if (row != null) { // Check if the row is not null
			        XSSFCell username = row.getCell(0);
			        XSSFCell password = row.getCell(1);
			        if (username != null && password != null) { // Check if cells are not null
			            testData[i - 1][0] = username.getStringCellValue();
			            testData[i - 1][1] = password.getStringCellValue();
			        }
			    }
			}

			return testData;
		}
		else if(method.getName().equalsIgnoreCase("createAccount")) {
			
			FileInputStream file = new FileInputStream("./testdata/TestData.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Register");

			int numberOfData = sheet.getPhysicalNumberOfRows();
			Object[][] testData = new Object[numberOfData - 1][3]; // Adjust size for the exclusion of the first row

			for (int i = 1; i < numberOfData; i++) { // Start from 1 to skip the first row
			    XSSFRow row = sheet.getRow(i);
			    if (row != null) { // Check if the row is not null
			        XSSFCell firstName = row.getCell(0);
			        XSSFCell lastName = row.getCell(1);
			        XSSFCell mobile = row.getCell(2);
			        if (firstName != null && lastName != null && mobile != null) { // Check if cells are not null
			            testData[i - 1][0] = firstName.getStringCellValue();
			            testData[i - 1][1] = lastName.getStringCellValue();
			            testData[i - 1][2] = mobile.getStringCellValue();
			        }
			    }
			}

			return testData;
		}
		else {
			
			Object[][] testData = new Object[2][3];
			return testData;
		}
		
	}
		
}
