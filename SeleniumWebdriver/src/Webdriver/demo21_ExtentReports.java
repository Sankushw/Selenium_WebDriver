package Webdriver;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class demo21_ExtentReports {

	public static void main(String[] args) {

		ExtentReports report;
		ExtentTest logger;
		report = new ExtentReports(System.getProperty("user.dir")+"/test-output/sanjay.html",true);
		
		report.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
		logger=report.startTest("demo21_ExtentReports");//try changing text name in "" and check what happens 
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SanjayKushwaha\\Desktop\\Selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		logger.log(LogStatus.INFO, "Maximized my browser");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		logger.log(LogStatus.INFO, "Opened the browser");
		String title = driver.getTitle();
		logger.log(LogStatus.PASS, title);
		driver.close();
		logger.log(LogStatus.INFO,"browser is closed");
		report.endTest(logger);
		report.flush();
		report.close();
	}

}
