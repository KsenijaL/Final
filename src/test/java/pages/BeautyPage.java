package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BeautyPage {

    public void selectBeautySubGroup(String subGroupName) {

        if (subGroupName.contains("Vīrieša skaistumam")) {
            $(By.xpath("//li[@class='new-cat-item'][1]")).click();
        } else if (subGroupName.contains("Sievietes skaistumam")) {
            $(By.xpath("//li[@class='new-cat-item'][2]")).click();
        } else if (subGroupName.contains("Skaistumam un veselībai")) {
            $(By.xpath("//li[@class='new-cat-item'][3]")).click();
        } else if (subGroupName.contains("Rokas pulksteņi un rotas")) {
            $(By.xpath("//li[@class='new-cat-item'][4]")).click();
        }
    }

    public void selectProductType(String productType) {

        if (productType.contains("Feni")) {
            $$(By.xpath("//a[@class='list-filterable__label']")).findBy(text("F")).click();

        } else if (productType.contains("Matu taisnotaji")) {
            $$(By.xpath("//a[@class='list-filterable__label']")).findBy(text("Matu taisnot")).click();

        } else if (productType.contains("Matu veidotaji")) {
            $$(By.xpath("//a[@class='list-filterable__label']")).findBy(text("Matu veidot")).click();

        } else if (productType.contains("Lokskeres")) {
            $$(By.xpath("//a[@class='list-filterable__label']")).findBy(text("Lok")).click();
        }

    }

    public void selectProductBrand(String productBrand) {

        $(By.xpath("//input[@class='catalog-taxons-filter-multiselect__search-input list-filterable__input'][@data-attr-id='2']")).sendKeys(productBrand);
        $$(By.xpath("//span[@class='catalog-taxons-filter-multiselect__link-label list-filterable__label']")).findBy(text(productBrand)).click();
        sleep(1000);
    }


    public void selectFirstItem() {
        sleep(1000);
        $(By.xpath("//div[@class='catalog-taxons-product catalog-taxons-product--grid-view'][1]")).hover();
        $$(By.xpath("//a[@class='catalog-taxons-product__name']")).first().click();
    }
}
