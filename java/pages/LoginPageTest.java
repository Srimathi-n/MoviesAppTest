package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginPageTest {
    public WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vijay\\eclipse-workspace\\MoviesAppTest\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void testLoginPageUI(){
        Assert.assertTrue(loginPage.findAppImage().isDisplayed(),"Login image is not displayed");
        Assert.assertEquals(loginPage.getHeadingText(),"Login", "Heading text does not match");
        Assert.assertEquals(loginPage.getTextContentAt(0),"USERNAME","User name label text does not match");
        Assert.assertEquals(loginPage.getTextContentAt(1),"PASSWORD","Password label text does not match");
        Assert.assertTrue(loginPage.findLoginBtn().isDisplayed(),"Login button is not displayed");
    }
    @Test(priority = 1)
    public void testWithEmptyInputFields(){
        loginPage.ClickonLoginBtn();
        Assert.assertEquals(loginPage.getErrorMsgText(),"*Username or password is invalid","Error text with empty input fields does not match");
    }
    @Test(priority = 2)
    public void testLoginWithEmptyUserId(){
        loginPage.EnterPassword("rahul@2021");
        loginPage.ClickonLoginBtn();
        Assert.assertEquals(loginPage.getErrorMsgText(),"*Username or password is invalid","Error text with empty input field do not match");
    }
    @Test(priority = 3)
    public void testLoginwithEmptyPin(){
        loginPage.EnterUsername("rahul");
        loginPage.ClickonLoginBtn();
        Assert.assertEquals(loginPage.getErrorMsgText(),"*Username or password is invalid","Error text with empty input field do not match");
    }
    @Test(priority = 4)
    public void testLoginWithInvalidPin(){
        loginPage.EnterUsername("rahul");
        loginPage.EnterPassword("rahul2021");
        loginPage.ClickonLoginBtn();
        Assert.assertEquals(loginPage.getErrorMsgText(),"*username and password didn't match","Error text with invalid PIN do not match");
    }
    @Test(priority = 5)
    public void testLoginWithValidCreds(){
        loginPage.EnterUsername("rahul");
        loginPage.EnterPassword("rahul@2021");
        loginPage.ClickonLoginBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, "https://qamoviesapp.ccbp.tech/","URLs do not match");
    }


}