package Webdriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo8_openLinkNewTab {

	public static void main(String[] args) throws AWTException, InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(); 

		//driver.get("http://retail.upskills.in/admin/");
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		String title1=driver.getTitle();
		System.out.println("Tab 1 title= "+title1);
		
		//there are 2 methods to open link in new tab
		//1 using Sendkeys on link instead of click()
		//2 using context click of Actions class and then select "open in new tab" from the options using robot class
		driver.findElement(By.linkText("Gmail")).sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));    //RETURN is same  as ENTER key

		//to open link in new tab----CNTRL+ENTER on link
		
		//to open link in new WINDOW----SHIFT+ENTER on link
		//driver.findElement(By.linkText("Gmail")).sendKeys(Keys.chord(Keys.SHIFT,Keys.RETURN));    //RETURN is same  as ENTER key
		
		// trying with window handler
		//return type of GetWindowHandles is set of Strinbs
		ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
		int size= tabs.size();
		
		System.out.println("no. of tabs= "+size);
		System.out.println(tabs.get(0));
		System.out.println(tabs.get(1));
		driver.switchTo().window(tabs.get(1));

		String title3=driver.getTitle();
		System.out.println("Tab 2 title= "+title3);

		if(title1.equals(title3))
		{
			System.out.println("same title");
		}
		else
		{
			System.out.println("Title are different");
		}


		
	}

}
