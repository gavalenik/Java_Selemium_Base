package Base;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

public class Site_login {

    @Test
    public void login() {

        System.out.println("Lets do IT");
        //System.setProperty("webdriver.gecko.driver", "/media/gavalenik/ssd_data/Projects/geckodriver");
        //WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.edge.driver", "/media/gavalenik/ssd_data/Projects/msedgedriver");
        WebDriver driver = new EdgeDriver();

        driver.get("https://xn----btbthcge4aikr4i.xn--p1ai/");
        {
            List<WebElement> elements = driver.findElements(By.id("login-button"));
            assert(elements.size() > 0);
        }
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/form/input[4]")).sendKeys("Virtuhai");
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/form/input[5]")).sendKeys("qwerty1234");
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/form/div[4]/input")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/ul/li[1]/a/span")).click();
        {
            List<WebElement> elements = driver.findElements(By.linkText("Выйти"));
            assert(elements.size() > 0);
        }
        driver.quit();
    }
/*
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
*/
}