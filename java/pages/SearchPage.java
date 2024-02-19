package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	@FindBy(how = How.CLASS_NAME, using = "search-empty-button")
    WebElement emptysearchBtnEl;
	@FindBy(how = How.ID, using = "search")
    WebElement searchInputBtnEl;
	@FindBy(how = How.CLASS_NAME, using = "search-button")
    WebElement searchBtnEl;
	@FindBy(how = How.XPATH, using = "//li[@class='movie-icon-item']")
    List<WebElement> listofmovies;

	WebDriver driver;
    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void ClickonSearchBtn() throws InterruptedException{
    	Thread.sleep(3000);
    	emptysearchBtnEl.click();
    }
    public void EnterMoviename(String movie) throws InterruptedException{
        searchInputBtnEl.sendKeys(movie);
        Thread.sleep(3000);
        searchBtnEl.click();
    }
    public int countOfMovies() throws InterruptedException{
    	Thread.sleep(3000);
    	return listofmovies.size();
    }
}