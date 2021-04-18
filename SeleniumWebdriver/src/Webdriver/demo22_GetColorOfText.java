package Webdriver;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;



public class demo22_GetColorOfText {

	public static void main(String[] args) {

				// TODO Auto-generated method stub
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"\\geckodriver.exe");

				WebDriver driver=new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								
				driver.get("https://www.training-support.net/selenium/target-practice");
				driver.manage().window().maximize();
				

				String eleBackColor =driver.findElement(By.xpath("//h5[@class='ui green header']")).getCssValue("background-color");
				String eleTextColor =driver.findElement(By.xpath("//h5[@class='ui green header']")).getCssValue("color");
		 
		        System.out.println("element background color: " + eleBackColor);
		        System.out.println("element Text color " + eleTextColor);
		        
		        String hex_eleBackColor = Color.fromString(eleBackColor).asHex();
		        String hex_eleTextColor = Color.fromString(eleTextColor).asHex();
		        
		        System.out.println("hex code of background color of element= "+hex_eleBackColor);
		        System.out.println("hex code of text color of element= "+hex_eleTextColor);
			}




}
