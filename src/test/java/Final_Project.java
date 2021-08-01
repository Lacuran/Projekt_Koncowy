import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class Final_Project {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Kornel\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://opencart.abstracta.us/");


        WebElement samsung = driver.findElement(By.linkText("iPhone"));
        samsung.click();
        WebElement review = driver.findElement(By.linkText("Reviews (0)"));
        review.click();
        WebElement name = driver.findElement(By.id("input-name"));
        name.sendKeys("Kornel Wrzesien");
        WebElement myReview = driver.findElement(By.id("input-review"));
            myReview.sendKeys("Meh słaby.\n");
            myReview.sendKeys("Nigdy więcej iPhonu. \n");
        WebElement radio5 = driver.findElement(By.xpath("//input[@value='5']"));
        WebElement radio4 = driver.findElement(By.xpath("//input[@value='4']"));
            radio5.click();
            radio4.click();


        WebElement continues = driver.findElement(By.id("button-review"));
            continues.click();
        WebElement newCathegory = driver.findElement(By.linkText("Laptops & Notebooks"));
        newCathegory.click();
        WebElement otherCathegory = driver.findElement(By.linkText("Components"));
        otherCathegory.click();
        WebElement monitors = driver.findElement(By.linkText("Monitors (2)"));
        monitors.click();
        driver.get("http://opencart.abstracta.us/index.php?route=product/product&path=25_28&product_id=42");

        WebElement mediumRadio = driver.findElement(By.name("option[218]"));
        mediumRadio.click();
        WebElement checkbox = driver.findElement(By.name("option[223][]"));
        checkbox.click();
        //How to find a dropdown the tradtional way
        // WebElement select = driver.findElement(By.name("option[217]"));
        // select.click();
        // Using Select
        Select dropdown = new Select(driver.findElement(By.name("option[217]")));
        dropdown.selectByIndex(1);
        //Text Area
        WebElement textArea = driver.findElement(By.id("input-option209"));
        textArea.sendKeys("Some text");


        try {
        //Create a file
            File text = new File("D:\\Tester SDA\\Projekt Końcowy\\test.txt");
            String path = text.getAbsolutePath();
            System.out.println("The file path: " + path);
            Thread.sleep(5000);
        //Upload file
            WebElement upload = driver.findElement(By.id("button-upload222"));
            upload.sendKeys("D:\\Tester SDA\\Projekt Końcowy\\test.txt");
            Thread.sleep(10000);

        } catch (Exception e) {
            System.out.println("Selenium does not support file upload");

        } finally {
            WebElement camera = driver.findElement(By.linkText("Cameras"));
            camera.click();
            WebElement tablet = driver.findElement(By.linkText("Tablets"));
            tablet.click();
            WebElement thisTablet = driver.findElement(By.linkText("Samsung Galaxy Tab 10.1"));
            thisTablet.click();
            WebElement buyTablet = driver.findElement(By.id("button-cart"));
            buyTablet.click();
            WebElement cart = driver.findElement(By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']"));
            cart.click();
            WebElement search = driver.findElement(By.xpath("//input[@class='form-control input-lg']"));
            search.sendKeys("a");
            WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
            searchButton.click();
        }
    }
}
