package steps;

import io.cucumber.java.en.And;
import pages.BeautyPage;

public class BeautyPageSteps {
    BeautyPage beautyPage = new BeautyPage();

    @And("^^Select subgroup (Vīrieša skaistumam|Sievietes skaistumam|Skaistumam un veselībai|Rokas pulksteņi un rotas)$")
    public void selectSubgroup(String subGroup) {
        beautyPage.selectBeautySubGroup(subGroup);
    }

    @And("^^Select sub-group (Feni|Matu taisnotaji|Matu veidotaji|Lokskeres)$")
    public void selectSubGroup(String productType) {
        beautyPage.selectProductType(productType);
    }

    @And("^^Choose brand (Remington|Philips)$")
    public void chooseBrand(String productBrand) {
        beautyPage.selectProductBrand(productBrand);
    }

    @And("Select first item in the list")
    public void selectFirstItemInTheList() {
        beautyPage.selectFirstItem();
    }
}
