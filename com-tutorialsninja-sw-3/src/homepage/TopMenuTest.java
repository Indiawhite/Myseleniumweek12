package homepage;

import browsertesting.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TopMenuTest  extends BaseTest {


    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setupTest() {openBrowser(baseUrl);
    }

    @Test
    public void selectMenu() {
        //1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
        Actions actions = new Actions(driver);
        /*WebElement Desktops =driver.findElement(By.xpath("//a[text()='Desktops']"));
        WebElement DeskTopTab = driver.findElement(By.xpath("//a[text()='Show AllDesktops']"));
        actions.moveToElement(Desktops).moveToElement(DeskTopTab).click().build().perform();
        String actualMsg=driver.findElement(By.xpath("//a[text()='Desktops']")).getText();
        String expectedMsg = "Desktops";
        Assert.assertTrue(expectedMsg.equalsIgnoreCase(actualMsg));*/

        //2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()

        /*WebElement LaptopsAndNotebooks =driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        WebElement LaptopNotebookTab = driver.findElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']"));
        actions.moveToElement(LaptopsAndNotebooks).moveToElement(LaptopNotebookTab).click().build().perform();
        String actualResult=driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']")).getText();
        String expectedResult= "Laptops & Notebooks";
        Assert.assertTrue(expectedResult.equalsIgnoreCase(actualResult));*/

       //3.verifyUserShouldNavigateToComponentsPageSuccessfully()
        WebElement Components =driver.findElement(By.xpath("//a[text()='Components']"));
        WebElement ComponentsTab = driver.findElement(By.xpath("//a[text()='Show AllComponents']"));
        actions.moveToElement(Components).moveToElement(ComponentsTab).click().build().perform();
        String actualResult=driver.findElement(By.xpath("//a[text()='Components']")).getText();
        String expectedResult= "Components";
        Assert.assertTrue(expectedResult.equalsIgnoreCase(actualResult));


    }

    }