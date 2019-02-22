package Basic;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeGroups;

public class testcase2 {

	public static WebDriver driver;

	@Before
	public static void launchBrowser() {
		driver = new FirefoxDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Before
	public void login() {
		driver.findElement(By.xpath("//*[@id='ctl00_MainContent_username']")).sendKeys("Tester");
		driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_password']")).sendKeys("test");
		driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_login_button']")).click();

	}

	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.xpath("//*[text()='Order']")).click();
		Select s = new Select(driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
		s.selectByVisibleText("FamilyAlbum");
		driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_txtQuantity']")).clear();
		driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_txtQuantity']")).sendKeys("10");
		driver.findElement(By.xpath("//*[@class='btn_dark']")).click();
		driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_txtName']")).sendKeys("Dhawal Thakre");
		driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_TextBox2']")).sendKeys("Mahal");
		driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_TextBox3']")).sendKeys("Nagpur");
		driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_TextBox4']")).sendKeys("Maharastra");
		driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_TextBox5']")).sendKeys("440032");
		driver.findElement(By.xpath("//*[@value='American Express']")).click();
		driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys("9766642019");
		driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_TextBox1']")).sendKeys("02/22");
		driver.findElement(By.xpath("//*[@class='btn_light']")).click();
		driver.findElement(By.xpath("//*[text()='View all orders']")).click();
        
		WebElement table = driver.findElement(By.xpath("//*[@class='SampleTable']/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		String personeName = "Dhawal Thakre";
		String city = "Nagpur";
		String product = "FamilyAlbum";
		String quantity = "10";
		String Street = "Mahal";
		String state = "Maharastra";
		String Zip = "440032";
		String card = "American Express";
		String cardNumber = "9766642019";
		String exp = "02/22";
		for (int i = 1; i < rows.size(); i++) {

			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

			if (personeName.contains("Dhawal"))

				System.out.println(cols.get(1).getText());

			if (product.contains("FamilyAlbum"))

				System.out.println(cols.get(2).getText());

			if (quantity.contains("10"))

				System.out.println(cols.get(3).getText());

			if (Street.contains("Mahal"))

				System.out.println(cols.get(5).getText());

			if (city.contains("Nagpur"))

				System.out.println(cols.get(6).getText());

			if (state.contains("Maharastra"))

				System.out.println(cols.get(7).getText());

			if (Zip.contains("440032"))

				System.out.println(cols.get(8).getText());

			if (card.contains("American"))

				System.out.println(cols.get(9).getText());

			if (cardNumber.contains("97666"))

				System.out.println(cols.get(10).getText());

			if (exp.contains("02/22")) {
				System.out.println(cols.get(11).getText());
				break;
			}
		}
	}

	@After
	public void logout() {

		driver.findElement(By.xpath("//*[text()='Logout']")).click();
	}

	@AfterClass
	public static void closeBrowser() {

		driver.quit();

	}

}
