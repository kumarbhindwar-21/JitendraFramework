package comqa.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	public static WebDriver startApllication(WebDriver driver,String browserName,String ulr) {
		
		if(browserName.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox")){
			driver=new FirefoxDriver();
			
		}else if(browserName.equals("edge")) {
			driver=new EdgeDriver();
			
		}else {
			System.out.println("we don not support this browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.get(ulr);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		
		return driver;
		
	}
	public static void quitBrowser(WebDriver driver  ) {
		driver.quit();
	}

}
