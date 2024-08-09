package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.DriverInstance;

public class Reports implements ITestListener, IAnnotationTransformer {

public void onTestFailure(ITestResult result) {
	    
		String fileName = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + result.getMethod().getMethodName();
		File file = ((TakesScreenshot)DriverInstance.driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(file, new File(fileName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
