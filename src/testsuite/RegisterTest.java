package testsuite;

import browsefactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
  @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){

        driver.findElement(By.linkText("Register")).click();
        String expectedText = "Register";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
      Assert.assertEquals(expectedText,actualText);

    }

    @Test
    public void userSholdRegisterAccountSuccessfully(){

        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Smith");
        driver.findElement(By.name("LastName")).sendKeys("Hayes");
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']/option[4]")).click();
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']/option[6]")).click();
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']/option[80]")).click();
        driver.findElement(By.name("Email")).sendKeys("smith3@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("smith182");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("smith182");
        driver.findElement(By.xpath("//button[@name='register-button']")).click();

        String expectedText = "Your registration completed";
        String actualText = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals(expectedText,actualText);
        System.out.println("The Text is : " + actualText);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
