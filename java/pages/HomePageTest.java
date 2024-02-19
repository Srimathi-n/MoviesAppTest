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

public class HomePageTest {
    public WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
    @Test
    public void homePageUITest() throws InterruptedException{
        Assert.assertEquals(homePage.getHeadingTextAt(0),"Trending Now","Homepage heading doesn't match");
        Assert.assertEquals(homePage.getHeadingTextAt(1),"Originals","Homepage heading doesn't match");
        Assert.assertTrue(homePage.findPlayBtn().isDisplayed(),"Play button is not displayed");
        for(int i=0;i<4;i++){
            Assert.assertTrue(homePage.findMovieImageAt(i).isDisplayed(),"Movie image is not Displayed in Trending Now Section");
        }
        for(int i=10;i<14;i++){
            Assert.assertTrue(homePage.findMovieImageAt(i).isDisplayed(),"Movie image is not Displayed in Originals Section");
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        Assert.assertTrue(homePage.isContactUs().isDisplayed(),"Contact us section is not displayed");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

