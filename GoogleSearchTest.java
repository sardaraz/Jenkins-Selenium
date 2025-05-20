import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearchTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // Use WebDriverManager to avoid manual ChromeDriver setup (optional but useful)
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("OpenAI ChatGPT");
        searchBox.submit();

        // Wait a few seconds to simulate result load
        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        assert driver.getTitle().toLowerCase().contains("openai");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
