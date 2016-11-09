/**
 * Created by yandex1 on 28.10.2016.
 */

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class OrderBrowserStack {

    String catalogAddress = "http://dev.yamiyami.ru/catalog";
    public static final String USERNAME = "polinanagovitsyn1";
    public static final String AUTOMATE_KEY = "sFa6gEGjbjvSCxGdV824";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    @Test
    public void test1() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "chrome");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("build", "First build");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        CatalogPage catalogPage = new CatalogPage(driver);
        driver.get(catalogAddress);
        catalogPage.addFullOrderToCart();

        driver.quit();
    }

//    @After
//    public void afterTest() {
//        driver.close();
//    }

}
