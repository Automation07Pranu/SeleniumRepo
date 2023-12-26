package testngsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class SaucedemoTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setup(){
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
	}

	@Test(priority = 0,enabled = true)
	public void validateSauceDemoTitle() {
		String title=driver.getTitle();
		Assert.assertEquals(title, "Swag Labs");
	}

	@Test(priority = 1)
	public void loginfunction() throws InterruptedException {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(5000);
		boolean isHomePageDisplayed=driver.findElement(By.xpath("//span[text()='Products']")).isDisplayed();
		Assert.assertEquals(isHomePageDisplayed, true);
	}
	

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
