package testsuite;

import browserfactory.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl ="https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setupTest() {
        openBrowser(baseUrl);
    }

   @Test
    public void login() {
       //1.userShouldLoginSuccessfullyWithValidCredentials
       driver.findElement(By.name("username")).sendKeys("Dpatel");
       driver.findElement(By.name("password")).sendKeys("patel1234");
       driver.findElement(By.xpath("//*[@id='loginPanel']/form/div[3]/input")).click();
       String ActualMsg = driver.findElement(By.xpath("//*[text()='Accounts Overview']")).getText();
       String ExpectedMsg = "Accounts Overview";
       Assert.assertEquals("Accounts Overview", ActualMsg, ExpectedMsg);

   } @Test
      public void ErrorLogin(){
        driver.findElement(By.name("username")).sendKeys("Dpate");
        driver.findElement(By.name("password")).sendKeys("patel123");
        driver.findElement(By.xpath("//*[@id='loginPanel']/form/div[3]/input")).click();
        String ActualMsg = driver.findElement(By.xpath("//*[text()='The username and password could not be verified.']")).getText();
        String ExpectedMsg = "The username and password could not be verified.";
        Assert.assertEquals("The username and password could not be verified.", ActualMsg, ExpectedMsg);



    }


   }


