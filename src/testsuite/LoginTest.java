package testsuite;

import browsefactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        String expectedText = "Welcome, Please Sign In!";

        WebElement actualTextElement = driver.findElement(By.xpath("//h1"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        driver.findElement(By.id("Email")).sendKeys("john123@gmail.com");
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("john123");
        driver.findElement(By.xpath("//button[@class=\"button-1 login-button\"]")).click();

        String expectedText = "Log out";
        WebElement actualTextElement = driver.findElement(By.linkText("Log out"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText,actualText);
        System.out.println(actualText);
    }

    @Test
    public void verifyTheErrorMessage(){

        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("john321@gmail.com");
        driver.findElement(By.name("Password")).sendKeys("john321");
        driver.findElement(By.xpath("//button[@class=\"button-1 login-button\"]")).click();

        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found1";
        // Find the errorMessage element and get the text
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        Assert.assertEquals("Error message not displayed",expectedErrorMessage, actualErrorMessage);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }


}
