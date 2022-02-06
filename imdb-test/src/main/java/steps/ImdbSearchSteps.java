package steps;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultPage;
import pages.SeriesPage;

public class ImdbSearchSteps {
	
	WebDriver driver;
	HomePage homePage;
	SearchResultPage searchResultPage;
	SeriesPage seriesPage;
	
	@Given("Navigate to Imdb Home Page")
	public void navigate_to_ýmdb_home_page() {
		this.driver = BaseSteps.driver;
		homePage = new HomePage(driver);
		homePage.goToHomePage();
	}
	@When("Search {string}")
	public void search(String seriesName) throws InterruptedException {
		searchResultPage = homePage.searchSeries(seriesName);
	}
	@When("Click first result")
	public void click_first_result() {
		seriesPage = searchResultPage.navigateToSeriesPage();
	}
	@Then("Check actual name is equal to {string}")
	public void check_actual_name_is_equal_to(String expectedName) {
		String actualName = seriesPage.getTitleText().toLowerCase();
		assertTrue(actualName.contains(expectedName.toLowerCase()), "Actual series name is not equal to expected series name. Actual name: " + actualName + " Expected name: " + expectedName);
	}
	@Then("Actual year are equal to {string}")
	public void actual_year_are_equal_to(String expectedYear) {
		String actualYear = seriesPage.getYearText().trim().replace("–", "-");
		assertTrue(actualYear.contains(expectedYear.trim()), "Actual year is not equal to expected year. Actual year: " + actualYear + " Expected year: "+ expectedYear);
	}
}
