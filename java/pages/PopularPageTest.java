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

public class PopularPageTest {
	public WebDriver driver;
	PopularPage popularPage;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vijay\\eclipse-workspace\\MoviesAppTest\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        popularPage = new PopularPage(driver);
        driver.manage().window().maximize();

        loginPage.loginToApp("rahul","rahul@2021");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void popularPageUITest() throws InterruptedException{
    	homePage.popularEl.click();
        for(int i=0;i<20;i++){
        	Thread.sleep(2000);
            Assert.assertTrue(popularPage.isMovieElementsDisplayed(i).isDisplayed(),"Movies are not displayed");
        }
    }

}
