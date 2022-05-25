package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import  org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Testsuit_calss {

    protected static WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/test/java/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://demo.nopcommerce.com/");

    }
    @Test
    public void UserShouldAbleToLoginSuccessfully(){


        // click on register button
        driver.findElement(By.className("ico-register")).click();
        //ClicableElement(By.className("Ico register"));

        // select male and female

        ClicableElement(By.xpath("//input [@id=\"gender-male\"]"));

        //driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Autoamtion");
        findelemnt(By.xpath("//input[@name='FirstName']"),"Autommation");

        //driver.findElement(By.id("LastName")).sendKeys("LastName");
        findelemnt(By.id("LastName"),"Lastname");
        //String= "your reagstration is complect"

        //Added date of birth
//
        Select birthday = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]")));
        birthday.selectByValue("31");
        Select birthmonth = new Select((driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]"))));
        birthmonth.selectByVisibleText("May");
        Select brithyear = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthYear\"]")));
        brithyear.selectByVisibleText("1985");

        //driver.findElement(By.id("Email")).sendKeys("abcd" + randomdate() + "@gmail.com");
        findelemnt(By.id("Email"),"abcd" + randomdate() + "@gmail.com");

        //driver.findElement(By.id("Password")).sendKeys("abc123");
        findelemnt(By.id("Password"),"abc123");

        //driver.findElement(By.id("ConfirmPassword")).sendKeys("abc123");
        findelemnt(By.id("ConfirmPassword"),"abc123");

        //driver.findElement(By.id("")).click();
        ClicableElement(By.id("register-button"));

        String expectedMessage = "Your registration completed";

        String actualMessage = driver.findElement(By.className("result")).getText();

        Assert.assertEquals(actualMessage,expectedMessage,"regstration not complected");

        driver.findElement(By.xpath("//div/a[@class=\"button-1 register-continue-button\"]")).click();

    }
    @Test
    public void UserShouldAbleToAddProductSuccessfully(){
        //Re-using the before method to open the browser and open the web page

        // Click on the top menu panel and select computers
        ClicableElement(By.xpath("//a[@href=\"/computers\"]"));
        //selecting the required product from the sublist category
        ClicableElement(By.xpath("//ul[@class=\"sublist\"]/li[1]/a"));
        //Selecting the required product form the listed product range
        ClicableElement(By.xpath("//div [@class=\"product-item\"]/div[2]/h2/a[@href=\"/build-your-own-computer\"]"));
        //using the method to select the drop-down menu
        Select processor =new Select(driver.findElement(By.xpath("//dl//dd[1]//select[@id=\"product_attribute_1\"]")));
        processor.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");
        //Using the Method to select the drop-down menu
        Select ram = new Select(driver.findElement(By.xpath("//dl//dd[2]//select['product_attribute_2']")));
        ram.selectByValue("3");
        //Select HDD ,According the requirement
        ClicableElement(By.xpath("//input [@id=\"product_attribute_3_6\"]"));
        //Select OS ,According the requirement
        ClicableElement(By.xpath("//input [@id=\"product_attribute_4_9\"]"));
        //select Software,According the requirement
        ClicableElement(By.xpath("//input [@id=\"product_attribute_5_11\"]"));
        // Select Software requirement.
        ClicableElement(By.xpath("//input [@id=\"product_attribute_5_12\"]"));
        //click on add to cart
        ClicableElement(By.xpath("//button[@id=\"add-to-cart-button-1\"]"));
        //Click on cart button on top right corner
        ClicableElement(By.className("cart-label"));

        //Using the methods to verify the product are in the shopping cart successfully.
        String expectedMessage ="Shopping cart";
        String actualMessage= driver.findElement(By.xpath("//div /h1")).getText();
        Assert.assertEquals(expectedMessage,actualMessage,"Products not added to shopping cart");
        //Assert.assertEquals(driver.findElement(By.className("product-name")).getText(),"Build your own computer");


    }
    @Test
    public void RegistredUserShouldAbletoSendProductrecomendationEmailSuccessfully(){

        // click on register button
        driver.findElement(By.className("ico-register")).click();

        // select male and female

        ClicableElement(By.xpath("//input [@id=\"gender-male\"]"));

        //driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Autoamtion");
        findelemnt(By.xpath("//input[@name='FirstName']"),"Autommation");

        //driver.findElement(By.id("LastName")).sendKeys("LastName");
        findelemnt(By.id("LastName"),"Lastname");

        //Added date of birth
        Select birthday = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]")));
        birthday.selectByValue("31");
        Select birthmonth = new Select((driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]"))));
        birthmonth.selectByVisibleText("May");
        Select brithyear = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthYear\"]")));
        brithyear.selectByVisibleText("1985");

        // Using the Email Id for Registration
        findelemnt(By.id("Email"),"abcd" + randomdate() + "@gmail.com");
        // Sending the Password
        findelemnt(By.id("Password"),"abc123");

        //Confirm the password
        findelemnt(By.id("ConfirmPassword"),"abc123");

        //driver.findElement(By.id("")).click();
        // Click on Registration Button
        ClicableElement(By.id("register-button"));

        //Verifying the Registration is successful

        String expectedMessage = "Your registration completed";
        String actualMessage = driver.findElement(By.className("result")).getText();
        Assert.assertEquals(actualMessage,expectedMessage,"regstration not complected");

        //After registration Clicking in Continue Button

        driver.findElement(By.xpath("//div/a[@class=\"button-1 register-continue-button\"]")).click();

        //Select the product to recommend to friend
        ClicableElement(By.xpath("//div [@class=\"product-item\"]/div[2]/h2/a[@href=\"/build-your-own-computer\"]"));
        ClicableElement(By.className("email-a-friend"));
        // Add your Friend email ID
        findelemnt(By.xpath("//div/input[@class=\"friend-email\"]"),"friendemail"+randomdate()+"@gmail.com");
        //Passing the massage to the Recommended friend
        findelemnt(By.xpath("//div[@class=\"inputs\"]/textarea[@id=\"PersonalMessage\"]"),"This product is recommended");
        //Click on send Email button
        ClicableElement(By.xpath("//div[@class=\"buttons\"]//button[@name=\"send-email\"]"));

        //Verifying the message has been sent to friend
        String expectedmassage1 = "Your message has been sent.";
        String actualMessage1 = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        Assert.assertEquals(actualMessage1,expectedmassage1,"Your message has not been sent");

        //Verification is Successful



    }
    @Test
    public void UserShouldAbleToSelectTheCurency(){

        //Using the Before method to open the Webpage


        // Selecting the US Dollar currency
        Select curencyUsDollar = new Select(driver.findElement((By.xpath("//div[@class=\"currency-selector\"]/select"))));
        curencyUsDollar.selectByValue(("https://demo.nopcommerce.com/changecurrency/1?returnUrl=%2F"));

        // Verifying the US Dollar Currency

        String actualCurency1 = driver.findElement(By.xpath("//div[@class=\"prices\"]/span")).getText();
        Assert.assertTrue(actualCurency1.contains("$"));

        // Select the EURO currency
        Select curencyEuro = new Select(driver.findElement(By.xpath("//div[@class=\"currency-selector\"]/select")));
        curencyEuro.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");

        // Verifying the EURO Currency

        String actualCurency2 = (driver.findElement(By.xpath("//div[@class=\"prices\"]/span[contains(text(),\"€\")]"))).getText();
        Assert.assertTrue(actualCurency2.contains("€"));

        //Using the After Method to Close the Webpage------END_______

    }
    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }




    public static String randomdate()
    {
        Date date=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyHHmmss");
        return formatter.format(date);
    }

    public static void findelemnt(By by,String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    public static void ClicableElement(By by){
        driver.findElement(by).click();
    }

    public static void driverWaitelementToBeClickable(int time,By by)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static void driverwaitUrlcontains(int time,String Url)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlContains( ""));
    }
    public static void driverWaitelementToBeSelected(int time,By by )
    {
        WebDriverWait wiat = new WebDriverWait(driver,Duration.ofSeconds(time));
        wiat.until(ExpectedConditions.elementToBeSelected(by));
    }
    public static void driverwaitnumberOfElementsToBeMoreThan(int time ,By by,int number)
    {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,number ));
    }
    public static void diverWaitUrl(int time ,String url)
    {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlToBe(""));
    }



}
