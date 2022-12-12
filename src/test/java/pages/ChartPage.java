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

    public void validateProductName() {

        String actualName = $(By.xpath("//a[@class='detailed-cart-item__name-link']")).getText();
        assertThat(actualName).isEqualTo(product.getProductName());
    }

    public void validateProductPrice() {
        String actualPrice = $(By.xpath("//div[@class='detailed-cart-item__column detailed-cart-item__column--price']/p")).getText();
        assertThat(actualPrice).isEqualTo(product.getProductPrice());
    }

    public void continueBuying() {
        $$(By.xpath("//input[@name='commit'][@type='submit']")).first().click();
    }

    public void buyAsNotRegisteredUser() {
        $$(By.xpath("//input[@class='users-session-form__input users-session-form__input--text']")).last().sendKeys(userDetails.getEmail());
        $$(By.xpath("//input[@class='users-session-form__submit']")).last().click();
    }

    public void selectDelivery(String deliveryType) {


        if (deliveryType.contains("home")) {
            $(By.xpath("//input[@name='shipping_unused'][@value='1']")).click();
        } else if (deliveryType.contains("office")) {
            $(By.xpath("//input[@name='shipping_unused'][@value='2']")).click();
        } else if (deliveryType.contains("parcel")) {
            $(By.xpath("//input[@name='shipping_unused'][@value='3']")).click();
        } else {
            System.out.println("Wrong value selected. PLease select one of:Delivery at home / Pick up from office / Pick up from parcel machine");
        }
    }

    public void selectOffice(String cityName, String streetName) {
        $$(byXpath("//div[@class='pickup-point-name']")).first().click();

        final ElementsCollection list = $$(byXpath("//div[@class='pickup-point-name']"));
        final int count = list.size();
        for (int i = 0; i < count; i++) {
            String a = list.get(i).getText();
            if ((a.contains(cityName)) && (a.contains(streetName))) {
                list.get(i).click();
            }
        }
    }

    public void fillInUserName() {
        $(By.xpath("//input[@name='address[first_name]']")).sendKeys(userDetails.getUserName());
    }

    public void fillInUserSurname() {
        $(By.xpath("//input[@name='address[last_name]']")).sendKeys(userDetails.getUserSurname());
    }

    public void fillInUserPhone() {
        $(By.xpath("//input[@name='address[phone_number]']")).sendKeys(userDetails.getUserPhoneNumber());
    }

    public void saveUserDetails() {
        $(By.xpath("//button[@class='main-button upcase button-min-width']")).click();
    }

    public void submitDeliveryAndUserDetails() {
        $(By.xpath("//button[@class='main-button upcase fr small-radius button-min-width checkout-shipping-continue-button']")).click();
    }

    public void selectPaymentType(String paymentType) {
        if (paymentType.contains("IBank")) {
            $(By.xpath("//ul[@class='menu menu--checkout']/li[1]")).click();
        } else if (paymentType.contains("cash")) {
            $(By.xpath("//ul[@class='menu menu--checkout']/li[2]")).click();
        } else if (paymentType.contains("transfer")) {
            $(By.xpath("//ul[@class='menu menu--checkout']/li[3]")).click();
        } else if (paymentType.contains("card")) {
            $(By.xpath("//ul[@class='menu menu--checkout']/li[4]")).click();
        }
    }

    public void validateUserNameBeforePayment() {
        String actualBuyer = $(By.xpath("//div[@class='chosen-address']/div[1]")).getText();
        assertThat(actualBuyer).isEqualTo(userDetails.getUserName() + " " + userDetails.getUserSurname());
    }

    public void validateUserPhoneNbrBeforePayment() {
        String actualPhoneNbr = $(By.xpath("//div[@class='chosen-address']/div[2]")).getText();
        assertThat(actualPhoneNbr).contains(userDetails.getUserPhoneNumber());
    }

    public void validateProductPriceBeforePayment() {
        String actualPrice = $(By.xpath("//div[@class='price fr']")).getText();
        assertThat(actualPrice).isEqualTo(product.getProductPrice());
    }
}

