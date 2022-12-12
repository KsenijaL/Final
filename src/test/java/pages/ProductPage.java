package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

import models.Product;
public class ProductPage {

    static Product product = new Product();

    public void setProductDetails() {

        WebElement n = $(By.xpath("//div[@class='product-righter google-rich-snippet']/h1"));
        product.setProductName(n.getText());

        WebElement p = $(By.xpath("//span[@class='price']/span[1]"));
        WebElement p2 = $(By.xpath("//span[@class='price']/span[2]"));
        product.setProductPrice(p.getText() + " " + p2.getText());
    }

    public void addToChart() {
        $(By.xpath("//button[@id='add_to_cart_btn']")).click();
    }

    public void moveToChart() {
        $(By.xpath("//div[@class='controls clearfix tac']/a[2]")).click();
    }
}
