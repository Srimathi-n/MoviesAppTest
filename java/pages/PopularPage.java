package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PopularPage {
	@FindBy(how = How.XPATH, using = "//a[@class='link-item']")
    List<WebElement> moviesEl;
    
  
    WebDriver driver;
    public PopularPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement isMovieElementsDisplayed(int index){
        return moviesEl.get(index);
    }

}
