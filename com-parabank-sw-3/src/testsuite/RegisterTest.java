package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    //1.verifyThatSigningUpPageDisplay

    String baseUrl ="https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setupTest() {
        openBrowser(baseUrl);
    }

    @Test
    public void registerPage() {
        WebElement Register = driver.findElement(By.xpath("//a[text()='Register']"));
        Register.click();
        String actualSingingUpText = driver.findElement(By.xpath("//h1[text()='Signing up is easy!']")).getText();
        String expectingSingingUpText = "Signing up is easy!";
        Assert.assertEquals("Validating welcome text",expectingSingingUpText,actualSingingUpText);

    }
    @Test
    public void register(){
        driver.findElement(By.xpath("//a[text()='Register']")).click();
        driver.findElement(By.id("customer.firstName")).sendKeys("Megh");
        driver.findElement(By.id("customer.lastName")).sendKeys("patel");
        driver.findElement(By.id("customer.address.street")).sendKeys("16 Roman Village");
        driver.findElement(By.id("customer.address.city")).sendKeys("London");
        driver.findElement(By.id("customer.address.state")).sendKeys("U.k");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("HP2 9AA");
       driver.findElement(By.id("customer.phoneNumber")).sendKeys("07412345678");
       driver.findElement(By.id("customer.ssn")).sendKeys("25");
       driver.findElement(By.id("customer.username")).sendKeys("Dpatel");
       driver.findElement(By.id("customer.password")).sendKeys("patel1234");
       driver.findElement(By.id("repeatedPassword")).sendKeys("patel1234");
       driver.findElement(By.xpath("//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input")).click();
       String ActualMsg = driver.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']")).getText();
       String ExpectedMsg = "Your account was created successfully. You are now logged in.";
       Assert.assertEquals("Your account was created successfully. You are now logged in.",ExpectedMsg,ActualMsg);

    }
}
