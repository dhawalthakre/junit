package Basic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test1 {

	WebDriver driver;
	
	@Test
	public void testcase() {
		WebElement Email=driver.findElement(By.id("identifierId"));
		Email.sendKeys("Dhawal");
		
		
	}
	@Before
	public void launchBrowser()
	{
        driver=new FirefoxDriver();
		
		driver.get("https://mail.google.com");
		
	}

}
