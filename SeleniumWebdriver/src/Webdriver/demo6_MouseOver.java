package Webdriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class demo6_MouseOver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/* Mouse Actions:
			    doubleClick(): Performs double click on the element
			    clickAndHold(): Performs long click on the mouse without releasing it
			    dragAndDrop(): Drags the element from source locator and drops to destination locator
			    moveToElement(): Shifts the mouse pointer to the center of the element
			    contextClick(): Performs right-click on the mouse

			Keyboard Actions:
			    sendKeys(): Sends a series of keys to the element
			    keyUp(): Performs key release
			    keyDown(): Performs keypress without release*/
			    
		System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(); 

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();


		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		WebElement Login=driver.findElement(By.id("btnLogin"));

		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();   //using enter key directly on login button
		//act.moveToElement(Login).click();           //using click() method on login button
		Thread.sleep(2000);
		
		//return type of moveToElement is Actions
		//moveToElement can have 1 or 3 parameters.
		//act.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER).build().perform();
		WebElement PIM=driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b"));

		act.moveToElement(PIM).build().perform();
		WebElement empList=driver.findElement(By.id("menu_pim_viewEmployeeList"));
		empList.click();
		Thread.sleep(2000);

		//to scroll down
		act.sendKeys(Keys.PAGE_DOWN).build().perform();

	}

}
