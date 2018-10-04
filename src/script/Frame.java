package script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/Rahul/Desktop/page1.html");
		
		driver.switchTo().frame(0);
		driver.findElement(By.id("t2")).sendKeys("xyz");
		driver.switchTo().parentFrame();
		driver.findElement(By.id("t1")).sendKeys("abcde");
		
		driver.switchTo().frame("f1");//string
		driver.findElement(By.id("t2")).sendKeys("bcd");
		driver.switchTo().parentFrame();
		driver.findElement(By.id("t1")).sendKeys("bcd");
		
		WebElement e = driver.findElement(By.id("f1"));
		driver.switchTo().frame(e);
		driver.findElement(By.id("t2")).sendKeys("ccd");
		driver.switchTo().defaultContent();//directly come parent frame
		driver.findElement(By.id("t1")).sendKeys("ccd");
		
		
		
		

	}

}
