package pages;

import com.codeborne.selenide.Configuration;
import models.Product;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    Product product = new Product();

    public void open1a() {
        open("https://www.1a.lv/");
        Configuration.holdBrowserOpen = true;
    }

    public void closeCookies() {
        if ($(By.xpath("//div[@id='cookie-checks']")).isDisplayed()) {
            $(By.xpath("//a[@class='c-button-inverse'][@onclick='Cookiebot.dialog.submitConsent()']")).click();
        }
    }

    public void selectGroup(String productGroup) {

        if (productGroup.contains("Skaistumam")) {
            $$(By.xpath("//li[@class='submenu-lvl1__list-item color-theme-16 submenu-lvl1__list-item--has-child']")).last().click();
        } else if (productGroup.contains("Datortehnika")) {
            $$(By.xpath("//li[@class='submenu-lvl1__list-item color-theme-17 submenu-lvl1__list-item--has-child']")).last().click();
        }
    }

    public void sortResult(String sortBy) {
        if (sortBy.contains("price_asc")) {
            $(By.xpath("//select[@class='catalog-taxons-view-tools__sort-select select2-hidden-accessible']")).selectOptionByValue("price__asc");
        } else if (sortBy.contains("price_desc")) {
            $(By.xpath("//select[@class='catalog-taxons-view-tools__sort-select select2-hidden-accessible']")).selectOptionByValue("price__desc");
        } else {
            $(By.xpath("//select[@class='catalog-taxons-view-tools__sort-select select2-hidden-accessible']")).selectOptionByValue("");
        }
    }

    public void selectSpecificProduct(String productName) {
        $(By.xpath("//input[@class='sn-suggest-input autocomplete main-search-input']")).sendKeys(productName);
        $(By.xpath("//div[@class='sn-suggest-doc sn-suggest-item ks-senukai-v2']")).click();

    }

}


