package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {
	

	@FindBy(id="username")
	private WebElement unTB;
	@FindBy(name="pwd")
	private WebElement pwTB;
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBtn;
	public LoginPage1(WebDriver driver){
		
		PageFactory.initElements(driver,this);
		
	}
	public void setUserName(String userName) {
		unTB.sendKeys(userName);
	}
	public void setPasword(String Password) {
		pwTB.sendKeys(Password);
	}
	public void clikLogin() {
		loginBtn.click();
	}
	
	
	
	
	

}
