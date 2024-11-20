package testsuite;

import browserfactory.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.time.Duration;
    public class LoginTest extends BaseTest {
        /*
 . Write down the following test in the ‘LoginTest’ class
1. userShouldNavigateToLoginPageSuccessfully()
* click on the ‘Sign In’ link
* Verify the text ‘Welcome Back!’

2. verifyTheErrorMessage()
* click on the ‘Sign In’ link
* Enter the invalid username
* Enter the invalid password
* Click on the ‘Sign in’ button
* Verify the error message ‘Invalid email
or password.'
         */
String baseUrl = "https://courses.ultimateqa.com/";

@Before
public void setUp(){
            openBrowser(baseUrl);
        }

        @Test
public void userShouldNavigateToLoginPageSuccessfully() {
            driver.findElement(By.linkText("Sign In")).click();

            // Verify text 'Welcome Back
            String expectedText = "Welcome Back!";
            String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
            Assert.assertEquals("Welcome Back!", expectedText, actualText);

        }
@Test
        public void verifyTheErrorMessage(){
    driver.findElement(By.linkText("Sign In")).click();

    driver.findElement(By.id("user[email]")).sendKeys("ss@testing.com");
driver.findElement(By.id("user[password]")).sendKeys("ssss");
driver.findElement(By.xpath("//button[@type='submit']")).click();

//Verify the Error message
    String expectedText = "Invalid email or password.";
    String actualText = driver.findElement(By.xpath("//li[@class ='form-error__list-item']")).getText();
    Assert.assertEquals("Invalid email or password.",expectedText,actualText);

}

@After
public void close(){
    closeBrowser();
}

    }
