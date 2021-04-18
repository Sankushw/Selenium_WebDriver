package Webdriver;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class demo13_wait {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 

		//WebDriver driver = new FirefoxDriver(); 
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\Jar files for Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");

		driver.manage().window().maximize();
		//default wait of webdriver or selenium is 30 seconds
		//implicit wait------it is applicable for all the lines and is declared only once-----no default wait.
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		driver.get("http://newtours.demoaut.com/");

		//explicit wait-----whenever you want to wait for specific element with the condition
		WebDriverWait mywait= new WebDriverWait(driver, 30);
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		
		//fluentwait-------similar to explicit wait but it pools every 5seconds and hence is better than explicit.
		Wait wait = new FluentWait(driver)
				.withTimeout(20, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(Exception.class);  //eg:ignoring NoSuchElementException.class
		 
	}

}
