package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Note:- this class done by me no proper POM
public class LoginPage  {

	//Decleration
	private WebElement unTB;
	private WebElement pwTB;
	private WebElement loginBTN;
    //initilization--
	
	public LoginPage(WebDriver driver) {
	
		unTB=driver.findElement(By.id("username"));
		pwTB=driver.findElement(By.name("pwd"));
		loginBTN=driver.findElement(By.xpath("//div[.='Login ']"));
	}
	
	//utilization----
	public void setUserName(String un) {
		unTB.sendKeys(un);
	}
	public void setPasword(String pw) {
		pwTB.sendKeys(pw);
	}
	public void clikLogin() {
		loginBTN.click();
	}
	

}
