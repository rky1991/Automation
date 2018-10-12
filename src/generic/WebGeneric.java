package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class WebGeneric {
	public static void veriferPageDisplayed(WebDriver driver,long time, String partialURL) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.urlContains(partialURL));
			Reporter.log("Required page is displayed",true);
		}
		catch(Exception e) {
			Reporter.log("Required page is not displayed",true);
			Assert.fail();
		}
		
	}

}
