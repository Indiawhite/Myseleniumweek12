package laptopsandnotebooks;

import browsertesting.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LaptopsAndNotebooksTest extends BaseTest {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setupTest() {openBrowser(baseUrl);
    }
    @Test
    public void selectMenu(){
   //Test name verifyProductsPriceDisplayHighToLowSuccessfully()
        Actions actions = new Actions(driver);
        WebElement Laptop = driver.findElement(By.xpath("//*[text()='Show AllLaptops & Notebooks'])"));
        WebElement showLaptop=driver.findElement(By.xpath("//*[text()='Laptops & Notebooks']"));
        actions.moveToElement(Laptop).moveToElement(showLaptop).click().build().perform();
        WebElement Default= driver.findElement(By.id("input-sort"));
        Select select = new Select(Default);
        WebElement shortByPrice = driver.findElement(By.xpath("//*[text()='Price (High > Low)']"));
    }
    @Test
    public void UserPlaceOrder() {
        Actions actions = new Actions(driver);
        WebElement Laptop = driver.findElement(By.xpath("//*[text()='Show AllLaptops & Notebooks']"));
        WebElement showLaptop = driver.findElement(By.xpath("//*[text()='Laptops & Notebooks']"));
        actions.moveToElement(Laptop).moveToElement(showLaptop).click().build().perform();
        WebElement Default = driver.findElement(By.xpath("//*[@id='input-sort']"));
        Select select = new Select(Default);
        select.selectByVisibleText("Price (High > Low)");

        driver.findElement(By.xpath("//*[text()='MacBook']")).click();
        String ActualMsg1 = driver.findElement(By.xpath("//h1[text()='MacBook']")).getText();
        String expectedMsg1 = "MacBook";
        Assert.assertEquals("Verify Msg", ActualMsg1,expectedMsg1);

        driver.findElement(By.id("button-cart")).click();

        String ActualMsg2 = driver.findElement(By.xpath("//*[@id='product-product']/div[1]")).getText();
        String expectedMsg2 = "Success: You have added MacBook to your shopping cart!";
        Assert.assertEquals("Verify Msg", ActualMsg2,expectedMsg2);

        driver.findElement(By.xpath("//*[text()='shopping cart']")).click();
        String actualMsg3 = String.valueOf(driver.findElement(By.xpath("//*[@id='content']/h1")));
        String expectedMsg3 = "Shopping Cart  (0.00kg)";
        Assert.assertEquals("verify Msg",actualMsg3,expectedMsg3);

        String actualMsg4 = String.valueOf(driver.findElement(By.xpath("//*[text()='MacBook'")));
        String expectedMsg4 = "MacBook";
        Assert.assertEquals("verify Msg",actualMsg4,expectedMsg4);

        WebElement quantity = driver.findElement(By.name("quantity[144578]"));
        quantity.clear();
        quantity.sendKeys("2");
         driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[4]/div/span/button[1]")).click();









    }
    }

