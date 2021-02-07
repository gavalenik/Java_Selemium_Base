package Base;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class Site_login {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void driverInit () {
        System.setProperty("webdriver.edge.driver", "./src/main/resources/msedgedriver"); //"webdriver.gecko.driver"
        driver = new EdgeDriver(); //FirefoxDriver()
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void login() {

        System.out.println("login_started");
        driver.get("https://xn----btbthcge4aikr4i.xn--p1ai/");
        driver.manage().window().maximize();

        {
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-button")));
        }
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/form/input[4]")).sendKeys("Virtuhai");
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/form/input[5]")).sendKeys("qwerty1234");
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/form/div[4]/input")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/ul/li[1]/a/span")).click();
        {
            WebElement element = driver.findElement(By.linkText("Выйти"));
            Assert.assertEquals(true, element.isDisplayed());
        }
        System.out.println("login_finished");
 /*   }

    public void basket() {
*/
        System.out.println("basket_started");
        driver.findElement(By.xpath("//div[@id=\'bx_cart_block1\']/div/a")).click();
        {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/p/font"));
            Assert.assertEquals(element.getText(), "Ваша корзина пуста");
        }
        System.out.println("basket_finished");
/*    }

    public void logout() {
*/
        System.out.println("logout_started");
        driver.findElement(By.xpath("//div[@id=\'header\']/div/div[2]/form/table/tbody/tr[2]/td/a")).click();
        driver.findElement(By.xpath("//ul[@id=\'horizontal-multilevel-menu\']/li/a/span")).click();
        {
            WebElement element = driver.findElement(By.xpath("//div[@id=\'header\']/div/div[2]/noindex[2]/a"));
            Assert.assertEquals(true, element.isDisplayed());
        }
        System.out.println("logout_finished");
    }

}