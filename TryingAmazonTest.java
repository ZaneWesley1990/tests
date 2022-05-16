import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TryingAmazonTest {

    @Test
    public void amazonTest() throws InterruptedException {

        String result = "About this item";

        System.setProperty("webdriver.chrome.driver", "C:/webdriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");

        driver.manage().window().maximize();
        driver.findElement(By.id("nav-hamburger-menu")).click();
        Thread.sleep(500);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//*[@id='hmenu-content']/ul[1]/li[21]/a/div"));
        js.executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(By.xpath("//*[@id='hmenu-content']/ul[1]/li[23]/a[1]/div")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='hmenu-content']/ul[1]/ul[1]/li[2]/a/div")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='hmenu-content']/ul[15]/li[3]/a")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='a-page']/div[2]/div[2]/div[2]/div[1]/div/div[1]/ul[2]/li[1]/a")).click();
        Thread.sleep(500);

        WebElement element1 = driver.findElement(By.xpath("//*[@id='s-refinements']/div[16]/ul/li[4]/span/a/div/label/i"));
        js.executeScript("arguments[0].scrollIntoView();", element1);

        driver.findElement(By.xpath("//*[@id='s-refinements']/div[16]/ul/li[4]/span/a/div/label/i")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[@id='a-autoid-0-announce']")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("Price: High to Low")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[@id='search']/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div[1]/span/a/div/img")).click();
        Thread.sleep(500);

        WebElement element2 = driver.findElement(By.xpath("//*[@id='feature-bullets']/h1"));
        js.executeScript("arguments[0].scrollIntoView();", element2);

        String mainWord = element2.getText();
        Assert.assertEquals(mainWord, result);
        driver.quit();

        System.out.println("'About this item' is present on the Amazon website");
    }
}
