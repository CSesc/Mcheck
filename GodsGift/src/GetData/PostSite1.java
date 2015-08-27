package GetData;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class PostSite1 {

	WebDriver driver = null;
	@BeforeTest
	public void start()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://sso.citybase.com/index.html?action=login_signin");//
		/*WebElement logout=driver.findElement(By.xpath("//div[@id='searchbar']/div[2]/a[2]/strong"));
		if(logout.isDisplayed())
			logout.click();*/
	}
	
	@AfterTest
	public void TearDown() 
	{
		System.out.println("In Tear Down Method");
		//driver.close();
	}
	@Test
	public void login_00()
	{
		driver.findElement(By.id("txtEmail")).sendKeys("smilecosts00@gmail.com");
		driver.findElement(By.id("password-clear")).sendKeys("qwerty");
		driver.findElement(By.name("submit")).click();
		
	}
	@Test
	public void post_Add() throws AWTException
	{
		driver.findElement(By.id("cb_int_dropdown_show")).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("cb_int_dropdown_show"))).perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath("//li[text()='India']")).click();
		
		
		

		driver.findElement(By.id("header_green_button")).click();
				//Select india from the dropdown here
		//div[@id='searchbar']/div[2]/a[2]/strong
		Select mydrpdwn1 = new Select(driver.findElement(By.id("states")));
		System.out.println("States Dropdown displayed" +driver.findElement(By.id("states")).isDisplayed());
		  mydrpdwn1.selectByVisibleText("Maharashtra");
		  
		  Select mydrpdwn2 = new Select(driver.findElement(By.id("city")));
		  mydrpdwn2.selectByVisibleText("Pune");
		  
		  driver.findElement(By.id("community")).sendKeys("viman nagar");
		  
		  Select mydrpdwn3 = new Select(driver.findElement(By.id("root_cats")));
		  mydrpdwn3.selectByVisibleText("For Sale");
		  
		  Select mydrpdwn4 = new Select(driver.findElement(By.xpath("//span[@id='child_cats_list']")));
		  mydrpdwn4.selectByVisibleText("Clothing");
		  
		  /*Select mydrpdwn5 = new Select(driver.findElement(By.id("show_attributes_variety")));
		  mydrpdwn5.selectByVisibleText("Clothing");*/
		  
		  driver.findElement(By.id("txtTitle")).sendKeys("women's clothing");
		  driver.findElement(By.id("keywords1")).sendKeys("western dress");
		  driver.findElement(By.id("keywords2")).sendKeys("Top");
		  driver.findElement(By.id("keywords3")).sendKeys("shirt");
		  
		  WebElement iframeMsg = driver.findElement(By.xpath("//*[contains(@id, 'txtDetail-wysiwyg-iframe')]"));        
		  driver.switchTo().frame(iframeMsg);

		  WebElement body = driver.findElement(By.cssSelector("body"));
		  body.sendKeys("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		 
		  driver.switchTo().defaultContent();
		  
		  driver.findElement(By.id("memberemail")).sendKeys("smilecosts00@gmail.com");
		  
		  driver.findElement(By.id("txtPrice")).sendKeys("1000");
		  WebElement element = driver.findElement(By.xpath("//form/div/label/input"));
		  
			element.click();
			StringSelection ss = new StringSelection("F:\\123.png");
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		    //imitate mouse events like ENTER, CTRL+C, CTRL+V
		   Robot robot = new Robot();
		   robot.keyPress(KeyEvent.VK_CONTROL);
		   robot.keyPress(KeyEvent.VK_V); 
		   robot.keyRelease(KeyEvent.VK_V); 
		   robot.keyRelease(KeyEvent.VK_CONTROL); 
		   robot.keyPress(KeyEvent.VK_ENTER); 
		   robot.keyRelease(KeyEvent.VK_ENTER);
		   
		   try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    
//		    driver.findElement(By.className("btn_small")).click();
		    driver.findElement(By.xpath("//tr//td//div[@id='div_1']//input[@class='btn_small']")).click();
		    System.out.println("DONE!!!!!!!!!");
		  driver.getCurrentUrl();

	}
}
