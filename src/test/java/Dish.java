import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by yandex1 on 01.11.2016.
 */
@FindBy(xpath = "")
public class Dish extends HtmlElement {

    @FindBy(css = ".btn-cart")
    private Button plus;

    public void addToCart() {
        plus.click();
    }
}
