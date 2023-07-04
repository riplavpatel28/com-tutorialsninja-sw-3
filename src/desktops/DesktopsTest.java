package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class DesktopsTest extends Utility {
    String menu;
    String actualText, expectedText;
    String baseurl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException{
        WebElement desktop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(desktop).click().build().perform();

        Thread.sleep(1000);
        //1.2 Click on “Show All Desktops"
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));


       // 1.3 Select Sort By position "Name: Z to A"
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Name (Z - A)");


       // 1.4 Verify the Product will arrange in Descending order.

    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException
    {
        clickOnElement(By.xpath("//span[normalize-space()='Currency']"));
        clickOnElement(By.xpath("//button[@name='GBP']"));
        //2.1 Mouse hover on Desktops Tab. and click
        WebElement desktop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(desktop).click().build().perform();

        Thread.sleep(1000);
        //2.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));

        //2.3 Select Sort By position "Name: A to Z"
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Name (A - Z)");

        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//div[@class='caption']//a[contains(text(),'HP LP3065')]"));

        //2.5 Verify the Text "HP LP3065"
        actualText=getTextFromElement(By.xpath("//h1[normalize-space()='HP LP3065']"));
        expectedText="HP LP3065";
        Assert.assertEquals("Not Match Any Text",expectedText,actualText);

        //2.6 Select Delivery Date "2022-11-30"
        WebElement dateBox = driver.findElement(By.xpath("//input[@id='input-option225']"));
        driver.findElement(By.xpath("//input[@id='input-option225']")).clear();

        //2.7 Fill date as mm/dd/yyyy as 09/25/2013

        dateBox.sendKeys("2022-11-30");

        System.out.println(getTextFromElement(By.xpath("//input[@id='input-option225']")));

        //2.8 Enter Qty "1” using Select class.

        //2.9 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.10 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        actualText = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        expectedText="Success: You have added HP LP3065 to your shopping cart!\n×";
        Assert.assertEquals("Message Not Matched",expectedText,actualText);

        Thread.sleep(1000);
        //clickOnElement(By.linkText("shopping cart"));
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //2.11 Verify the text "Shopping Cart"
        actualText=getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
        expectedText="Shopping Cart  (1.00kg)";
        Assert.assertEquals("Text Not Matched",expectedText,actualText);

        //2.12 Verify the Product name "HP LP3065"
        actualText=getTextFromElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        expectedText="HP LP3065";
        Assert.assertEquals("Text Not Matched",expectedText,actualText);

        //2.13 Verify the Delivery Date "2022-11-30"
        actualText=getTextFromElement(By.xpath("//small[normalize-space()='Delivery Date:2022-11-30']"));
        expectedText="Delivery Date:2022-11-30";
        Assert.assertEquals("Text Not Matched",expectedText,actualText);

        //2.14 Verify the Model "Product21"
        actualText=getTextFromElement(By.xpath("//td[normalize-space()='Product 21']"));
        expectedText="Product21";
        Assert.assertEquals("Model Not Matched",expectedText,actualText);

        //2.15 Verify the Todat "£74.73"
        actualText=getTextFromElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]"));
        expectedText="£74.73";
        Assert.assertEquals("Prise Not Matched",expectedText,actualText);
    }














    @After
    public void tearDown() {
        closeBrowser();
    }


}


