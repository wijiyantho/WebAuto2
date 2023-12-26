package auto.assign9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValueFind {
    WebDriver driver;
    @Test
    public void getValue(){
        // open web url
        WebDriverManager.edgedriver();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // closed advertisement
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body[1]/webengagedata[1]/div[1]/div[1]")));
//        driver.findElement(By.xpath("/html/body[1]/webengagedata[1]/div[1]/div[1]")).click();

        // click search button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Search']")));
        driver.findElement(By.xpath("//a[normalize-space()='Search']")).click();

        // new page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OKAY, GOT IT!']")));
        driver.findElement(By.xpath("//button[normalize-space()='OKAY, GOT IT!']")).click();

        // find flight route and price
        String rute = driver.findElement(By.xpath("/html/body[1]/div[1]/div/div[2]/div[2]/div[1]/div[2]/p[1]/span")).getText();
        String harga = driver.findElement(By.xpath("/html/body[1]/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div/div[1]/div")).getText();
        System.out.println("---------------Harga Tiket Rute Berikut--------------");
        System.out.println("Rute "+rute+", Harga "+harga);
        System.out.println("-----------------------------------------------------");

    }
}
