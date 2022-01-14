import base.BaseTest;
import model.arithFunction2.ArithFunction2Page;
import model.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class EntityArithFunction2Test extends BaseTest {

    private static final String[] RESULTS_NEW = {"547", "0", "547", "547", "0", "0"};
    private static final String[] RESULTS = {"547", "693", "1240", "-146", "379071", "1"};
    private static final String[] RESULTS_NEW_2 = {"693", "1240", "1933", "-547", "859320", "1"};
    final static String CHECK_BOX = "fa fa-check-square-o";

    public void checkResults(String[] recordedValuesAndResults) {

        List<WebElement> newElements = getDriver().findElements(By.xpath("//table/tbody/tr/td/a"));
        List<String> newActualValues = new ArrayList<>();
        for (int i = 0; i < newElements.size(); i++) {
            newActualValues.add(i, newElements.get(i).getText());
            {
                Assert.assertEquals(newElements.get(i).getText(), recordedValuesAndResults[i]);
            }
        }
        System.out.println(newActualValues);
    }

    @Test
    public void testCreateNewRecordArFun2() {

        ArithFunction2Page arithFunction2Page = new HomePage(getDriver())
                .clickArithFunction2MenuItem()
                .clickButtonCreateNewRecord()
                .fillFieldF1(RESULTS[0])
                .fillFieldF2(RESULTS[1])
                .clickSaveButton();

        Assert.assertEquals(arithFunction2Page.getRowsCount(), 1);
        Assert.assertEquals(arithFunction2Page.getClassName(), CHECK_BOX);
        Assert.assertEquals(arithFunction2Page.getSavedValues().size(), RESULTS.length);
        Assert.assertEquals(arithFunction2Page.getSavedValues1().size(), RESULTS.length);

        checkResults(RESULTS);
    }

    @Test
    public void testEditRecordArFun2() {

        ArithFunction2Page arithFunction2Page = new HomePage(getDriver())
                .clickArithFunction2MenuItem()
                .clickButtonCreateNewRecord()
                        .fillFieldF1(RESULTS[0])
                                .fillFieldF2(RESULTS[1])
                                        .clickSaveButton()
               .clickEditMenuAction()
                          .fillFieldF2Edit(RESULTS_NEW[1])
                .clickSaveButton()
                        .clickDeleteMenuAction().clickButtonCreateNewRecord()
        .fillFieldF1(RESULTS[1]).fillFieldF2(RESULTS[2])
        .clickSaveButton();

        Assert.assertEquals(arithFunction2Page.getRowsCount(), 1);
        Assert.assertEquals(arithFunction2Page.getClassName(), CHECK_BOX);
        Assert.assertEquals(arithFunction2Page.getSavedValues().size(), RESULTS_NEW_2.length);

        checkResults(RESULTS_NEW_2);
    }
}

