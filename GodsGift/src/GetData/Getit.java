
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Getit {
	
		String Matter="Default Matter";
		String Title="Default Title";
		String Url="default Url";
		String Img="\\Documents\\img\\";
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
			
			driver.findElement(By.xpath("//a[contains(text(),'Matter To Post')]")).click();
			List<WebElement> list = driver.findElements(By.xpath("//a[text()='View & Submit']"));

			
			System.out.println("Count of adds = "+ list.size());
//Clicking the first matter			
			System.out.println("Processing first Add");
			driver.findElement(By.xpath("//a[text()='View & Submit']")).click();
//Getting all needed Values
			String pageText = driver.findElement(By.id("matterdets")).getText();
			Title	= myMethod(pageText, "Title to Use :", "Matter to Use :");
			Matter	= myMethod(pageText, "Matter to Use :", "Url to Use :");
			Url		= myMethod(pageText, "Url to Use :", "Categories to Post :");
			System.out.println("Title to Use : "+ Title);
			System.out.println("Matter to Use : "+ Matter);
			System.out.println("URl to Use : "+ Url);

			System.out.println("Image Folder Checked at : "+ Img);
			createUserDir(Img);
			WebElement Image = driver.findElement(By.xpath("//*[@id='matterdets']/img"));
			Actions action= new Actions(driver);
			action.contextClick(Image).build().perform();
			 
			//To perform press Ctrl + v keyboard button action.
			action.sendKeys(Keys.CONTROL, "v").build().perform();
			Thread.sleep(1000);
	     	Robot robot = new Robot();

	     	pastePath(robot);

	     	robot.keyPress(KeyEvent.VK_ALT);  
	     	Thread.sleep(1000);
	     	robot.keyPress(KeyEvent.VK_S);  
	     	
	     	robot.keyRelease(KeyEvent.VK_S);  
	     	robot.keyRelease(KeyEvent.VK_ALT);  
	     	
	     	robot.keyPress(KeyEvent.VK_Y);  
	     	robot.keyRelease(KeyEvent.VK_Y);  
	     	
			System.out.println("Saved Image at default Location C:\\img\\");

		////////////////// Adjustments
			Title=Title.substring(0,90);
		
		}
		@Test
		public void Site1_cityBase() throws InterruptedException, AWTException
		{
		
			driver.get("http://sso.citybase.com/index.html?action=login_signin");//
			driver.findElement(By.id("txtEmail")).sendKeys("smilecosts00@gmail.com");
			driver.findElement(By.id("password-clear")).sendKeys("qwerty");
			driver.findElement(By.name("submit")).click();
			driver.findElement(By.id("cb_int_dropdown_show")).click();
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(By.id("cb_int_dropdown_show"))).perform();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//li[text()='India']")).click();
			
			driver.findElement(By.id("header_green_button")).click();
			Select statesDD = new Select(driver.findElement(By.id("states")));
			System.out.println("States Dropdown displayed " + statesDD.getAllSelectedOptions());
			
			System.out.println("Selecting Maharashtra ");
			statesDD.selectByVisibleText("Maharashtra");
			  
			Select mydrpdwn2 = new Select(driver.findElement(By.id("city")));
			mydrpdwn2.selectByVisibleText("Pune");
			  
			driver.findElement(By.id("community")).sendKeys("viman nagar");
			  
			Select mydrpdwn3 = new Select(driver.findElement(By.id("root_cats")));
			mydrpdwn3.selectByVisibleText("Community");
			Thread.sleep(2000);
			driver.findElement(By.id("txtTitle")).sendKeys(Title);

			Select mydrpdwn4 = new Select(driver.findElement(By.name("child_cats")));
			mydrpdwn4.selectByVisibleText("Community Activities");

			driver.findElement(By.id("keywords1")).sendKeys("Matrimonial");
			driver.findElement(By.id("keywords2")).sendKeys("Marriagbe");
			driver.findElement(By.id("keywords3")).sendKeys("Dating");
			 
			WebElement iframeMsg = driver.findElement(By.xpath("//*[contains(@id, 'txtDetail-wysiwyg-iframe')]"));        
			driver.switchTo().frame(iframeMsg);

			WebElement body = driver.findElement(By.cssSelector("body"));
			body.sendKeys(Matter);
			 
			driver.switchTo().defaultContent();
			driver.findElement(By.id("memberemail")).sendKeys("smilecosts00@gmail.com");
			WebElement element = driver.findElement(By.xpath("//form/div/label/input"));
			element.click();
			//Clicked add image button
			
			Thread.sleep(1000);
			Robot rb = new Robot();
			pastePath(rb);
			Thread.sleep(2000);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			
			WebElement pas=driver.findElement(By.id("password"));
			Thread.sleep(7000);
			if(pas.isDisplayed())
				pas.sendKeys("Kriti7333");
			
			driver.findElement(By.xpath("//tr//td//div[@id='div_1']//input[@class='btn_small']")).click();
			System.out.println("DONE!!!!!!!!! NEED TO GET URL OF ADD HERE.. PENDING !!!");
		}
		//@Test
		public void Site2_buzzNoida() throws InterruptedException, AWTException
		{
		driver.get("http://www.buzznoida.com/login.aspx");//
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLogin")).sendKeys("smiler123");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).sendKeys("smiler123");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ImageButton1")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Post FREE Ad')]")).click();
		
		Select mydrpdwn1 = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCategory")));
		mydrpdwn1.selectByVisibleText("Shopping & Lifestyle");
		Thread.sleep(2000);
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
		StringSelection ss = new StringSelection(Img);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

	    //imitate mouse events like ENTER, CTRL+C, CTRL+V
 	    Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V); 
	    robot.keyRelease(KeyEvent.VK_V); 
	    robot.keyRelease(KeyEvent.VK_CONTROL); 
	    
	    robot.keyPress(KeyEvent.VK_END);
	    Thread.sleep(3000);
	    
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(3000);

		
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_butSubmit")).click();//Click final Post Add Button
	    System.out.println("DONE!!!!");
	    String myAdd=driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceHolder1_labLink']/a")).getAttribute("href");
	    System.out.println("my Add link =" + myAdd);
}
/*//------------------------------ U t i l - M e t h o d s --------
 *Returns the text in Str which lies between s1 and s2 
 *ex Str-exampleS1_NEEDED TEXT_ S2 
 *passing above string with S1 and S2 will  return >> '_NEEDED TEXT_ '
 */
		public static String myMethod(String str,String s1,String s2)
		{
			return str.substring(str.indexOf(s1) + s1.length(), str.indexOf(s2));
		}
		
	
/*
 * Tear down to destroy the driver object		
 */
		@AfterTest
		public void TearDown() 
		{
			System.out.println("############ In Tear Down Method");
			driver.close();
		}

		public void pastePath(Robot rb) throws InterruptedException
		{	int getMcName=1;
			rb.keyPress(KeyEvent.VK_C);
			rb.keyRelease(KeyEvent.VK_C);
			
			rb.keyPress(KeyEvent.VK_SHIFT);
			rb.keyPress(KeyEvent.VK_SEMICOLON);
			
			rb.keyRelease(KeyEvent.VK_SEMICOLON);
			rb.keyRelease(KeyEvent.VK_SHIFT);
			
			rb.keyPress(KeyEvent.VK_BACK_SLASH);
			rb.keyRelease(KeyEvent.VK_BACK_SLASH);
			
			rb.keyPress(KeyEvent.VK_SHIFT);
			rb.keyPress(KeyEvent.VK_U);
			rb.keyRelease(KeyEvent.VK_U);
			rb.keyRelease(KeyEvent.VK_SHIFT);

			rb.keyPress(KeyEvent.VK_S);
			rb.keyRelease(KeyEvent.VK_S);

			rb.keyPress(KeyEvent.VK_E);
			rb.keyRelease(KeyEvent.VK_E);
			
			rb.keyPress(KeyEvent.VK_R);
			rb.keyRelease(KeyEvent.VK_R);
			
			rb.keyPress(KeyEvent.VK_S);
			rb.keyRelease(KeyEvent.VK_S);

			rb.keyPress(KeyEvent.VK_BACK_SLASH);
			rb.keyRelease(KeyEvent.VK_BACK_SLASH);
			

			Thread.sleep(1000);
			switch(getMcName)
			{
				case 1 ://C:\Users\HoneyDue
							rb.keyPress(KeyEvent.VK_SHIFT);
							rb.keyPress(KeyEvent.VK_H);
							rb.keyRelease(KeyEvent.VK_H);
							rb.keyRelease(KeyEvent.VK_SHIFT);
		
							rb.keyPress(KeyEvent.VK_O);
							rb.keyRelease(KeyEvent.VK_O);
		
							rb.keyPress(KeyEvent.VK_N);
							rb.keyRelease(KeyEvent.VK_N);
							
							rb.keyPress(KeyEvent.VK_E);
							rb.keyRelease(KeyEvent.VK_E);
							
							rb.keyPress(KeyEvent.VK_Y);
							rb.keyRelease(KeyEvent.VK_Y);
		
							rb.keyPress(KeyEvent.VK_SHIFT);
							rb.keyPress(KeyEvent.VK_D);
							rb.keyRelease(KeyEvent.VK_D);
							rb.keyRelease(KeyEvent.VK_SHIFT);
							
							rb.keyPress(KeyEvent.VK_U);
							rb.keyRelease(KeyEvent.VK_U);
							
							rb.keyPress(KeyEvent.VK_E);
							rb.keyRelease(KeyEvent.VK_E);
														break;
				case 2 ://Off Lappy

							rb.keyPress(KeyEvent.VK_SHIFT);
							rb.keyPress(KeyEvent.VK_U);
							rb.keyRelease(KeyEvent.VK_U);
							rb.keyRelease(KeyEvent.VK_SHIFT);
							
							rb.keyPress(KeyEvent.VK_T);
							rb.keyRelease(KeyEvent.VK_T);
							
							rb.keyPress(KeyEvent.VK_K);
							rb.keyRelease(KeyEvent.VK_K);
							
							rb.keyPress(KeyEvent.VK_A);
							rb.keyRelease(KeyEvent.VK_A);
							
							rb.keyPress(KeyEvent.VK_R);
							rb.keyRelease(KeyEvent.VK_R);
							
							rb.keyPress(KeyEvent.VK_S);
							rb.keyRelease(KeyEvent.VK_S);
							
							rb.keyPress(KeyEvent.VK_H);
							rb.keyRelease(KeyEvent.VK_H);
							Thread.sleep(500);
							
							rb.keyPress(KeyEvent.VK_SHIFT);
							rb.keyPress(KeyEvent.VK_MINUS);
							rb.keyRelease(KeyEvent.VK_MINUS);
							rb.keyRelease(KeyEvent.VK_SHIFT);
							
							rb.keyPress(KeyEvent.VK_SHIFT);
							rb.keyPress(KeyEvent.VK_S);
							rb.keyRelease(KeyEvent.VK_S);
							rb.keyRelease(KeyEvent.VK_SHIFT);
							
							rb.keyPress(KeyEvent.VK_I);
							rb.keyRelease(KeyEvent.VK_I);
							
							rb.keyPress(KeyEvent.VK_N);
							rb.keyRelease(KeyEvent.VK_N);
		
							rb.keyPress(KeyEvent.VK_H);
							rb.keyRelease(KeyEvent.VK_H);
		
							rb.keyPress(KeyEvent.VK_A);
							rb.keyRelease(KeyEvent.VK_A);
							break;
							
			}
						
			rb.keyPress(KeyEvent.VK_BACK_SLASH);
			rb.keyRelease(KeyEvent.VK_BACK_SLASH);
			
			rb.keyPress(KeyEvent.VK_SHIFT);
			rb.keyPress(KeyEvent.VK_D);
			rb.keyRelease(KeyEvent.VK_D);
			rb.keyRelease(KeyEvent.VK_SHIFT);
			
			rb.keyPress(KeyEvent.VK_O);
			rb.keyRelease(KeyEvent.VK_O);

			rb.keyPress(KeyEvent.VK_C);
			rb.keyRelease(KeyEvent.VK_C);

			rb.keyPress(KeyEvent.VK_U);
			rb.keyRelease(KeyEvent.VK_U);

			rb.keyPress(KeyEvent.VK_M);
			rb.keyRelease(KeyEvent.VK_M);

			rb.keyPress(KeyEvent.VK_E);
			rb.keyRelease(KeyEvent.VK_E);

			rb.keyPress(KeyEvent.VK_N);
			rb.keyRelease(KeyEvent.VK_N);

			rb.keyPress(KeyEvent.VK_T);
			rb.keyRelease(KeyEvent.VK_T);

			rb.keyPress(KeyEvent.VK_S);
			rb.keyRelease(KeyEvent.VK_S);

			

			rb.keyPress(KeyEvent.VK_BACK_SLASH);
			rb.keyRelease(KeyEvent.VK_BACK_SLASH);
			
			rb.keyPress(KeyEvent.VK_I);
			rb.keyRelease(KeyEvent.VK_I);

			rb.keyPress(KeyEvent.VK_M);
			rb.keyRelease(KeyEvent.VK_M);

			rb.keyPress(KeyEvent.VK_G);
			rb.keyRelease(KeyEvent.VK_G);
			
			rb.keyPress(KeyEvent.VK_BACK_SLASH);
			rb.keyRelease(KeyEvent.VK_BACK_SLASH);
			
			rb.keyPress(KeyEvent.VK_M);
			rb.keyRelease(KeyEvent.VK_M);
			
			rb.keyPress(KeyEvent.VK_A);
			rb.keyRelease(KeyEvent.VK_A);
			
			rb.keyPress(KeyEvent.VK_T);
			rb.keyRelease(KeyEvent.VK_T);

			rb.keyPress(KeyEvent.VK_1);
			rb.keyRelease(KeyEvent.VK_1);

			rb.keyPress(KeyEvent.VK_PERIOD);
			rb.keyRelease(KeyEvent.VK_PERIOD);
			
			rb.keyPress(KeyEvent.VK_P);
			rb.keyRelease(KeyEvent.VK_P);

			rb.keyPress(KeyEvent.VK_N);
			rb.keyRelease(KeyEvent.VK_N);

			rb.keyPress(KeyEvent.VK_G);
			rb.keyRelease(KeyEvent.VK_G);
			
			rb.keyPress(KeyEvent.VK_ENTER);  
	     	rb.keyRelease(KeyEvent.VK_ENTER);  
			Thread.sleep(2000);

		}
		private void createUserDir(final String dirName) throws IOException {
		    final File homeDir = new File(System.getProperty("user.home"));
		    final File dir = new File(homeDir, dirName);
		    if (!dir.exists() && !dir.mkdirs()) {
		        throw new IOException("Unable to create " + dir.getAbsolutePath());
		    }
		}
}
