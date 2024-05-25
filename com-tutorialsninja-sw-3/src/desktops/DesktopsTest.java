package desktops;

import browsertesting.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DesktopsTest extends BaseTest {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setupTest() {
        openBrowser(baseUrl);
    }
    @Test
    public void selectMenu(){
        //1.verifyProductArrangeInAlphaBaticalOrder()

        Actions actions = new Actions(driver);
        WebElement Desktops =driver.findElement(By.xpath("//a[text()='Desktops']"));
        WebElement DeskTopTab = driver.findElement(By.xpath("//a[text()='Show AllDesktops']"));
        actions.moveToElement(Desktops).moveToElement(DeskTopTab).click().build().perform();
        WebElement Default = driver.findElement(By.id("input-sort"));
        Select select = new Select(Default);
        select.selectByVisibleText("Name (Z - A)");
    }
    @Test
    public void ShoppingCart(){
        //Test name verifyProductAddedToShoppingCartSuccessFully()
        Actions actions = new Actions(driver);
        WebElement Desktops =driver.findElement(By.xpath("//a[text()='Desktops']"));
        WebElement DeskTopTab = driver.findElement(By.xpath("//a[text()='Show AllDesktops']"));
        actions.moveToElement(Desktops).moveToElement(DeskTopTab).click().build().perform();
        WebElement Default = driver.findElement(By.id("input-sort"));
        Select select = new Select(Default);
        select.selectByVisibleText("Name (A - Z)");
        driver.findElement(By.linkText("HP LP3065")).click();
        WebElement productName = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/h1"));

        if (productName.getText().equals("HP LP3065")){
            System.out.println("Product Name Verify successful ");
        }else{
            System.out.println("Product Name Verify fail");
        }

       WebElement deliveryDate = driver.findElement(By.name("option[225]"));
        deliveryDate.clear();
        deliveryDate.sendKeys("2022-11-30");

        //Select quantity = new Select(driver.findElement(By.name("quantity")));
        //quantity.selectByVisibleText("1");
        WebElement quantity = driver.findElement(By.name("quantity"));
        quantity.clear();quantity.sendKeys("1");
        driver.findElement(By.id("button-cart")).click();
        /*String actualSuccessMsg = String.valueOf(driver.findElement(By.xpath("//*[@id='product-product']/div[1]")));
        String expectedMsg = "Success: You have added HP LP3065 to your shopping cart!\n" + "x";
        Assert.assertEquals("verify Msg",actualSuccessMsg,expectedMsg)*/;

        driver.findElement(By.xpath("//*[text()='shopping cart']")).click();
        String actualMsg = String.valueOf(driver.findElement(By.xpath("//*[@id='content']/h1")));
        String expectedMsg = "Shopping Cart  (1.00kg)";
        Assert.assertEquals("verify Msg",actualMsg,expectedMsg);


       String ActualMsg1 = driver.findElement(By.linkText("HP LP3065")).getText();
       String expectedMsg1 = "HP LP3065";
       Assert.assertEquals("Verify Msg", ActualMsg1,expectedMsg1);

       String actualMsg1 = driver.findElement(By.xpath("//*[text()='Delivery Date:2011-04-22']")).getText();
       String ExpectedMsg1 = "Delivery Date:2011-04-22";
       Assert.assertEquals("verify Msg",actualMsg1,ExpectedMsg1);

       String actualMsg2 = driver.findElement(By.xpath("//*[text()='Product 21']")).getText();
       String expectedMsg2 = "Product 21";
        Assert.assertEquals("verify Msg",actualMsg2,expectedMsg2);

        String actualMsg3 = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[6]")).getText();
        String expected3= "$122.00";
        Assert.assertEquals("verify Msg", actualMsg3,expected3);



















    }


}
