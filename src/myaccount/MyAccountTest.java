package myaccount;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountTest extends Utility {

    String option;
    String actualText, expectedText;
    String baseurl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseurl);
        clickOnElement(By.xpath("//span[normalize-space()='Currency']"));
        clickOnElement(By.xpath("//button[@name='GBP']"));
    }

    public void selectMyAccountOptions(String option) {

        if (option == "Register") {
            WebElement select = driver.findElement(By.xpath("//a[@title='My Account']"));
            List<WebElement> options = select.findElements(By.xpath("//a[normalize-space()='Register']"));

            for (WebElement option1 : options) {

                if (option.equals(option1.getText())) {
                    option1.click();
                }
                //return;
            }

        }
        if (option == "Login") {
            WebElement select1 = driver.findElement(By.xpath("//a[@title='My Account']"));
            List<WebElement> options1 = select1.findElements(By.xpath("//a[normalize-space()='Login']"));

            for (WebElement option2 : options1) {

                if (option.equals(option2.getText())) {
                    option2.click();
                    //return;
                }

            }

        }
        if (option == "Logout") {
            WebElement select2 = driver.findElement(By.xpath("//span[normalize-space()='My Account']"));
            List<WebElement> option2 = select2.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));
            for (WebElement option3 : option2) {
                if (option.equals(option3.getText())) {
                    option3.click();
                    //return;
                }
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        // 1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Register”
        //option="//a[normalize-space()='Register']";
        option = "Register";
        selectMyAccountOptions(option);


        //1.3 Verify the text “Register Account”.
        actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Register Account']"));
        expectedText = "Register Account";
        Assert.assertEquals("Register Account Not Matched", expectedText, actualText);

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Login”
        //option="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']";
        option = "Login";
        selectMyAccountOptions(option);

        //2.3 Verify the text “Returning Customer”.
        actualText = getTextFromElement(By.xpath("//h2[normalize-space()='Returning Customer']"));
        expectedText = "Returning Customer";
        Assert.assertEquals("Returning Customer Text Not Matched", expectedText, actualText);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));


        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Register”
        option = "Register";
        selectMyAccountOptions(option);

        //3.3 Enter First Name
        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Rupal");

        //3.4 Enter Last Name
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Shah");

        //3.5 Enter Email
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("Rupal.shah1111@yahoo.com");

        //3.6 Enter Telephone
        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("0123456789");


        //3.7 Enter Password
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("abc@0000");

        //3.8 Enter Password Confirm
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("abc@0000");

        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']"));

        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));

        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        //3.12 Verify the message “Your Account Has Been Created!”
        actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
        expectedText = "Your Account Has Been Created!";
        Assert.assertEquals("Account Created Message Not Matched", expectedText, actualText);

        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

        //3.14 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        selectMyAccountOptions("Logout");


        //3.16 Click on Continue button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Login”
        selectMyAccountOptions("Login");

        //4.3 Enter Email address
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("Rupal.shah1111@yahoo.com");

        //4.5 Enter Password
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("abc@0000");

        //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));

        //4.7 Verify text “My Account”
        actualText = getTextFromElement(By.xpath("//h2[normalize-space()='My Account']"));
        expectedText = "My Account";
        Assert.assertEquals("My Account Text Not Matched", expectedText, actualText);

        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        selectMyAccountOptions("Logout");

        //4.10 Verify the text “Account Logout”
        actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        expectedText = "Account Logout";
        Assert.assertEquals("Account Logout Message Not Matched", expectedText, actualText);

        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}



