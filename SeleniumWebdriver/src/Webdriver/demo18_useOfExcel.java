package Webdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo18_useOfExcel {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(); 

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();

		File file=new File("C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\jars for Selenium Upskill\\Project Excel files\\ApachePOI_test.xlsx");
		FileInputStream fis=new FileInputStream(file);

		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int rowcount=sheet.getLastRowNum();

		for(int i=0;i<=rowcount;i++)
		{
			String Username=sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(Username);
			String password=sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println(password);

			driver.findElement(By.id("txtUsername")).sendKeys(Username);
			driver.findElement(By.id("txtPassword")).sendKeys(password);
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("welcome")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[3]/a")).click();
		}
		wb.close();
	}

}
