package com.GA;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;



public class DwnldImg {

	WebDriver driver = null;
	@BeforeTest
	public void setup() throws Exception {
		  driver =new FirefoxDriver();     
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://godarainfotech.in/index.php?show=demo");
		driver.findElement(By.id("lusername")).sendKeys("utkarshsi");
		driver.findElement(By.id("lpassword")).sendKeys("Kriti7333");
		driver.findElement(By.id("loginsubmit")).click();
		//driver.get("http://godarainfotech.in/index.php?show=postmatter");
		driver.findElement(By.xpath("//a[contains(text(),'Matter To Post')]")).click();
		List<WebElement> list = driver.findElements(By.xpath("//a[text()='View & Submit']"));
		
		for(WebElement item:list)
		{
			
			System.out.println(item.getText());
		}
		
		System.out.println("Count = "+ list.size());
		driver.findElement(By.xpath("//a[text()='View & Submit']")).click();
		
		
	}
	
	@AfterTest
	public void TearDown() 
	{
		System.out.println("In Tear Down Method");
		driver.close();
	}

	@Test(priority=1)
	public void Save_Image() throws IOException, InterruptedException, AWTException
	{
		WebElement Image = driver.findElement(By.xpath("//*[@id='matterdets']/img"));
		Actions action= new Actions(driver);
		  action.contextClick(Image).build().perform();
		  
		  //To perform press Ctrl + v keyboard button action.
		  action.sendKeys(Keys.CONTROL, "v").build().perform();

		  Thread.sleep(3000);
		  
     	  Robot robot = new Robot();
		  robot.keyPress(KeyEvent.VK_ENTER);  
		  System.out.println("Saved Image at default Location");
	}
	
	@Test
	public void matter()
	{
	String pageText = driver.findElement(By.id("matterdets")).getText();
	System.out.println("Title to Use : "+ myMethod(pageText, "Title to Use :", "Matter to Use :"));
	System.out.println("Matter to Use : "+ myMethod(pageText, "Matter to Use :", "Url to Use :"));
	System.out.println("URl to Use : "+ myMethod(pageText, "Url to Use :", "Categories to Post :"));

	}

	public static String myMethod(String str,String s1,String s2)
	{
		return str.substring(str.indexOf(s1) + s1.length(), str.indexOf(s2));
	}
	
}
	
		
		




