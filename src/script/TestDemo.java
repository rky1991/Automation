package script;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.LoginPage;

public class TestDemo extends BaseTest {

	@Test
	public void testA() {
		String data = Utility.getXLData(INPUT_PATH, "sheet1", 0, 0);
		Reporter.log("Data:"+data,true);
		
		int r=Utility.getXLRowCount(INPUT_PATH, "sheet1");
		Reporter.log("Row:"+r,true);
		//Assert.fail();
	//	String p=Utility.getPhoto(driver, PHOTO_PATH);
	//	Reporter.log("Photo:"+p,true);
		
		String un = Utility.getXLData(INPUT_PATH, "sheet1", 1, 0);
		String pw = Utility.getXLData(INPUT_PATH, "sheet1", 1, 1);
		
		LoginPage l=new LoginPage(driver);
		
		l.setUserName(un);
		l.setPasword(pw);
		l.clikLogin();
		
		
	}
	
	
	
}
