import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.firefox.*;
//Test Commit

public class IDBI {

public static void main(String[] args) throws InterruptedException
{
WebDriver driver = new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
driver.get("http://godarainfotech.in/index.php?show=postmatter");
driver.findElement(By.id("lusername")).sendKeys("utkarshsi");
driver.findElement(By.id("lpassword")).sendKeys("Kriti7333");
driver.findElement(By.id("loginsubmit")).click();
driver.get("http://godarainfotech.in/index.php?show=postmatter");
driver.findElement(By.xpath("//a[contains(text(),'View & Submit')]")).click();
String pageText = driver.findElement(By.id("matterdets")).getText();

driver.close();
System.out.println("Title to Use : "+ myMethod(pageText, "Title to Use :", "Matter to Use :"));
System.out.println("Matter to Use : "+ myMethod(pageText, "Matter to Use :", "Url to Use :"));
System.out.println("URl to Use : "+ myMethod(pageText, "Url to Use :", "Categories to Post :"));




}

public static String myMethod(String str,String s1,String s2)
{
	return str.substring(str.indexOf(s1) + s1.length(), str.indexOf(s2));
}
}

