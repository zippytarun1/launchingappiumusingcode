import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SampleTest {

	@Test
	public void openUrl(){
		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
	   WebDriver driver = new ChromeDriver();
    
		driver.get("https://www.browserstack.com/support");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("is displayed" + driver.findElement(By.id("automate_button")).isDisplayed());
		driver.findElement(By.id("automate_button")).click();
	}
}
		
