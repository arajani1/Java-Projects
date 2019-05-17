package testingFramework;


public class testCases {
	
	loginPage p = new loginPage();
	static String error;
	static boolean autoTest;
	static boolean webError;
	
	//constructor for testCases objects that sets up page object to test on
	public testCases(loginPage p) {
		this.p = p;
	}
	
	//sets up test cases by setting expected value of webEerror to true
	//after logging in will change webError to false if the error element shows as none
	//initializes error to false for test case
	public void runTest(String user, String pass) {
		testCases.webError = true;
		p.loginTo(user, pass);
		if (p.getError() == "none") {
			testCases.webError = false;
		}
		testCases.error = "fail";
	}
	
	
	//tests if the username given has valid characters (letters, numbers, ".", "@", "-", "_")
	public String userAlphaNumericSpec(String user,String pass) {
		runTest(user, pass);
		autoTest = user.matches("^[^!#$%&*\\?\\+\\*\\^\\(\\)\\[\\]\\{\\}\\|\\\\<>=\"':/~`]*$");
		if(testCases.webError == testCases.autoTest) {
			testCases.error = "pass";
		}
		String message = "Only valid characters check for username ("+user+" "+pass+"): "+testCases.error;
		//assert testCases.webError == testCases.autoTest : message;
		return message;
	}
	
	//tests that the given username has just one @ sign
	public String userSingularAtCheck(String user,String pass) {
		runTest(user, pass);
		testCases.autoTest = user.matches("^([^@]*)@([^@]*)$");
		if(testCases.webError == testCases.autoTest) {
			testCases.error = "pass";
		}
		String message = "Only one @ sign check for username ("+user+" "+pass+"): "+testCases.error;
		//assert testCases.webError == testCases.autoTest : message;
		return message;
	}
	
	
	//tests that the given username has characters before and after the @ sign
	public String userFilledLocalandDomain(String user,String pass) {
		runTest(user, pass);
		testCases.autoTest = user.matches("^([^@]+)@([^@]+)$");
		if(testCases.webError == testCases.autoTest) {
			testCases.error = "pass";
		}
		String message = "Non-empty local and domain check for username ("+user+" "+pass+"): "+testCases.error;
		//assert testCases.webError == testCases.autoTest : message;
		return message;
	}
	
	//tests that the given username does not have to consecutive "."s
	public String userConsecutiveDots(String user,String pass) {
		runTest(user,pass);
		testCases.autoTest = user.matches("^(?!.*[.]{2})[\\w@.\\-_!#$%\\s&*\\\\?\\\\+\\\\*\\\\^\\\\(\\\\)\\\\[\\\\]\\\\{\\\\}\\\\|\\\\\\\\<>=\\\"':/~`]+$");
		if(testCases.webError == testCases.autoTest) {
			testCases.error = "pass";
		}
		String message = "Non-consecutive dots check for username ("+user+" "+pass+"): "+testCases.error;
		//assert testCases.webError == testCases.autoTest : message;
		return message;
	}
	
	//tests that the last domain in the username is between 2 and four letters
	public String userDomainLengthCheck(String user,String pass) {
		runTest(user,pass);
		testCases.autoTest = user.matches("^.*\\..{2,4}$");
		if(testCases.webError == testCases.autoTest) {
			testCases.error = "pass";
		}
		String message = "Domain length between 2 to four characters for username ("+user+" "+pass+"): "+testCases.error;
		//assert testCases.webError == testCases.autoTest : message;
		return message;
	}
	
	//tests that there are no white spaces in the given username
	public String userWhiteSpaceCheck(String user,String pass) {
		runTest(user,pass);
		testCases.autoTest = user.matches("^\\S*$");
		if(testCases.webError == testCases.autoTest) {
			testCases.error = "pass";
		}
		String message = "No white spaces for username ("+user+" "+pass+"): "+testCases.error;
		//assert testCases.webError == testCases.autoTest : message;
		return message;
	}
	
	//tests that the length of the password is greater than or equal to 5 characters
	public String passLengthCheck(String user,String pass) {
		runTest(user,pass);
		testCases.autoTest = pass.matches("^.{6}.+$");
		if(testCases.webError == testCases.autoTest) {
			testCases.error = "pass";
		}
		String message = "Length greater than 7 password ("+user+" "+pass+"): "+testCases.error;
		//assert testCases.webError == testCases.autoTest : message;
		return message;
	}
	
	//tests that there is at least one special character within the given password
	public String passSpecialCheck(String user,String pass) {
		runTest(user,pass);
		testCases.autoTest = pass.matches("^.*[^\\w\\d].*$");
		if(testCases.webError == testCases.autoTest) {
			testCases.error = "pass";
		}
		String message = "Sepcial character in password ("+user+" "+pass+"): "+testCases.error;
		//assert testCases.webError == testCases.autoTest : message;
		return message;
	}
	
	//tests that there are no white spaces within the given password
	public String passWhiteSpaceCheck(String user,String pass) {
		runTest(user,pass);
		testCases.autoTest = pass.matches("^\\\\S*$");
		if(testCases.webError == testCases.autoTest) {
			testCases.error = "pass";
		}
		String message = "No white spaces for ("+user+" "+pass+"): "+testCases.error;
		//assert testCases.webError == testCases.autoTest : message;
		return message;
	}
	
	//tests that there are both upperCase and lowerCase letters within the given password
	public String passUpperLowerCheck(String user,String pass) {
		runTest(user,pass);
		testCases.autoTest = (!pass.equals(pass.toLowerCase()) && !pass.equals(pass.toUpperCase()));
		if(testCases.webError == testCases.autoTest) {
			testCases.error = "pass";
		}
		String message = "Both uppercase and lowercase letters in password ("+user+" "+pass+"): "+testCases.error;
		//assert testCases.webError == testCases.autoTest : message;
		return message;
	}
	
	//tests that there is at least one numerical value within the given string
	public String passNumericalCheck(String user,String pass) {
		runTest(user,pass);
		testCases.autoTest = pass.matches(".*\\d.*");
		if(testCases.webError == testCases.autoTest) {
			testCases.error = "pass";
		}
		String message = "Numerical value in password ("+user+" "+pass+"): "+testCases.error;
		//assert testCases.webError == testCases.autoTest : message;
		return message;
	}
}
