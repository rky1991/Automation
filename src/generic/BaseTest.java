package generic;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
@Listeners(Result.class)
public abstract class BaseTest implements IAutoConst {
	//if webDriver is static, selenium gird will not work, parallel execution no possible
	public WebDriver driver;
	String url=Utility.getPropertyValue(CONFIG_PATH, "URL");
	String time=Utility.getPropertyValue(CONFIG_PATH, "ITO");
	public long duration= Long.parseLong(time);
	
	static {
		System.setProperty(chrome_key,chrome_value);
		System.setProperty(gecko_key,gecko_value);
	}
	@BeforeMethod
	public void openApp() {
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(duration,TimeUnit.SECONDS);
		driver.get(url);
		
	}
	@AfterMethod
	public void closeApp() {
		driver.close();
	}

}
