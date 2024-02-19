package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage{
    @FindBy(how = How.CLASS_NAME, using = "login-website-logo")
    WebElement applogoimage;
    @FindBy(how = How.CLASS_NAME, using = "sign-in-heading")
    WebElement headingText;
    @FindBy(how = How.CLASS_NAME, using = "input-label")
    List<WebElement> listofInputLables;

    @FindBy(how = How.ID, using = "usernameInput")
    @CacheLookup
    WebElement usenameEl;
    @FindBy(how = How.ID, using = "passwordInput")
    @CacheLookup
    WebElement passwordEl;
    @FindBy(how = How.CLASS_NAME, using = "login-button")
    @CacheLookup
    WebElement loginbtn;
    @FindBy(how = How.CLASS_NAME, using = "error-message")
    @CacheLookup
    WebElement errorMsgTextEl;

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public WebElement findAppImage(){
        return applogoimage;
    }
    public WebElement findLoginBtn(){return  loginbtn; }
    public String getHeadingText(){
        return headingText.getText();
    }
    public String getTextContentAt(int index){
        return listofInputLables.get(index).getText();
    }
    public void EnterUsername(String username){
        usenameEl.sendKeys(username);
    }
    public void EnterPassword(String password){
        passwordEl.sendKeys(password);
    }
    public void ClickonLoginBtn(){
    	loginbtn.click();
    }
    public void loginToApp(String username, String password){
        EnterUsername(username);
        EnterPassword(password);
        ClickonLoginBtn();
    }
    public String getErrorMsgText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        return  errorMsgTextEl.getText();
    }

}

