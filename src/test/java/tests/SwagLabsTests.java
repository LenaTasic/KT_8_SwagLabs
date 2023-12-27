package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class SwagLabsTests extends BaseTest {

    @BeforeMethod
    public void setup(){
        baseSetup();

    }

    @AfterMethod
    public void tearDown(){
        baseTearDown();
    }

    @Test
    public void login() throws InterruptedException {
        driver.get("https://www.saucedemo.com/v1/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);

//        productsPage.addProduct("Sauce Labs Onesie");
//        productsPage.addProduct("Test.allTheThings() T-Shirt (Red)");
//        productsPage.addProduct("Sauce Labs Bike Light");

        productsPage.addProducts("Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)","Sauce Labs Bike Light");

//        productsPage.removeProduct("Sauce Labs Onesie");
//        productsPage.removeProduct("Test.allTheThings() T-Shirt (Red)");

        productsPage.removeProducts("Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)","Sauce Labs Bike Light");

        Thread.sleep(1000);

        String[] prices = productsPage.getPrices("Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)","Sauce Labs Bike Light");
        String[] expectedPrices = {"$7.99","$15.99","$9.99"};

        Assert.assertEquals(prices,expectedPrices);

//        Assert.assertEquals(productsPage.getPrice("Sauce Labs Onesie"),"$7.99");
//        Assert.assertEquals(productsPage.getPrice("Test.allTheThings() T-Shirt (Red)"),"$15.99");

        productsPage.openMenu();

    }
}
