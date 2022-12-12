package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

import models.Product;

public class ProductPage {

    static Product product = new Product();

    private final By productName = By.xpath("//div[@class='product-righter google-rich-snippet']/h1");
    private final By productPrice = By.xpath("//span[@class='price']/span[1]");
    private final By productPriceCurrency = By.xpath("//span[@class='price']/span[2]");
    private final By addToChartbtn = By.xpath("//button[@id='add_to_cart_btn']");
    private final By moveToChartbtn = By.xpath("//div[@class='controls clearfix tac']/a[2]");

    public void setProductDetails() {

        WebElement n = $(productName);
        product.setProductName(n.getText());

        WebElement p = $(productPrice);
        WebElement p2 = $(productPriceCurrency);
        product.setProductPrice(p.getText() + " " + p2.getText());
    }

    public void addToChart() {
        $(addToChartbtn).click();
    }

    public void moveToChart() {
        $(moveToChartbtn).click();
    }
}
