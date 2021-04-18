package Webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import com.sun.xml.bind.v2.model.core.ID;

public class demo12_frames {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 

		//WebDriver driver = new FirefoxDriver(); 
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\Jar files for Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");

		driver.manage().window().maximize();
		driver.get("http://www.toolsqa.com/iframe-practice-page/");
		List<WebElement> frames=driver.findElements(By.tagName("iframe"));

		System.out.println("number of frames= "+frames.size());

		for(int i=0; i<frames.size();i++)
		{
			System.out.println(frames.get(i).getAttribute("name"));
		}
		Thread.sleep(4000);
		
		//3 ways to switch to iframes-----1)Index   2)name   3) WebElement
		//to switch to parent frame when there are frames inside frames------ driver.switchTo().parentFrame();
		
		driver.switchTo().frame("iframe1");
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='primary-menu']/li[1]/a/span/span")).click();
		driver.switchTo().defaultContent();


	}

}
