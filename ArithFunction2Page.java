package model.arithFunction2;
import model.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.stream.Collectors;

public class ArithFunction2Page extends BasePage<ArithFunction2Page, ArithFunction2EditPage,
        ArithFunction2ViewPage> {

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> valuesRow;

    @FindBy(xpath = "//tr/td/i")
    private WebElement checkBox;

    @FindBy(xpath = "//table/tbody/tr/td/a")
    private List<WebElement> recordedValues;

    @FindBy(xpath = "//i[text()='create_new_folder']")
    private WebElement createNewFolder;

    @FindBy(xpath = "//tr[1]//ul/li/a")
    private List<WebElement> menuOptions;

    @FindBy(linkText = "view")
    private WebElement viewButton;

    @FindBy(linkText = "edit")
    private WebElement editButton;

    @FindBy(linkText = "delete")
    private WebElement deleteButton;

    @FindBy(xpath = "//tr[1]//div/button[@data-toggle = 'dropdown']")
    private WebElement menuActionButton;

    @FindBy(xpath = "//a[@href = 'index.php?action=recycle_bin']")
    private WebElement recycleBin;

    @FindBy(xpath = "//div[@class = 'card-body ']")
    private WebElement cardBody;

    @Override
    protected ArithFunction2EditPage createEditPage() {

        return new ArithFunction2EditPage(getDriver());
    }

    @Override
    protected ArithFunction2ViewPage createViewPage() {

        return new ArithFunction2ViewPage(getDriver());

    }

    @Override
    protected ArithFunction2Page createMainPage() {

        return new ArithFunction2Page(getDriver());
    }

    public ArithFunction2Page(WebDriver driver) {

        super(driver);

    }

    public int getRowsCount() {

        return valuesRow.size();
    }

    public String getClassName() {

        return checkBox.getAttribute("class");
    }

    public List<String> getSavedValues() {
        return recordedValues.stream().map(element -> element.getAttribute("value"))
                .collect(Collectors.toList());
    }

    public List<String> getSavedValues1() {
        return recordedValues.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getRecycleBinText() {
        return getWait().until(ExpectedConditions.visibilityOf((recycleBin))).getText();
    }

    public ArithFunction2EditPage clickButtonCreateNewRecord() {
        createNewFolder.click();

        return new ArithFunction2EditPage(getDriver());
    }

    private void clickMenuActions() {
        menuActionButton.click();
        getWait().until(ExpectedConditions.visibilityOfAllElements(menuOptions));
    }

    public ArithFunction2ViewPage clickViewMenuAction() {
        clickMenuActions();
        getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("view"))).click();

        return new ArithFunction2ViewPage(getDriver());
    }

    public ArithFunction2EditPage clickEditMenuAction() {
        clickMenuActions();
        getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("edit"))).click();

        return new ArithFunction2EditPage(getDriver());
    }

    public ArithFunction2Page clickDeleteMenuAction() {
        clickMenuActions();
        getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("delete"))).click();

        return this;
    }

    public List<String> getRowAmount (int numberRows) {
        return valuesRow.get(numberRows).findElements(By.className("pa-list-table-th"))
                .stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public int getRowCount() {
        if (isTableEmpty()) {
            return 0;
        } else {
            return valuesRow.size();
        }
    }

    public boolean isTableEmpty () {

        return cardBody.getText().isEmpty();
    }
}
