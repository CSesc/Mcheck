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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Post_Site2 {
	WebDriver driver = null;
	private String myAdd;
	@BeforeTest
	public void start()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.buzznoida.com/login.aspx");//
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
	public void login_001()
	{
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLogin")).sendKeys("smiler123");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).sendKeys("smiler123");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ImageButton1")).click();
		
	}
	
	@Test
	public void postAdd_001() throws AWTException, InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Post FREE Ad')]")).click();
		
		Select mydrpdwn1 = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCategory")));
		mydrpdwn1.selectByVisibleText("Shopping & Lifestyle");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Select mydrpdwn2 = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSubCategory")));
		mydrpdwn2.selectByVisibleText("Clothing & Fashion Garments");
		
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtName" )).sendKeys("WRONG Announcing AW'15 Line");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtDescription")).sendKeys("Wrong Weather is a leading online store and concept store for Men. Shop the latest curated Designer Brands.");
		
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAddress")).sendKeys("Paladium homes , viman nagar");
		
		Select mydrpdwn3 = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCity")));
		mydrpdwn3.selectByVisibleText("Pune");
		
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMobile")).sendKeys("8888892084");
		
		
		WebElement element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_FileUpload1" ));
		  element.click();
			StringSelection ss = new StringSelection("F:\\123.png");
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		    //imitate mouse events like ENTER, CTRL+C, CTRL+V
		   Robot robot = new Robot();
		   robot.keyPress(KeyEvent.VK_CONTROL);
		   robot.keyPress(KeyEvent.VK_V); 
		   robot.keyRelease(KeyEvent.VK_V); 
		   robot.keyRelease(KeyEvent.VK_CONTROL); 
		   Thread.sleep(3000);
		  
		   robot.keyPress(KeyEvent.VK_ENTER);
		   robot.keyRelease(KeyEvent.VK_ENTER);
		   Thread.sleep(3000);

		
		   driver.findElement(By.id("ctl00_ContentPlaceHolder1_butSubmit")).click();//Click final Post Add Button
		   System.out.println("DONE!!!!");
		   myAdd=driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceHolder1_labLink']/a")).getAttribute("href");
		   System.out.println("my Add link =" + myAdd);
		   
		   
		   System.out.println("my Add link =" + myAdd);
	}
	
	
}