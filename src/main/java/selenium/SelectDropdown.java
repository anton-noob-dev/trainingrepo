package selenium;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropdown {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		driver.findElement(By.className("commonModal__close")).click();
		
		Thread.sleep(2000);
		
		String cityToSelect = "Cebu";
		
		driver.findElement(By.id("fromCity")).sendKeys(cityToSelect);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='react-autosuggest__suggestions-list']//div//p[@class='searchedResult font14 blackText appendBottom5']")));
		
		List<WebElement> cityList = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']//div//p[@class='searchedResult font14 blackText appendBottom5']"));
		int count = 0;
		
		for(WebElement element:cityList) {
			
			String currentCity = element.getText();
			
			if(currentCity.contains(cityToSelect)) {
				
				element.click();
				count++;
				break;
			}
		}
		
		if(count!=0) {
			
			System.out.println(cityToSelect+" has been selected");
		}
		else {
			
			System.out.println("City selected is not available");
		}
		
		Thread.sleep(3000);
		
		/*
		 * WebElement dropdown = driver.findElement(By.name("employees_c"));
		 * 
		 * Select select = new Select(dropdown);
		 * 
		 * select.selectByValue("level1");
		 * select.selectByVisibleText("11 - 50 employees"); select.selectByIndex(4);
		 */
		
		/*
		 * WebElement dropdown = driver.findElement(By.id("multi-select"));
		 * 
		 * Select select = new Select(dropdown);
		 * 
		 * select.selectByValue("Florida"); Thread.sleep(2000); select.selectByIndex(4);
		 * Thread.sleep(2000);
		 * 
		 * List<WebElement> selectedItems = select.getAllSelectedOptions();
		 * 
		 * System.out.println(selectedItems.size());
		 * 
		 * select.deselectAll();
		 * 
		 * select.selectByIndex(0); Thread.sleep(2000);
		 * select.selectByValue("Washington"); Thread.sleep(2000);
		 * 
		 * List<WebElement> selectedItems1 = select.getAllSelectedOptions();
		 * 
		 * select.deselectByIndex(0);
		 * 
		 * System.out.println(selectedItems1.size());
		 */
		
		driver.close();

	}
}
