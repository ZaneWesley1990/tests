package model.arithFunction2;
import model.base.BaseViewPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithFunction2ViewPage extends BaseViewPage<ArithFunction2Page> {

    @FindBy(xpath = "//*[@class='btn btn-sm pa-btn-close-form']")
    private WebElement endViewModeButton;

    @FindBy(xpath = "//*[@class='pa-view-field']")
    private List<WebElement> viewedValues;

    @Override
    protected ArithFunction2Page createMainPage() {

        return new ArithFunction2Page(getDriver());
    }

    public ArithFunction2ViewPage (WebDriver driver) {

        super(driver);
    }

    public ArithFunction2ViewPage clickViewButton() {

        getWait().until(ExpectedConditions.elementToBeClickable(endViewModeButton)).click();

        return new ArithFunction2ViewPage(getDriver());
    }

    public List<String> getViewedValues() {
        return viewedValues.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getViewedValues1() {
        List<String> listString= new ArrayList<>();
        for (WebElement webElement : viewedValues) {
            listString.add(webElement.getText());
        }

        return listString;
    }

    public List<String> getViewedValues2() {
        List<WebElement> viewedElements = viewedValues;
        List<String> actualValuesViewed = new ArrayList<>();

        for (int i = 0; i < viewedElements.size(); i++) {
            actualValuesViewed.add(i, viewedElements.get(i).getText());
        }

        return actualValuesViewed;
    }
}