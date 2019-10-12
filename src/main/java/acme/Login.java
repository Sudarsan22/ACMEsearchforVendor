package acme;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Login {

	@Test
	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://acme-test.uipath.com/account/login");
		Thread.sleep(3000);
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
		//driver.findElementById("email").sendKeys(Keys.TAB);
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("buttonLogin")).click();
		WebElement vendor = driver.findElementByXPath("(//button[@class='btn btn-default btn-lg'])[4]");
		WebElement SearchForVendor = driver.findElementByXPath("//*[text()='Search for Vendor']");
		Actions action = new Actions(driver);
		action.moveToElement(vendor).perform();
		action.click(SearchForVendor).perform();
		//comite
		driver.findElementByXPath("(//input[@type='text'])[2]").sendKeys("Blue Lagoon");
		driver.findElementByXPath("//button[@id='buttonSearch']").click();
		Thread.sleep(2000);
		String text = driver.findElementByXPath("//td[contains(text(), 'France')]").getText();
		System.out.println(text);
		driver.findElementByXPath("//*[text()='Log Out']").click();
		driver.close();
	}

}
