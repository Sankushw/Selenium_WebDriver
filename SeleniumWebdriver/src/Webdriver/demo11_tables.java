package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo11_tables {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 

		//WebDriver driver = new FirefoxDriver(); 
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\Jar files for Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");

		driver.manage().window().maximize();
		driver.get("file:///C:/Users/IBM_ADMIN/Desktop/table.html");
		String number=driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]")).getText();
		System.out.println(number);
		String r2city=driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]//parent::tr//child::td[2]")).getText();
		System.out.println(r2city);

		//using Ancestor
		String tag=driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]//ancestor::body")).getTagName();
		System.out.println("tagname= "+tag);

	}

}
