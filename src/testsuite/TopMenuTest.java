package testsuite;

import browsefactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        WebElement computerLink = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li//a[text()='Computers ']"));
        computerLink.click();

        String expectedText = "Computers";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        driver.findElement(By.xpath("//div[6]/div[2]/ul[1]/li[2]/a")).click();

        String expectedText = "Electronics";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {

        WebElement apparel = driver.findElement(By.xpath("//div[6]/div[2]/ul[1]/li[3]/a"));
        apparel.click();
        String expectedText = "Apparel";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {

        WebElement digitalDownload = driver.findElement(By.xpath("//div[6]/div[2]/ul[1]/li[4]/a"));
        digitalDownload.click();
        String expectedText = "Digital downloads";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {

        WebElement booksPage = driver.findElement(By.xpath("//div[6]/div[2]/ul[1]/li[5]/a"));
        booksPage.click();
        String expectedText = "Books";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {

        WebElement jewelry = driver.findElement(By.xpath("//div[6]/div[2]/ul[1]/li[6]/a"));
        jewelry.click();
        String expectedText = "Jewelry";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {

        WebElement giftCards = driver.findElement(By.xpath("//div[6]/div[2]/ul[1]/li[7]/a"));
        giftCards.click();
        String expectedText = "Gift Cards";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
