package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.HomePage;
import page.LoginPage1;

public class TestLoginLogOut extends BaseTest {
	@Test(priority=1,groups={"login","smoke"})
	public void testLoginLogout() {
		String sheet="TestLoginLogout";
		String un = Utility.getXLData(INPUT_PATH, sheet, 1, 0);
		String pw = Utility.getXLData(INPUT_PATH, sheet, 1, 1);
		
		LoginPage1 loginPage=new LoginPage1(driver);
		loginPage.setUserName(un);
		loginPage.setPasword(pw);
		loginPage.clikLogin();
		
		HomePage homepage =new HomePage(driver);
		homepage.clikLogOutBtn();
		
		
		
		
		
		
	}
	

}
