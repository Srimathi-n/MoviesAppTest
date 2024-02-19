package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class AccountsPageTest {
	public WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    AccountsPage accountsPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vijay\\eclipse-workspace\\MoviesAppTest\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountsPage = new AccountsPage(driver);
        driver.manage().window().maximize();

        loginPage.loginToApp("rahul","rahul@2021");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
    @Test
    public void accountsPageUITest() throws InterruptedException{
    	homePage.accountEl.click();
    	Thread.sleep(5000);
        Assert.assertTrue(accountsPage.accountHeadingEl.isDisplayed(),"Account heading is not displayed");
        Assert.assertTrue(accountsPage.memberShipEl.isDisplayed(),"Membership Label is not displayed");
        Assert.assertTrue(accountsPage.userNameEl.isDisplayed(),"Username is not displayed");
        Assert.assertTrue(accountsPage.passwordEl.isDisplayed(),"Password is not displayed");
        Assert.assertTrue(accountsPage.planDetailsEl.isDisplayed(),"Palndetails Label is not displayed");
        Assert.assertTrue(accountsPage.premiumEl.isDisplayed(),"Premium Label is not displayed");
        Assert.assertTrue(accountsPage.ultraEl.isDisplayed(),"Ultra Label is not displayed");
        Assert.assertTrue(accountsPage.logoutBtnEl.isDisplayed(),"Logout Button is not displayed");
        Assert.assertTrue(homePage.isContactUs().isDisplayed(),"Contact us section is not displayed");
    }
    @Test
    public void testLogoutFunctionality() throws InterruptedException{
    	homePage.accountEl.click();
    	Thread.sleep(5000);
    	accountsPage.ClickonLogoutBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/login"));
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, "https://qamoviesapp.ccbp.tech/login","URLs do not match");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
