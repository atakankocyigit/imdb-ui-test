package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject{
	
    private String url = "https://www.imdb.com/";
    By searchButton = By.id("suggestion-search");
    
    public HomePage(WebDriver driver){
        super(driver);
    }
    
    public void goToHomePage(){
        goToUrl(url);
    }
    
    public SearchResultPage searchSeries(String seriesName) throws InterruptedException{
        System.out.println(seriesName);
        sendKeys(searchButton, seriesName + Keys.ENTER, 10);
        return new SearchResultPage(driver);
    }
}
