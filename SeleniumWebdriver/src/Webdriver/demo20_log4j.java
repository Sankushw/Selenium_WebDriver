package Webdriver;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.jmx.LoggerDynamicMBean;
import org.apache.log4j.xml.Log4jEntityResolver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class demo20_log4j {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger= Logger.getLogger("demo20_log4j"); // mention class name in args as  demo20_log4j.class   or "demo20_log4j"
		PropertyConfigurator.configure("log4j.properties"); 

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SanjayKushwaha\\Desktop\\Selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		logger.info("opening website");
		String title= driver.getTitle();
		logger.info(title);


		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		logger.info("Logged in");
		String actualTitle=driver.getTitle();

		logger.info("compared title-success");
	}

}
