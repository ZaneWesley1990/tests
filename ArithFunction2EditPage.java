package model.arithFunction2;
import model.base.BaseEditPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ArithFunction2EditPage extends BaseEditPage<ArithFunction2Page> {

    @FindBy(id = "sum")
    private WebElement sumElement;

    @FindBy(id = "sub")
    private WebElement subElement;

    @FindBy(id = "mul")
    private WebElement mulElement;

    @FindBy(id = "div")
    private WebElement divElement;

    @FindBy(xpath = "//*[@id='f1']")
    private WebElement fieldF1;

    @FindBy(xpath ="//*[@id='f2']")
    private WebElement fieldF2;

    @FindBy(xpath = "//p[text()= ' Default ']")
    private WebElement defaultMenuItem;

    @FindBy(id = "pa-entity-form-save-btn")
    private WebElement saveButton;

    @Override
    protected ArithFunction2Page createMainPage() {

        return new ArithFunction2Page(getDriver());
    }

    public ArithFunction2EditPage(WebDriver driver) {

        super(driver);
    }

    private void clear(WebElement field) {

        if (!field.getAttribute("value").isEmpty()) {
            field.clear();
        }
    }
        private void clearAllFields() {

            fieldF1.clear();
            fieldF2.clear();
            sumElement.clear();
            subElement.clear();
            mulElement.clear();
            divElement.clear();
        }

    public ArithFunction2Page clickSaveButton() {
        getWait().until(ExpectedConditions.elementToBeClickable(saveButton)).click();

        return new ArithFunction2Page(getDriver());
    }

    public ArithFunction2EditPage fillFieldF1(String value1) {

    clearAllFields();
    fieldF1.clear();
    getWait().until(ExpectedConditions.elementToBeClickable(fieldF1)).sendKeys(value1);
    getWait().until(ExpectedConditions.attributeToBe(fieldF1, "value", value1));

    return this;

    }

    public ArithFunction2EditPage fillFieldF2(String value2) {
    fieldF2.clear();
    getWait().until(ExpectedConditions.elementToBeClickable(fieldF2)).sendKeys(value2);
    getWait().until(ExpectedConditions.attributeToBe(fieldF2, "value", value2));

    return this;

    }

    public ArithFunction2EditPage fillFieldF2Edit(String valueEdited) {

    getWait().until(ExpectedConditions.elementToBeClickable(fieldF2)).clear();
    getWait().until(ExpectedConditions.elementToBeClickable(fieldF2)).sendKeys(valueEdited);
    getWait().until(ExpectedConditions.attributeToBe(fieldF2, "value", valueEdited));

    return this;

    }
}






