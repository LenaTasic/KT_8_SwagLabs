package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#user-name")
    WebElement username;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css = "#login-button")
    WebElement login;


    // By username = By.cssSelector("#user-name");
    //By password = By.cssSelector("#password");
    //By login = By.cssSelector("#login-button");

    /**
     * Use this method to login to app with valid username and password
     * @param usernameValue username
     * @param passwordValue password
     */

    public void login(String usernameValue, String passwordValue){
        enterUsername(usernameValue);
        enterPassword(passwordValue);
        clickLogin();
    }
    public void enterUsername(String usernameValue){
        typeText(username, usernameValue, "Username input" );
      //  driver.findElement(username).sendKeys(usernameValue);
    }

    public void enterPassword(String passwordValue){
        typeText(password, passwordValue, "Password input" );
      //  driver.findElement(password).sendKeys(passwordValue);
    }

    public void clickLogin(){
        clickElement(login, "Login Button");
    }
}
