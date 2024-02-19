package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    @FindBy(how = How.CLASS_NAME, using = "home-movie-heading")
    WebElement homeMovieHeadingEl;

    @FindBy(how = How.CLASS_NAME, using = "movies-list-heading")
    List<WebElement> moviesListHeadingsEl;

    @FindBy(how = How.CLASS_NAME, using = "home-movie-play-button")
    WebElement playBtnEl;
    //@FindBy(how = How.XPATH, using = "//img[@alt = 'No Time to Die']")
    //WebElement noTimeImage;
    @FindBy(how = How.CLASS_NAME, using = "poster")
    List<WebElement> movieImagesEl;

    @FindBy(how = How.CLASS_NAME, using = "contact-us-paragraph")
    WebElement contactUsEl;
    @FindBy(how = How.CLASS_NAME, using = "website-logo")
    WebElement websiteLogoEl;
    @FindBy(how = How.XPATH, using = "//a[text()='Home']")
    WebElement homeEl;
    @FindBy(how = How.XPATH, using = "//a[text()='Popular']")
    WebElement popularEl;
    @FindBy(how = How.XPATH, using = "//li[@class='list-item']")
    List<WebElement> navBarEl;
    @FindBy(how = How.XPATH, using = "//button[@class='avatar-button']")
    WebElement accountEl;
    //locators for movie details page
    @FindBy(how = How.XPATH, using = "//div[@class='medium-screen-movie-container']")
    WebElement backgroundImage;
    @FindBy(how = How.XPATH, using = "//h1[@class='movie-title']")
    WebElement movieNameHeading;
    @FindBy(how = How.XPATH, using = "//p[@class='watch-time']")
    WebElement watchTime;
    @FindBy(how = How.XPATH, using = "//p[@class='sensor-rating']")
    WebElement sensorRating;
    @FindBy(how = How.XPATH, using = "//p[@class='release-year']")
    WebElement releaseYear;
    @FindBy(how = How.XPATH, using = "//p[@class='movie-overview']")
    WebElement movieOverview;
    @FindBy(how = How.XPATH, using = "//button[text()='Play']")
    WebElement movieplayBtn;
    @FindBy(how = How.XPATH, using = "//h1[text()='Genres']")
    WebElement genresLabel;
    @FindBy(how = How.XPATH, using = "//div[@class='genres-container']//p")
    List<WebElement> genresContainer;
    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Audio')]")
    WebElement audioLabel;
    @FindBy(how = How.XPATH, using = "//ul[@class='audio-container']//p")
    List<WebElement> audioContainer;
    @FindBy(how = How.XPATH, using = "//h1[@class='rating-heading']")
    WebElement ratingHeading;
    @FindBy(how = How.CSS, using = "div.rating-category>p:first-of-type")
    WebElement ratingCount;
    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Average')]")
    WebElement ratingAvg;
    @FindBy(how = How.CSS, using = "div.rating-category>:last-child")
    WebElement ratingValue;
    @FindBy(how = How.XPATH, using = "//h1[text()='Budget']")
    WebElement budgetLabel;
    @FindBy(how = How.CSS, using = "div.budget-category>p:first-of-type")
    WebElement budgetValue;
    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Release')]")
    WebElement releaseLabel;
    @FindBy(how = How.CSS, using = "div.budget-category>:last-child")
    WebElement releaseDate;
    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'More')]")
    WebElement moreLikeThis;
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Contact')]")
    WebElement contactUs;
    @FindBy(how = How.XPATH, using = "//img[@class='image-style']")
    List<WebElement> movieListContainer;
       
    
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String homePageHeading(){
        return homeMovieHeadingEl.getText();
    }
    public String getHeadingTextAt(int index){
        return moviesListHeadingsEl.get(index).getText();
    }
    public WebElement findPlayBtn() throws InterruptedException{
    	Thread.sleep(3000);
        return playBtnEl;
    }
    public WebElement findMovieImageAt(int index){
        return movieImagesEl.get(index);
    }
    public WebElement isContactUs(){
        return contactUsEl;
    }
    public WebElement isWebsiteLogo(){
        return websiteLogoEl;
    }
    public WebElement isNavElementsDisplayed(int index){
        return navBarEl.get(index);
    }
    public WebElement isbackGroundImage(){
        return backgroundImage;
    }
    public WebElement isGenresDisplayed(int index){
        return genresContainer.get(index);
    }
    public WebElement isAudioContainerDisplayed(int index){
        return audioContainer.get(index);
    }
    public WebElement isMovieContainerDisplayed(int index){
        return movieListContainer.get(index);
    }
    

}

