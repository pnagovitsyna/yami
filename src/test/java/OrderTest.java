/**
 * Created by yandex1 on 28.10.2016.
 */

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OrderTest {

    String chromePath = "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe";
    String chromeDriverPath = "C:/Users/yandex1/Documents/breadhead/yami/chromedriver.exe";
    String catalogAddress = "http://yamiyami.ru/catalog";
    private WebDriver driver = createChromeDriver();
    private CatalogPage catalogPage = new CatalogPage(driver);
    private AddressWindow addressWindow = new AddressWindow(driver);
    private final String NAME = "test_1";
    private final String PHONE = "9998887766";
    private final String COMMENT = "Это тестовый заказ, выполнять не нужно!";

    @Test
    public void test1() {
        driver.get(catalogAddress);
        catalogPage.maximizeWindow();
        catalogPage.addFullOrderToCart();
//        catalogPage.openCart();
        catalogPage.clickAddressButton();
        addressWindow.enterAddress("поселок Парголово, ул Заречная, д 19 к 1 кв 454");
        addressWindow.getFirstSuggestion();
        addressWindow.submit();
        catalogPage.setContacts(NAME, PHONE);
        catalogPage.setComment(COMMENT);
//        catalogPage.submitOrder();
    }

    @After
    public void afterTest() {
        driver.close();
    }

    private WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary(chromePath);
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        return new ChromeDriver();
    }
}
