package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchWebDriver {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("datepicker")).click();
		
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-calendar")));
		
		selectDate("34", "February", "2025");
	}
	
	public static String[] getMonthYear(String monthYearValue) {
		
		return monthYearValue.split(" ");
	}
	
	public static void selectDate(String expDay, String expMonth, String expYear) {
		
		if(expMonth.equals("February") && Integer.parseInt(expDay)>29) {
			System.out.println("Invalid date: "+expMonth+" "+expDay);
			return;
		}else if(Integer.parseInt(expDay)>31) {
			System.out.println("Invalid date: "+expMonth+" "+expDay);
			return;
		}
		
		String monthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(monthYearValue);
		
		while(!(getMonthYear(monthYearValue)[0].equals(expMonth) && getMonthYear(monthYearValue)[1].equals(expYear))) {
			
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			monthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();
			
		}
		
		try {
			driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='"+expDay+"']")).click();
		}
		catch (Exception e) {
			System.out.println("Invalid date: "+expMonth+" "+expDay);
		}
		
	}
		

}
