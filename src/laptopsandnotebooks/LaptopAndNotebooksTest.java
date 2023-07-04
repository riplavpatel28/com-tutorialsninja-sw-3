package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class LaptopAndNotebooksTest extends Utility {
    String menu;
    String actualText,expectedText;
    String baseurl = "https://tutorialsninja.com/demo/index.php";
    @Before
    public void setUp()
    {
        openBrowser(baseurl);
        clickOnElement(By.xpath("//span[normalize-space()='Currency']"));
        clickOnElement(By.xpath("//button[@name='GBP']"));
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully()
    {

        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        WebElement laptop = driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(laptop).click().build().perform();

        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));

        //1.3 Select Sort By "Price (High > Low)"
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select select=new Select(dropdown);
        select.selectByVisibleText("Price (High > Low)");

        //1.4 Verify the Product price will arrange in High to Low order.

    }
    @Test
    public void  verifyThatUserPlaceOrderSuccessfully()
    {


        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        WebElement laptop = driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(laptop).click().build().perform();

        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));


        //2.3 Select Sort By "Price (High > Low)"
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select select=new Select(dropdown);
        select.selectByVisibleText("Price (High > Low)");

        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));

        //2.5 Verify the text “MacBook”
        actualText=getTextFromElement(By.xpath("//h1[normalize-space()='MacBook']"));
        expectedText="MacBook";
        Assert.assertEquals("MackBook Word Not Matched",expectedText,actualText);

        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        actualText=getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        expectedText="Success: You have added MacBook to your shopping cart!\n×";
        Assert.assertEquals("Success Message Not Matched",expectedText,actualText);

        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //2.9 Verify the text "Shopping Cart"
        actualText=getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
        expectedText="Shopping Cart  (0.00kg)";
        Assert.assertEquals("Shopping Cart Message Not MAtched",expectedText,actualText);

        //2.10 Verify the Product name "MacBook"
        actualText=getTextFromElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        expectedText="MacBook";
        Assert.assertEquals("Product Name Not Matched",expectedText,actualText);

        // 2.11 Change Quantity "2"
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).clear();
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).sendKeys("2");


        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        actualText=getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        expectedText="Success: You have modified your shopping cart!\n×";
        Assert.assertEquals("Success Message Not Matched",expectedText,actualText);

        //2.14 Verify the Total £737.45
        actualText=getTextFromElement(By.xpath("//tbody//tr//td[6]"));
        expectedText="£737.45";
        Assert.assertEquals("Total Prise Not Matched",expectedText,actualText);

        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

        //2.16 Verify the text “Checkout”
        actualText=getTextFromElement(By.xpath("//h1[normalize-space()='Checkout']"));
        expectedText="Checkout";
        Assert.assertEquals("Checkout Text Not Matched",expectedText,actualText);

        //2.17 Verify the Text “New Customer”
        clickOnElement(By.xpath("//a[@class='accordion-toggle']"));
        actualText=getTextFromElement(By.xpath("//h2[normalize-space()='New Customer']"));
        expectedText="New Customer";
        Assert.assertEquals("New  Customer Text Not Matched",expectedText,actualText);

        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));

        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));

        //2.20 Fill the mandatory fields
        driver.findElement(By.xpath("//input[@id='input-payment-firstname']")).sendKeys("Rupal");
        driver.findElement(By.xpath("//input[@id='input-payment-lastname']")).sendKeys("Shah");
        driver.findElement(By.xpath("//input[@id='input-payment-email']")).sendKeys("Rupal.shah1111@yahoo.com");
        driver.findElement(By.xpath("//input[@id='input-payment-telephone']")).sendKeys("0123456789");
        driver.findElement(By.xpath("//input[@id='input-payment-address-1']")).sendKeys("26, anaand  road");
        driver.findElement(By.xpath("//input[@id='input-payment-city']")).sendKeys("Anand");
        driver.findElement(By.xpath("//input[@id='input-payment-postcode']")).sendKeys("388300");

        WebElement dropdown2 = driver.findElement(By.xpath("//select[@id='input-payment-country']"));
        Select select3 = new Select(dropdown2);
        select3.selectByVisibleText("United Kingdom");

        WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='input-payment-zone']"));
        Select select2 = new Select(dropdown1);
        select2.selectByVisibleText("Aberdeen");


        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));

        //2.22 Add Comments About your order into text area
        driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Please Deliver As Early As Possible");

        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));

        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

        //2.25 Verify the message “Warning: Payment method required!”
        actualText=getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        expectedText="Warning: Payment method required!\n×";



    }


    @After
    public void tearDown()
    {
        closeBrowser();
    }
}


