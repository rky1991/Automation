package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// decleration
	@FindBy(id="txtUsername")
	private WebElement unTB;
	@FindBy(id="txtPassword")
	private WebElement pwTB;
	@FindBy(id="btnLogin")
	private WebElement loginBTN;
	
	//initilization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	//utilization
	public void setUserName(String userName) {
		unTB.sendKeys(userName);
	}
	public void setPassword(String password) {
		pwTB.sendKeys(password);
	}
	public void clickLogin() {
		loginBTN.click();
	}

	
}
