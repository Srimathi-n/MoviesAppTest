package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {
//	@FindBy(how = How.XPATH, using = "//h1[text()='Account']")
//    WebElement accountHeadingEl;
	@FindBy(how = How.CLASS_NAME, using = "account-heading")
	WebElement accountHeadingEl;
	@FindBy(how = How.XPATH, using = "//p[text()='Member ship']")
    WebElement memberShipEl;
	@FindBy(how = How.CLASS_NAME, using = "membership-username")
    WebElement userNameEl;
	@FindBy(how = How.CLASS_NAME, using = "membership-password")
    WebElement passwordEl;
	@FindBy(how = How.XPATH, using = "//p[text()='Plan details']")
    WebElement planDetailsEl;
	@FindBy(how = How.XPATH, using = "//p[text()='Premium']")
    WebElement premiumEl;
	@FindBy(how = How.XPATH, using = "//p[text()='Ultra HD']")
    WebElement ultraEl;
	@FindBy(how = How.CLASS_NAME, using = "logout-button")
    WebElement logoutBtnEl;
	WebDriver driver;
    public AccountsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void ClickonLogoutBtn(){
        logoutBtnEl.click();
    }

}
