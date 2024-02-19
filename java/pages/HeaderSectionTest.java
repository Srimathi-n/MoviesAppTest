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
public class HeaderSectionTest {
	public WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    public WebDriverWait wait;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vijay\\eclipse-workspace\\MoviesAppTest\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();

        loginPage.loginToApp("rahul","rahul@2021");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
    @Test
    public void headerSectionUITest() throws InterruptedException{
        Assert.assertTrue(homePage.websiteLogoEl.isDisplayed(),"Website Logo is not displayed");
        for(int i=0;i<2;i++){
            Assert.assertTrue(homePage.isNavElementsDisplayed(i).isDisplayed(),"Nav element is not displayed");
        }
    }
    public void headerSectionFunctionalitiesTest() throws InterruptedException {
    	String expected = "https://qamoviesapp.ccbp.tech/popular";
    	homePage.homeEl.click();
    	//wait.wait(5000);
    	Thread.sleep(2000);
    	String actual = driver.getCurrentUrl();
    	Assert.assertEquals(actual, expected,"Navigation from Home page to Popular is not successful");
    	homePage.popularEl.click();
    	wait.wait(3000);
    	actual = driver.getCurrentUrl();
    	Assert.assertEquals(actual, "https://qamoviesapp.ccbp.tech/","Navigation from Popular page to Home is not successful");
    	homePage.accountEl.click();
    	wait.wait(3000);
    	actual = driver.getCurrentUrl(); 
    	Assert.assertEquals(actual, "https://qamoviesapp.ccbp.tech/account","Navigation from Home page to Accounts is not successful");
    	
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
