package base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.Utility;

public class DriverInstance {

	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	@BeforeSuite
	public void beforeSuiteMethod() throws Exception {

		try {
	        System.out.println("Initializing ExtentReports...");
	        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "DataDrivenFrameworkPractice.html");
	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);
	        sparkReporter.config().setTheme(Theme.DARK);
	        extent.setSystemInfo("HostName", "DESKTOP-K7HUSAM");
	        extent.setSystemInfo("UserName", "desktop-k7husam/admin");
	        sparkReporter.config().setDocumentTitle("Automation Report");
	        sparkReporter.config().setReportName("Automation Test Results");
	        System.out.println("ExtentReports initialized successfully.");
	        setupDriver(); // Ensure the driver setup is correct
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error initializing ExtentReports: " + e.getMessage());
	    }
	}

	@BeforeMethod
	public void initiateDriverInstance(Method testMethod) throws Exception {

		if (extent == null) {
	        System.out.println("ExtentReports is null. Initialization might have failed.");
	        throw new RuntimeException("ExtentReports is not initialized.");
	    }

	    logger = extent.createTest(testMethod.getName());
	    System.out.println("Created test logger for: " + testMethod.getName());

	    driver.get(Utility.fetchPropertyValue("appURL").toString());
	    driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethodMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
		}
	}

	@AfterSuite
	public void closeDriverInstance() {

		extent.flush();
		if (driver != null) {
			driver.quit(); // Quit the driver only once after all tests are complete
		}
	}

	public void setupDriver() throws Exception {

		if(Utility.fetchPropertyValue("browser").toString().equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver-win32/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}
		else if(Utility.fetchPropertyValue("browser").toString().equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
}
