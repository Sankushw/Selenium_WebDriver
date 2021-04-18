package Webdriver;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class demo10_JavaScriptExecuter_n_DynamicPath {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 

		//driver = new FirefoxDriver(); 
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\Jar files for Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");

		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		String title=driver.getTitle();
		System.out.println(title);
			
		JavascriptExecutor js=(JavascriptExecutor)driver;  // here driver is downcasted to Javascript Executer but if driver is of type chromedriver then there is no need to downcast
		String title1= js.executeScript("return document.title").toString();
		System.out.println(title1);

		String title2= js.executeScript("return document.URL").toString();
		System.out.println(title2);

		String title3= js.executeScript("return document.domain").toString();
		System.out.println(title3);
		
		//to refresh screen
		js.executeScript("history.go(0)");
		js.executeScript("document.getElementById('txtUsername').value='Admin'");

		WebElement ele= (WebElement) js.executeScript("return document.getElementById('txtUsername')");
		System.out.println(ele.getAttribute("Value"));

		js.executeScript("document.getElementById('txtPassword').value='admin123'");
		js.executeScript("document.getElementById('btnLogin').click()");
		Thread.sleep(2000);

		js.executeScript("document.getElementById('menu_pim_viewPimModule').click()");
		Thread.sleep(2000);
		js.executeScript("document.getElementById('menu_pim_viewEmployeeList').click()");
		Thread.sleep(2000);
		//to pagedown 
		/*Actions  act =new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();

       //to make xpath using a dynamic field and navigate to another field.----------------------------------------
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[contains(@id,'ohrmList_chkSelectRecord')]"));
		System.out.println("no of checkboxes= "+checkboxes.size());
		for(int i=0; i<1;i++)
		{
			String firstCheck=checkboxes.get(i).getAttribute("id");
			System.out.println("id of 1st checkbox= "+firstCheck);
			driver.findElement(By.xpath("//input[@id='"+firstCheck+"']//parent::td//parent::tr//preceding-sibling::tr[1]/td[2]/a")).click();
		}*/

		//to scroll by coordinates
		//js.executeScript("window.scrollBy(0,600)");  
		//to scroll by height
		//js.executeScript ("window.scrollBy(0,document.body.scrollHeight)");
		//Thread.sleep(1000);

		//scroll to top
		//js.executeScript ("window.scrollBy(0,-document.body.scrollHeight)");

		//js.executeScript ("window.screenTop");

		//to scroll to an element
		//js.executeScript("document.getElementById('ohrmList_chkSelectRecord_5').scrollIntoView()");

		//to print the content of table-------METHOD-1
		/*List<WebElement> table=driver.findElements(By.xpath("//div[@id='tableWrapper']/table"));
		 for (int i=0;i<table.size(); i++)
		 {
			String table1= table.get(i).getText();
			System.out.println("contents= "+table1);
		 }*/

		//to print the content of table-------METHOD-2
		// System.out.println(driver.findElement(By.xpath("//*[@id='resultTable']")).getText());

		//to print the content of table(using javaScript)-------METHOD-3
		/*String tableData1= js.executeScript(" return document.getElementById('resultTable').innerText").toString();
		System.out.println(tableData1);
		String tableData2= js.executeScript(" return document.getElementById('resultTable').innerHTML").toString();
		System.out.println(tableData2);*/

		//To take back and forward 1 action not back/forward 1 page
		//js.executeScript("window.history.back()");
		Thread.sleep(3000);
		//js.executeScript("window.history.forward()");

		//to create a simple alert and show on screen--we cannot create alert in webdriver and we cannot handle it in JavaScript
		js.executeScript("alert('welcome to selenium using JavaScript')");

		Alert alert= driver.switchTo().alert();
		String alertText=alert.getText();
		System.out.println(alertText);
		alert.accept();


		js.executeScript("confirm('enter the credentials')");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();

		js.executeScript("prompt('Enter the credentials','Enter here...')");
		Thread.sleep(2000);
		alert.sendKeys("Yes");
		Thread.sleep(2000);
		alert.accept();





	}

}
