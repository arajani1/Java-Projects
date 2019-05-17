package testingFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driver {

	public static void main(String[] args) throws InterruptedException {
		
		 //sets gecko webdriver to the executable found in this directory
		 String os = System.getProperty("os.name").toLowerCase();
		 
		 if (os.contains("mac")) {
			 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/geckodriver");
		 }
		 else {
			 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");
		 }
		 
		// Create a new instance of the Firefox driver
		 WebDriver driver = new FirefoxDriver();
		 
		 

		 //opens FireFox for testing
		 //sets a new loginPage object's driver to the instance of the Firefox driver
		 driver.get("https://demo.illuminateed.com/live");
		 loginPage page = new loginPage();
		 page.setDrive(driver);
		 
		 
		 //sample of username tests
		 String[] userTests = {"12.34@uci.edu","sam!!smith@uci.edu","*sam@uci.edu","s@uci.edu","sam@smith@uci.edu","sam.smith.uci.edu","s@uci.edu","@ucu.edi","samsmith@","sam.smith@uci.edu","..a@uci.edu","samsmith@uci.educ","samsmith@uci.e","sam_smith@uci.educa","sam_smith@uci.educ","sam smith@uci.edu"};
		 
		 //sample of password tests
		 String[] passTests = {"#BLACKlimo30","#BLA","<BLACKlimo30","BLACKlimo30","#BLACK_limo30","#BLACK limo30","#Blimo30","#blacklimo30","#BLACKlo30432","#BLACKlimo"};	
		 
		 testCases tester = new testCases(page);
		 
		 //runs through sample usernames and passwords and prints results of the tests
		 for(int i = 0; i < userTests.length; i++) {
			 for(int j = 0; j < passTests.length; j++) {
				 //System.out.println(tester.userAlphaNumericSpec(userTests[i],passTests[j]));
				 //System.out.println(tester.userSingularAtCheck(userTests[i],passTests[j]));
				 //System.out.println(tester.userFilledLocalandDomain(userTests[i],passTests[j]));
				 //System.out.println(tester.userConsecutiveDots(userTests[i],passTests[j]));
				 //System.out.println(tester.userDomainLengthCheck(userTests[i],passTests[j]));
				 //System.out.println(tester.userWhiteSpaceCheck(userTests[i],passTests[j]));
				 //System.out.println(tester.passLengthCheck(userTests[i],passTests[j]));
				 //System.out.println(tester.passSpecialCheck(userTests[i],passTests[j]));
				 //System.out.println(tester.passWhiteSpaceCheck(userTests[i],passTests[j]));
				 //System.out.println(tester.passUpperLowerCheck(userTests[i],passTests[j]));
				 //System.out.println(tester.passNumericalCheck(userTests[i],passTests[j]));
			 }
		 }
		 // Close the driver
		 driver.quit();
	}

}
