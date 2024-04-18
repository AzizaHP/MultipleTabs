package stepDefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class MultiTabs {
    WebDriver driver = null;

    @Given("User open Tokopedia")
    public void open_first_ecommerce() {
        driver = new ChromeDriver();
        driver.get("https://www.tokopedia.com");
    }

    @When("User searchh \"iPhone 15 Pro\"")
    public void search_tokopedia() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"header-main-wrapper\"]/div[2]/div[2]/div/div/div/div/input"));
        element.sendKeys("iPhone 15 Pro");
        element.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }

    @And("User move new tab open ebay")
    public void move_new_tab() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://www.ebay.com");
    }

    @And("User search \"iPhone 15 Pro\"")
    public void search_ebay() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
        element.sendKeys("iPhone 15 Pro");
        element.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }
}
