package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ChartPage;


public class ChartPageSteps {

    ChartPage chartPage = new ChartPage();

    @Then("Product name in chart match with expected")
    public void productNameInChartMatchWithExpected() {
        chartPage.validateProductName();
    }

    @And("Product price in chart match with expected")
    public void productPriceInChartMatchWithExpected() {
        chartPage.validateProductPrice();
    }

    @When("Continue buying as not registered user")
    public void continueBuyingAsNotRegisteredUser() {
        chartPage.continueBuying();
        chartPage.buyAsNotRegisteredUser();
    }

    @And("^^Select delivery type (Delivery at home|Pick up from office|Pick up from parcel machine)$")
    public void selectDeliveryType(String deliveryType) {
        chartPage.selectDelivery(deliveryType);
    }

    @And("^^Specify pick-up office city (Daugavpils|Tukums) and street (Krauja|Kurzemes)$")
    public void specifyPickUpOfficeCityDaugavpilsAndStreetKrauja(String cityName, String streetName) {
        chartPage.selectOffice(cityName, streetName);
    }

    @And("Fill in user details")
    public void fillInUserDetails() {
        chartPage.fillInUserName();
        chartPage.fillInUserSurname();
        chartPage.fillInUserPhone();
        chartPage.saveUserDetails();
    }

    @And("Submit filled in details")
    public void submitFilledInDetails() {
        chartPage.submitDeliveryAndUserDetails();
    }

    @And("^^Select payment type (IBank|cash|transfer|card)$")
    public void selectPaymentType(String paymentType) {
        chartPage.selectPaymentType(paymentType);
    }

    @Then("^^Validate that (user name|user phone|product price) in payment page match with expected$")
    public void validateThatUserNameInPaymentPageMatchWithExpected(String detailToValidate) {
        if (detailToValidate == "user name") {
            chartPage.validateUserNameBeforePayment();
        } else if (detailToValidate == "user phone") {
            chartPage.validateUserPhoneNbrBeforePayment();
        } else if (detailToValidate == "product price") {
            chartPage.validateProductPriceBeforePayment();
        }
    }
}
