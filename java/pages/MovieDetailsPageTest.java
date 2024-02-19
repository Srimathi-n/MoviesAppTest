package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MovieDetailsPageTest {
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
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void homepagemovieDetailstest() throws InterruptedException {
    	homePage.findMovieImageAt(0).click();
    	Thread.sleep(3000);
    	Assert.assertTrue(homePage.backgroundImage.isDisplayed(),"Movie background image is not displayed");
    	Assert.assertTrue(homePage.movieNameHeading.isDisplayed(),"Movie heading is not displayed");
    	Assert.assertTrue(homePage.watchTime.isDisplayed(),"Movie watch time is not displayed");
    	Assert.assertTrue(homePage.sensorRating.isDisplayed(),"Movie sensor rating is not displayed");
    	Assert.assertTrue(homePage.releaseYear.isDisplayed(),"Movie Release year is not displayed");
    	Assert.assertTrue(homePage.movieOverview.isDisplayed(),"Movie background image is not displayed");
    	Assert.assertTrue(homePage.movieplayBtn.isDisplayed(),"Movie background image is not displayed");
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        Assert.assertTrue(homePage.genresLabel.isDisplayed(),"Movie Genres is not displayed");
    	for(int i=0;i<homePage.genresContainer.size();i++){
            Assert.assertTrue(homePage.isGenresDisplayed(i).isDisplayed(),"Genres element is not Displayed in Trending Now Section");
        }
    	Thread.sleep(2000);
    	Assert.assertTrue(homePage.audioLabel.isDisplayed(),"Movie Genres is not displayed");
    	for(int i=0;i<homePage.audioContainer.size();i++){
            Assert.assertTrue(homePage.isAudioContainerDisplayed(i).isDisplayed(),"Genres element is not Displayed in Trending Now Section");
        }
    	Assert.assertTrue(homePage.ratingHeading.isDisplayed(),"Movie Rating is not displayed");
    	Assert.assertTrue(homePage.ratingCount.isDisplayed(),"Movie Rating Count is not displayed");
    	Assert.assertTrue(homePage.ratingAvg.isDisplayed(),"Movie Rating Average is not displayed");
    	Assert.assertTrue(homePage.ratingValue.isDisplayed(),"Movie Rating value is not displayed");
    	Assert.assertTrue(homePage.budgetLabel.isDisplayed(),"Movie Budget is not displayed");
    	Assert.assertTrue(homePage.budgetValue.isDisplayed(),"Movie Budget value is not displayed");
    	Assert.assertTrue(homePage.releaseLabel.isDisplayed(),"Movie Release label is not displayed");
    	Assert.assertTrue(homePage.releaseDate.isDisplayed(),"Movie Release Date is not displayed");
    	Assert.assertTrue(homePage.moreLikeThis.isDisplayed(),"Movie More Like This label is not displayed");
    	
    	js.executeScript("window.scrollBy(0, 500)");
    	Thread.sleep(2000);
    	for(int i=0;i<homePage.movieListContainer.size();i++){
            Assert.assertTrue(homePage.isMovieContainerDisplayed(i).isDisplayed(),"Genres element is not Displayed in Trending Now Section");
        }
    	Thread.sleep(2000);
    	js.executeScript("window.scrollBy(0, 1000)");
    	Assert.assertTrue(homePage.contactUs.isDisplayed(),"Contact Us section is not displayed");
    }


}
