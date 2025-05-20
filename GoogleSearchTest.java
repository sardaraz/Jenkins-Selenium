package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--disable-gpu");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("OpenAI ChatGPT");
        searchBox.submit();

        try {
            Thread.sleep(2000); // wait for results to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String title = driver.getTitle().toLowerCase();
        assert title.contains("openai") || title.contains("chatgpt");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
