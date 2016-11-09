import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

/**
 * Created by yandex1 on 06.11.2016.
 */
public class AddressWindow {

    public AddressWindow(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    @FindBy(css = "#map_search_string")
    private TextInput addressInput;

    @FindBy(css = ".search-delivery__btn-right")
    private Button submit;

    public void enterAddress(String s) {
        addressInput.sendKeys(s);
    }

    public void getFirstSuggestion() {
        addressInput.sendKeys(Keys.ENTER);
    }

    public void submit() {
        submit.click();
    }
}
