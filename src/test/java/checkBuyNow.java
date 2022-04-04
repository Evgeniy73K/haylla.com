
import org.junit.Test;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
public class checkBuyNow extends Settings {
    @Test
    public void test1() {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://dev.haylla.com/");

        WebElement product = driver.findElement(By.xpath("//span[@class=\"ty-price-num\"]"));
        product.click();
        WebElement button = driver.findElement(By.xpath("//button[@id=\"cp_buy_now\"]"));
        button.click();
        WebElement checkout = driver.findElement(By.xpath("//button[@class=\"litecheckout__submit-btn \"]"));
        if (checkout.isDisplayed()) {

            System.out.println("Passed");

            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File("/home/evgeny/Pictures/passed.jpg"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        } else {
            System.out.println("Failed");
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File("/home/evgeny/Pictures/failed.jpg"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        driver.quit();

    }

}