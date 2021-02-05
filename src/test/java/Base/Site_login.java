package Base;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

public class Site_login {

    WebDriver driver = new FirefoxDriver();
    /*    private Map<String, Object> vars;
    JavascriptExecutor js;


    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
*/
    @Test
    public void login() {
        driver.get("https://xn----btbthcge4aikr4i.xn--p1ai/");
        driver.manage().window().setSize(new Dimension(1244, 1413));
        {
            List<WebElement> elements = driver.findElements(By.id("login-button"));
            assert(elements.size() > 0);
        }
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.name("USER_LOGIN")).click();
        driver.findElement(By.name("USER_LOGIN")).click();
        driver.findElement(By.name("USER_PASSWORD")).click();
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("qwerty1234");
        driver.findElement(By.name("Login")).click();
        driver.findElement(By.cssSelector(".home_link")).click();
        {
            List<WebElement> elements = driver.findElements(By.linkText("Выйти"));
            assert(elements.size() > 0);
        }
    }
}