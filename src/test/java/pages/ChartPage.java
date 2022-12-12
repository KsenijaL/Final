package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;
import static pages.ProductPage.product;

import models.UserDetails;

public class ChartPage {
    UserDetails userDetails = new UserDetails();

    private final By productNameField = By.xpath("//a[@class='detailed-cart-item__name-link']");
    private final By productPriceField = By.xpath("//div[@class='detailed-cart-item__column detailed-cart-item__column--price']/p");
    private final By continueBuyingbtn = By.xpath("//input[@name='commit'][@type='submit']");
    private final By emailAdress = By.xpath("//input[@class='users-session-form__input users-session-form__input--text']");
    private final By buyAsNotRegisteredbtn = By.xpath("//input[@class='users-session-form__submit']");
    private final By deliveryTypeHome = By.xpath("//input[@name='shipping_unused'][@value='1']");
    private final By deliveryTypeOffice = By.xpath("//input[@name='shipping_unused'][@value='2']");
    private final By deliveryTypeParcel = By.xpath("//input[@name='shipping_unused'][@value='3']");
    private final By firstOffice = By.xpath("//div[@class='pickup-point-name']");
    private final By listOfOffices = By.xpath("//div[@class='pickup-point-name']");
    private final By userNameField = By.xpath("//input[@name='address[first_name]']");
    private final By userSurnameField = By.xpath("//input[@name='address[last_name]']");
    private final By userPhoneField = By.xpath("//input[@name='address[phone_number]']");
    private final By saveUserDetailsbtn = By.xpath("//button[@class='main-button upcase button-min-width']");
    private final By subminDetailsbtn = By.xpath("//button[@class='main-button upcase fr small-radius button-min-width checkout-shipping-continue-button']");
    private final By selectIbank = By.xpath("//ul[@class='menu menu--checkout']/li[1]");
    private final By selectCash = By.xpath("//ul[@class='menu menu--checkout']/li[2]");
    private final By selectTransfer = By.xpath("//ul[@class='menu menu--checkout']/li[3]");
    private final By selectCard = By.xpath("//ul[@class='menu menu--checkout']/li[4]");
    private final By buyerName = By.xpath("//div[@class='chosen-address']/div[1]");
    private final By buyerPhone = By.xpath("//div[@class='chosen-address']/div[2]");
    private final By price = By.xpath("//div[@class='price fr']");

    public void validateProductName() {

        String actualName = $(productNameField).getText();
        assertThat(actualName).isEqualTo(product.getProductName());
    }

    public void validateProductPrice() {
        String actualPrice = $(productPriceField).getText();
        assertThat(actualPrice).isEqualTo(product.getProductPrice());
    }

    public void continueBuying() {
        $$(continueBuyingbtn).first().click();
    }


    public void buyAsNotRegisteredUser() {
        $$(emailAdress).last().sendKeys(userDetails.getEmail());
        $$(buyAsNotRegisteredbtn).last().click();
    }

    public void selectDelivery(String deliveryType) {

        if (deliveryType.contains("home")) {
            $(deliveryTypeHome).click();
        } else if (deliveryType.contains("office")) {
            $(deliveryTypeOffice).click();
        } else if (deliveryType.contains("parcel")) {
            $(deliveryTypeParcel).click();
        } else {
            System.out.println("Wrong value selected. PLease select one of:Delivery at home / Pick up from office / Pick up from parcel machine");
        }
    }

    public void selectOffice(String cityName, String streetName) {
        $$(firstOffice).first().click();

        final ElementsCollection list = $$(listOfOffices);
        final int count = list.size();
        for (int i = 0; i < count; i++) {
            String a = list.get(i).getText();
            if ((a.contains(cityName)) && (a.contains(streetName))) {
                list.get(i).click();
            }
        }
    }

    public void fillInUserName() {
        $(userNameField).sendKeys(userDetails.getUserName());
    }

    public void fillInUserSurname() {
        $(userSurnameField).sendKeys(userDetails.getUserSurname());
    }

    public void fillInUserPhone() {
        $(userPhoneField).sendKeys(userDetails.getUserPhoneNumber());
    }

    public void saveUserDetails() {
        $(saveUserDetailsbtn).click();
    }

    public void submitDeliveryAndUserDetails() {
        $(subminDetailsbtn).click();
    }


    public void selectPaymentType(String paymentType) {
        if (paymentType.contains("IBank")) {
            $(selectIbank).click();
        } else if (paymentType.contains("cash")) {
            $(selectCash).click();
        } else if (paymentType.contains("transfer")) {
            $(selectTransfer).click();
        } else if (paymentType.contains("card")) {
            $(selectCard).click();
        }
    }


    public void validateUserNameBeforePayment() {
        String actualBuyer = $(buyerName).getText();
        assertThat(actualBuyer).isEqualTo(userDetails.getUserName() + " " + userDetails.getUserSurname());
    }

    public void validateUserPhoneNbrBeforePayment() {
        String actualPhoneNbr = $(buyerPhone).getText();
        assertThat(actualPhoneNbr).contains(userDetails.getUserPhoneNumber());
    }

    public void validateProductPriceBeforePayment() {
        String actualPrice = $(price).getText();
        assertThat(actualPrice).isEqualTo(product.getProductPrice());
    }
}

