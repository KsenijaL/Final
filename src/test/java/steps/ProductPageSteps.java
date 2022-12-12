package steps;

import io.cucumber.java.en.And;
import pages.ProductPage;

public class ProductPageSteps {

    ProductPage productPage=new ProductPage();

    @And("Add product to chart")
    public void addProductToChart() {
        productPage.setProductDetails();
        productPage.addToChart();
        productPage.moveToChart();
    }
}
