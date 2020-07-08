import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Automation3 {
    static WebDriver driver;
public  static void waituntilelementtobeclickalbelby(By by){
    WebDriverWait wait=new WebDriverWait(driver,20);
    wait.until(ExpectedConditions.elementToBeClickable(by));
}


    public static void sleep(int n){
        try {
            Thread.sleep(n*1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void selectFromDropDownindexvalue(By by,int indexvalue){
        Select select= new Select(driver.findElement(by));
        select.selectByIndex(indexvalue);

    }
    public static long timestamp(){
        return (System.currentTimeMillis());
    }
    public static String getTextfromElement(By by){
        return driver.findElement(by).getText();
    }
    public static void selectFromDropDownvisibletext(By by, String textvalue) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(textvalue);
    }
    public static void sendkeys(By by, String text) {
        driver.findElement(by).sendKeys(text);

    }
    @BeforeTest
    public static void setbrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\ChromeDriver\\83\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }
   @AfterTest
    public static void closeBrowser(){
       driver.close();
    }

     @Test

    public static void Ausershouldbeabletobregistersucessully() {
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         driver.findElement(By.xpath("//a[@class='ico-register']")).click();
         //sleep(3);
         driver.findElement(By.xpath("//input[@id='gender-female']")).click();
         //sleep(3);
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("P32355455232922rr1adasrthi");
         //sleep(3);
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Za2l444r1sd99csavadiya");
         //sleep(3);
        selectFromDropDownindexvalue(By.xpath("//select[@name='DateOfBirthDay']"),6);
         //sleep(3);
        selectFromDropDownvisibletext(By.xpath("//select[@name='DateOfBirthMonth']"),"September");
        selectFromDropDownvisibletext(By.xpath("//select[@name='DateOfBirthYear']"),"1996");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("pra22p7755prthi00122221111111zalavadiya"+timestamp()+"@gmail.com");
        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Uniquetesting");
      // driver.findElement(By.xpath("//input[@id='Newsletter")).isSelected();
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Uniquetesting");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("Uniquetesting");
        driver.findElement(By.xpath("//input[@id='register-button']")).click();
        String actual=getTextfromElement(By.xpath("//div[@class='result']"));
        String expected= "Your registration completed";
         Assert.assertEquals(actual,expected,"Test fail a");
         //System.out.println("Test Case Passed");
}
    @Test
    public static void Busershouldbeabletobemailtofriend() {

        //sleep(3);
        driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[1]/a[1]")).click();
        // sleep(3);
       // waituntilelementtobeclickalbelby(By.xpath("//ul[@class='sublist']//li[1]//a[1]"));
        driver.findElement(By.xpath("//ul[@class='sublist']//li[1]//a[1]")).click();
        //sleep(3);
        driver.findElement(By.xpath("//div[@class='item-grid']//div//div[1]//div[1]//a[1]")).click();
        //sleep(3);
        driver.findElement(By.xpath("//div[@class='overview-buttons']//div[3]")).click();
        //sleep(3);
        waituntilelementtobeclickalbelby(By.xpath("//input[@id='FriendEmail']"));
        driver.findElement(By.xpath("//input[@id='FriendEmail']")).sendKeys("Sheetl@gmail.com");
        //sleep(3);
        //  driver.findElement(By.xpath("//input[@id='YourEmailAddress']")).sendKeys("prarthizalavadiya@gmail.com");
        //sleep(3);
        driver.findElement(By.xpath("//textarea[@class='your-email']")).sendKeys("Prarth1111");
        // sleep(3);
        driver.findElement(By.xpath("//input[@class='button-1 send-email-a-friend-button']")).click();
}
    @Test
    public static void Ccomparingstringofselectedproducts(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //sleep(2);
        driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[1]/a[1]")).click();
       // sleep(3);
        //waituntilelementtobeclickalbelby(By.xpath("//ul[@class='sublist']//li[1]//a[1]"));
        driver.findElement(By.xpath("//ul[@class='sublist']//li[1]//a[1]")).click();
        //driver.findElement(By.xpath("//ul[@class='sublist']//li[1]//a[1]")).click();
        //sleep(3);
        driver.findElement(By.xpath("//div[@class='item-grid']/div[2]/div/div[2]/div[3]/div[2]/input[1]")).click();
        sleep(3);
        driver.findElement(By.xpath("//div[@class='item-grid']/div[3]/div/div[2]/div[3]/div[2]/input[1]")).click();
        sleep(3);
        driver.findElement(By.xpath("//span[@class='close']")).click();
        driver.findElement(By.xpath("//div[@class='header-links']/ul/li[4]")).click();
        String actualtext=getTextfromElement(By.xpath("//tbody/tr[1]/td[4]/a[1]"));
        String expectedtext="Digital Storm VANQUISH 3 Custom Performance PC";
        Assert.assertEquals(actualtext,expectedtext,"test fail b");
        String actualtext1=getTextfromElement(By.xpath("//tbody/tr[2]/td[4]/a[1]"));
        String ExpectedText1="Lenovo IdeaCentre 600 All-in-One PC";
        Assert.assertEquals(actualtext1,ExpectedText1,"test fail c");

    }
}
