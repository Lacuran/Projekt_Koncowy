import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Projektwjunit {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.borland.com/InsuranceWebExtJS/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void register(){
        driver.findElement(By.xpath("//input[@id='login-form:signup']")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        WebElement imie = driver.findElement(By.id("signup:fname"));
        imie.sendKeys("Kornel");
        WebElement nazwisko = driver.findElement(By.id("signup:lname"));
        nazwisko.sendKeys("asuhfusfd");
        WebElement dataUrodzenia = driver.findElement(By.id("ext-gen4"));
        dataUrodzenia.click();
        driver.findElement(By.id("ext-gen16")).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

        driver.findElement(By.className("x-date-mp-prev")).click();
        driver.findElement(By.className("x-date-mp-prev")).click();
        driver.findElement(By.className("x-date-mp-prev")).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

        driver.findElement(By.linkText("1990")).click();
        driver.findElement(By.linkText("Apr")).click();
        driver.findElement(By.className("x-date-mp-ok")).click();
        driver.findElement(By.linkText("19")).click();
        driver.findElement(By.id("signup:email")).sendKeys("yatef@onzmail.com");//należy pamiętać o zmianie adresu mailowego
        driver.findElement(By.id("signup:street")).sendKeys("yatef3@onzmail.com");
        driver.findElement(By.id("signup:city")).sendKeys("Krakow");
        Select select = new Select(driver.findElement(By.id("signup:state")));//rozwiazanie dla comboboxa
        select.selectByValue("TX");
        driver.findElement(By.id("signup:zip")).sendKeys("30-303");
        driver.findElement(By.id("signup:password")).sendKeys("asdf");
        driver.findElement(By.xpath("//input[@id='signup:signup']")).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    }

    @Test
    public void logOut(){
        driver.findElement(By.xpath("//input[@id='login-form:email']")).sendKeys("yatef@onzmail.com");// należy pamiętać o zmianie adrezu mailowega taki jak przy rejestracji
        driver.findElement(By.xpath("//input[@id='login-form:password']")).sendKeys("asdf");
        driver.findElement(By.xpath("//input[@id='login-form:login']")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


        driver.findElement(By.id("logout-form:details")).click();
        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.xpath("//input[@id='logout-form:logout']")).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    }


    @After
    public void closeBrowser() {
        driver.quit();
    }
}
