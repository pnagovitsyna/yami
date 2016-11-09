import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

/**
 * Created by yandex1 on 28.10.2016.
 */
public class CatalogPage {

    private WebDriver webDriver;

    public CatalogPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        webDriver = driver;
    }

    @FindBy(css = ".products-preview__item")
    private List<Dish> dishes;

    @FindBy(css = ".sideorder-cart__footer-item-value")
    private List<HtmlElement> sum;

    @FindBy(css = ".page-header-cart")
    private Button cartButton;

    @FindBy(css = ".sideorder-address__panel-content")
    private Button addressButton;

    @FindBy(css = ".double-group input[name='name']")
    private TextInput nameInput;

    // TODO to separate block
    @FindBy(css = ".double-group input[name='mobile']")
    private TextInput phoneInput;

    @FindBy(css = "textarea[name='comment']")
    private TextInput commentInput;

    @FindBy(css = ".js_order_submit")
    private Button submitOrderButton;

    public void addFullOrderToCart() {
        for (int i = 0; i < 3; i++) {
            dishes.get(i).addToCart();
        }
    }

    public void openCart() {
        cartButton.click();
    }

    public void clickAddressButton() {
        addressButton.click();

    }

    public int getSum() {
        String x = sum.get(0).getText();
        String y = x.substring(0, x.length() - 2);
        return new Integer(y);
    }

    public void setContacts(String name, String phone) {
        nameInput.sendKeys(name);
        phoneInput.sendKeys(phone);
    }

    public void setComment(String comment) {
        commentInput.sendKeys(comment);
    }

    public void submitOrder() {
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("window.scrollBy(0, 300)", "");
        submitOrderButton.click();
    }

    public void maximizeWindow() {
        webDriver.manage().window().setPosition(new Point(0, 0));
        webDriver.manage().window().setSize(new Dimension(1600 , 900));
    }
}
