package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BeautyPage {

    private final By productSubGroupMen = By.xpath("//li[@class='new-cat-item'][1]");
    private final By productSubGroupWomen = By.xpath("//li[@class='new-cat-item'][2]");
    private final By productSubGroupBeauty = By.xpath("//li[@class='new-cat-item'][3]");
    private final By productSubGroupWatch = By.xpath("//li[@class='new-cat-item'][4]");
    private final By productTypeElement = By.xpath("//a[@class='list-filterable__label']");
    private final By brandInput = By.xpath("//input[@class='catalog-taxons-filter-multiselect__search-input list-filterable__input'][@data-attr-id='2']");
    private final By brandList = By.xpath("//span[@class='catalog-taxons-filter-multiselect__link-label list-filterable__label']");
    private final By firstProduct = By.xpath("//div[@class='catalog-taxons-product catalog-taxons-product--grid-view'][1]");
    private final By firstProductName = By.xpath("//a[@class='catalog-taxons-product__name']");


    public void selectBeautySubGroup(String subGroupName) {

        if (subGroupName.contains("Vīrieša skaistumam")) {
            $(productSubGroupMen).click();
        } else if (subGroupName.contains("Sievietes skaistumam")) {
            $(productSubGroupWomen).click();
        } else if (subGroupName.contains("Skaistumam un veselībai")) {
            $(productSubGroupBeauty).click();
        } else if (subGroupName.contains("Rokas pulksteņi un rotas")) {
            $(productSubGroupWatch).click();
        }
    }


    public void selectProductType(String productType) {

        if (productType.contains("Feni")) {
            $$(productTypeElement).findBy(text("F")).click();

        } else if (productType.contains("Matu taisnotaji")) {
            $$(productTypeElement).findBy(text("Matu taisnot")).click();

        } else if (productType.contains("Matu veidotaji")) {
            $$(productTypeElement).findBy(text("Matu veidot")).click();

        } else if (productType.contains("Lokskeres")) {
            $$(productTypeElement).findBy(text("Lok")).click();
        }

    }

    public void selectProductBrand(String productBrand) {

        $(brandInput).sendKeys(productBrand);
        $$(brandList).findBy(text(productBrand)).click();
    }


    public void selectFirstItem() {
        $(firstProduct).hover();
        $$(firstProductName).first().click();
    }
}
