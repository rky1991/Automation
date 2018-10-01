package generic;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
@Listeners(Result.class)
public abstract class BaseTest implements IAutoConst {
	//if webDriver is static, selenium gird will not work, parallel execution no possible
	public WebDriver driver;
	
	String url=Utility.getPropertyValue(CONFIG_PATH, "URL");
	String ITO=Utility.getPropertyValue(CONFIG_PATH, "ITO");
	public long duration= Long.parseLong(ITO);
	
	static {
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}
	@Parameters({"ip","browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApp(@Optional("localhost")String ip,@Optional("chrome")String browser ) {
	  //driver=new ChromeDriver();
	  driver=Utility.openBrowser(driver, ip, browser);	
	  driver.manage().timeouts().implicitlyWait(duration,TimeUnit.SECONDS);
	  driver.get(url);
		
	}
	@AfterMethod(alwaysRun=true)
	public void closeApp(ITestResult result) {
	//ITestResult result:- argument of testNG method "onTestFailure";
	//this method take care of screen shot when test is fail , it use the same variable "driver" of basetest class object;	
		String name=result.getName();
		int status = result.getStatus();
		if(status==2) {
			String path = Utility.getPhoto(driver, PHOTO_PATH);
			Reporter.log("Test:"+name+"is Failed & Photo is Taken at:"+path,true);
		}
		else
		{
			Reporter.log("Test:"+name+"is Passed & Photo is not Taken at:",true);
		}
		
		
		driver.close();
	}

}
