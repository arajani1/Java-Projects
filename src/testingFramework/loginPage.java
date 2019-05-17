package testingFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	
	WebDriver driver;
	
	//assigns variable names to elements on webpage by their id, name, or class name
	By username = By.id("username");

    By password = By.id("password");

    By titleText = By.className("district");
    
    By forgotButton = By.className("forgot");

    By signInButton = By.name("button_next");
    
    By error = By.id("invalid_login");

    
    //sets the webdriver to be used to represent the loginPage
    public void setDrive(WebDriver driver){

        this.driver = driver;

    }

    //Set user name in textbox

    public void setUserName(String strUserName){

        driver.findElement(username).sendKeys(strUserName);

    }

    //Set password in password textbox

    public void setPassword(String strPassword){

         driver.findElement(password).sendKeys(strPassword);

    }
    
    //clear text in password box
    
    public void clearPassword(){

        driver.findElement(password).clear();

   }
    
    //clear text in username box
    
    public void clearUsername(){

        driver.findElement(username).clear();

   }

    //Click on login button

    public void clickSignIn(){

            driver.findElement(signInButton).click();

    }

    //Get the title of Login Page

    public String getLoginTitle(){

    	return driver.findElement(titleText).getText();

    }
    
    //get display of error element (if it is none it means that there are no errors with the sign in)
    
    public String getError(){

    	return driver.findElement(error).getAttribute("display");

    }
    
    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */
    
    //logs in to site and refreshes textbox values

    public void loginTo(String strUserName,String strPasword){

        //Fill user name

        this.setUserName(strUserName);

        //Fill password

        this.setPassword(strPasword);

        //Click Login button

        this.clickSignIn(); 
        
        this.clearUsername();
        
        this.clearPassword();
        
        
    }

}