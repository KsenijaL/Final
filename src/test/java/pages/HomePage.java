package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import models.Product;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    Product product = new Product();

    private final By closeCookies = By.xpath("//a[@class='c-button-inverse'][@onclick='Cookiebot.dialog.submitConsent()']");
    private final By productGroupBeauty = By.xpath("//li[@class='submenu-lvl1__list-item color-theme-16 submenu-lvl1__list-item--has-child']");
    private final By productGroupPC = By.xpath("//li[@class='submenu-lvl1__list-item color-theme-17 submenu-lvl1__list-item--has-child']");
    private final By priceAsc = By.xpath("//select[@class='catalog-taxons-view-tools__sort-select select2-hidden-accessible']");
    private final By priceDesc = By.xpath("//select[@class='catalog-taxons-view-tools__sort-select select2-hidden-accessible']");
    private final By mostPopular = By.xpath("//select[@class='catalog-taxons-view-tools__sort-select select2-hidden-accessible']");
    private final By productSearchInput = By.xpath("//input[@class='sn-suggest-input autocomplete main-search-input']");
    private final By productSearchSuggestion = By.xpath("//div[@class='sn-suggest-doc sn-suggest-item ks-senukai-v2']");

    public void open1a() {
        open("https://www.1a.lv/");
        Configuration.holdBrowserOpen = true;
    }

    public void closeCookies() {
        $(closeCookies).click();

    }

    public void selectGroup(String productGroup) {

        if (productGroup.contains("Skaistumam")) {
            $$(productGroupBeauty).last().click();
        } else if (productGroup.contains("Datortehnika")) {
            $$(productGroupPC).last().click();
        }
    }

    public void sortResult(String sortBy) {
        if (sortBy.contains("price_asc")) {
            $(priceAsc).selectOptionByValue("price__asc");
        } else if (sortBy.contains("price_desc")) {
            $(priceDesc).selectOptionByValue("price__desc");
        } else {
            $(mostPopular).selectOptionByValue("");
        }
    }

    public void selectSpecificProduct(String productName) {
        $(productSearchInput).sendKeys(productName);
        $(productSearchSuggestion).click();
    }

    public void closeWindow() {
        Selenide.closeWindow();

    }
}


