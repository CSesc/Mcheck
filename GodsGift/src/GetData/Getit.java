package GetData;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//Free sites:
//Site 1
//smiler123/smiler123
//css=#ctl00_ContentPlaceHolder1_ddlCategory > option[value="20"]

public class Getit {
	
		String matter;
		String title;
		String url;
		WebDriver driver = null;
		@BeforeTest
		public void setup() throws Exception {
		    System.out.println("In Setup Method");
			driver =new FirefoxDriver();     
		    driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		    System.out.println("Opening Site");
			driver.get("http://godarainfotech.in/index.php?show=demo");
			driver.findElement(By.id("lusername")).sendKeys("utkarshsi");
			driver.findElement(By.id("lpassword")).sendKeys("Kriti7333");
			driver.findElement(By.id("loginsubmit")).click();
			//driver.get("http://godarainfotech.in/index.php?show=postmatter");
			driver.findElement(By.xpath("//a[contains(text(),'Matter To Post')]")).click();
			List<WebElement> list = driver.findElements(By.xpath("//a[text()='View & Submit']"));

			
			System.out.println("Count of adds = "+ list.size());
//Clicking the first matter			
			System.out.println("Processing first Add");
			driver.findElement(By.xpath("//a[text()='View & Submit']")).click();
//Getting all needed Values
			String pageText = driver.findElement(By.id("matterdets")).getText();
			title	= myMethod(pageText, "Title to Use :", "Matter to Use :");
			matter	= myMethod(pageText, "Matter to Use :", "Url to Use :");
			url		= myMethod(pageText, "Url to Use :", "Categories to Post :");
			System.out.println("Title to Use : "+ title);
			System.out.println("Matter to Use : "+ matter);
			System.out.println("URl to Use : "+ url);
			Save_Image();
		}
/*
 * Tear down to destroy the driver object		
 */
		@AfterTest
		public void TearDown() 
		{
			System.out.println("In Tear Down Method");
			driver.close();
		}
/*
 * Script to save the needed image
 */
		//@Test(priority=1)
		public void Save_Image() throws IOException, InterruptedException, AWTException
		{
			WebElement Image = driver.findElement(By.xpath("//*[@id='matterdets']/img"));
			Actions action= new Actions(driver);
			  action.contextClick(Image).build().perform();
			  
			  //To perform press Ctrl + v keyboard button action.
			  action.sendKeys(Keys.CONTROL, "v").build().perform();
			  Thread.sleep(1000);
	     	  Robot robot = new Robot();
			  robot.keyPress(KeyEvent.VK_ENTER);  

			  Thread.sleep(1000);
			  robot.keyPress(KeyEvent.VK_Y);  

			  System.out.println("Saved Image at default Location");
		}
		
		@Test
		public void matter()
		{
		

		}
/*
 *Returns the text in Str which lies between s1 and s2 
 *ex Str-exampleS1_NEEDED TEXT_ S2 
 *passing above string with S1 and S2 will  return >> '_NEEDED TEXT_ '
 */
		public static String myMethod(String str,String s1,String s2)
		{
			return str.substring(str.indexOf(s1) + s1.length(), str.indexOf(s2));
		}
		
	}
		
			
			




