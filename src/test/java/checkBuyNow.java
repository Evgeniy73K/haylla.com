
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

public class checkBuyNow {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://dev.haylla.com/");
        WebElement product = driver.findElement(By.xpath("//a[@class=\"product-title\"]"));
        product.click();
        WebElement button = driver.findElement(By.xpath("//button[@id=\"cp_buy_now\"]"));
        button.click();
        WebElement buynow = driver.findElement(By.xpath("//button[@class=\"litecheckout__submit-btn \"]"));
        if (buynow.isDisplayed()) {

            System.out.println("Passed");

            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("/home/evgeny/Pictures/passed.jpg"));

            driver.quit();

        } else {
            System.out.println("Failed");
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("/home/evgeny/Pictures/failed.jpg"));
        }

    }



}