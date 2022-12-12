package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomePageSteps {
    HomePage homePage = new HomePage();

    @Given("Open 1a.lv")
    public void openALv() {
        homePage.open1a();
    }

    @And("Cookies are closed")
    public void cookiesAreClosed() {
        homePage.closeCookies();
    }

    @When("^^Select group (Skaistumam un veselibai|Datortehnika, preces birojam)$")
    public void selectGroup(String productGroup) {
        homePage.selectGroup(productGroup);
    }

    @And("^^Sort result by (price_asc|price_desc|most_popular)$")
    public void sortResult(String sortBy) {
        homePage.sortResult(sortBy);
    }

    @And("^^Select product (Remington PROluxe CI9132, 32 mm|Remington Ci 6325, 25 mm)$")
    public void productIsSelected(String productName) {
        homePage.selectSpecificProduct(productName);
    }

    @And("Close Window")
    public void closeWindow() {
        homePage.closeWindow();
    }
}
