package stepDefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

import javax.swing.text.html.parser.Element;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiTabs {
    WebDriver driver = null;

    @Given("User open Tokopedia")
    public void open_first_ecommerce() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.tokopedia.com");
    }

    @When("User searchh \"iPhone 15 Pro\"")
    public void search_tokopedia() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"header-main-wrapper\"]/div[2]/div[2]/div/div/div/div/input"));
        element.sendKeys("iPhone 15 Pro");
        element.sendKeys(Keys.ENTER);

        //validate the result is mentioned product
        System.out.println("--------------------Tokopedia------------------------");
        String search = "iPhone 15 Pro";
        if (driver.getPageSource().contains(search)){
            System.out.println("Search result found: " + search);
            System.out.println("Title and name of first website: " + driver.getTitle());
            System.out.println("Name of the product: " + search);
        }
        Thread.sleep(5000);
    }

    @And("User sort ascending the price in tokopedia")
    public void sort_ascending_price_tokopedia() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[2]/div/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[5]/div/div/ul/li[5]")).click();
        Thread.sleep(5000);
    }

    @And("Display the output from tokopedia in terminal")
    public void display_output_from_tokopedia() {
        List<WebElement> nameElements_tokopedia = driver.findElements(By.cssSelector("[class=\"prd_link-product-name css-3um8ox\"]"));
        List<WebElement> priceElements_tokopedia = driver.findElements(By.cssSelector("[class=\"prd_link-product-price css-h66vau\"]"));
        List<WebElement> linkElements_tokopedia = driver.findElements(By.cssSelector("[class=\"pcv3__info-content css-gwkf0u\"]"));

        String []linkText_tokopedia = new String[linkElements_tokopedia.size()];
        int k=0;
        for (WebElement element : linkElements_tokopedia) {
            linkText_tokopedia[k] = element.getAttribute("href");
            k++;
        }

        for (int i = 0; i < nameElements_tokopedia.size(); i++) {
            k = i;
            System.out.println("Name of product " + i + ": " + nameElements_tokopedia.get(i).getText());
            System.out.println("Price of product " + i + ": " + priceElements_tokopedia.get(i).getText());
            System.out.println("Link of product " + k + ": " + linkText_tokopedia[k]);
            String line_spacing = " ";
            System.out.println(line_spacing);
        }
        System.out.println("-------------------------------------");
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

        //validate the result is mentioned product
        System.out.println("--------------------ebay------------------------");
        String search = "iPhone 15 Pro";
        if (driver.getPageSource().contains(search)){
            System.out.println("Search result found: " + search);
            System.out.println("Title and name of first website: " + driver.getTitle());
            System.out.println("Name of the product: " + search);
        }

        Thread.sleep(5000);
    }

    @And("User sort ascending the price in ebay")
    public void sort_ascending_price_ebay() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[5]/div[4]/div[1]/div[2]/div[2]/div[3]/div[1]/div/span/button")).click();
        driver.findElement(By.xpath("//*[@id=\"s0-60-0-12-8-4-1-0-4[1]-70-39-1-content-menu\"]/li[4]/a")).click();
        Thread.sleep(5000);
    }

    @And("Display the output from ebay in terminal")
    public void display_output_from_ebay() throws InterruptedException {
        List<WebElement> nameElements_ebay = driver.findElements(By.cssSelector("[class = \"s-item__title\"]"));
        List<WebElement> priceElements_ebay = driver.findElements(By.cssSelector("[class = \"s-item__price\"]"));
        List<WebElement> linkElements_ebay = driver.findElements(By.cssSelector("[class=\"s-item__link\" ]"));

        String []linkText_ebay = new String[linkElements_ebay.size()];
        int k=0;
        for (WebElement element : linkElements_ebay) {
            linkText_ebay[k] = element.getAttribute("href");
            k++;
        }

        for (int i = 1; i < nameElements_ebay.size(); i++) {
            k = i;
            System.out.println("Name of product " + i + ": " + nameElements_ebay.get(i).getText());
            System.out.println("Price of product " + i + ": " + priceElements_ebay.get(i).getText());
            System.out.println("Link of product " + k + ": " + linkText_ebay[k]);
            String line_spacing = " ";
            System.out.println(line_spacing);
        }
        System.out.println("-------------------------------------");
    }
}
