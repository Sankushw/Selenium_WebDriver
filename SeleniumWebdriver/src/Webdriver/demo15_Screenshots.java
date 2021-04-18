package Webdriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo15_Screenshots {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 

		//WebDriver driver = new FirefoxDriver(); 
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\Jar files for Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");

		driver.get("C://Users//IBM_ADMIN//Desktop");
		System.out.println("title= "+driver.getTitle());
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//copy file from above line to a new file at a specific location
		FileUtils.copyFile(screenshot, new File("C://Users//IBM_ADMIN//Desktop//screenst.png"));

	}
}
