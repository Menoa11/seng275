import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UvicTest {
    WebDriver browser;

    @BeforeEach
    public void setUp() {
        String chromeDriverPath = System.getProperty("user.dir") + "\\driver\\chromedriver-win64\\chromedriver.exe";
        // Chrome
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        browser = new ChromeDriver(options);

        browser.manage().window().maximize();
        browser.get("https://www.uvic.ca");
    }

    @AfterEach
    public void cleanUp() {
        browser.quit();
    }

    @Test
    public void googlePageLoads() {
        browser.get("https://www.google.com");
        assertEquals("Google", browser.getTitle());
    }


    @Test
    public void uvicHomePageLoads() {
        assertEquals("Home - University of Victoria", browser.getTitle());
    }


    @Test
    public void uvicHomePageHasSearchButton() {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        WebElement searchButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-btn")));

        assertTrue(searchButton.isDisplayed());
    }

    @Test
    public void searchBarAppearsWhenSearchButtonClicked() {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        WebElement searchButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-btn")));
        searchButton.click();

        WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchUVic")));
        assertTrue(searchBar.isDisplayed());
    }

    @Test
    public void searchBarAcceptsText() {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        WebElement searchButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-btn")));
        searchButton.click();

        WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchUVic")));
        searchBar.sendKeys("csc");

        assertEquals("csc", searchBar.getAttribute("value"));
    }

    @Test
    public void searchResultsPageLoadsWithCorrectTitle() {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        WebElement searchButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-btn")));
        searchButton.click();

        WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchUVic")));
        searchBar.sendKeys("csc");
        searchBar.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.titleIs("Search - University of Victoria"));
        assertEquals("Search - University of Victoria", browser.getTitle());
    }

    @Test
    public void computerSciencePageContainsPhoneNumber() {
        browser.get("https://www.uvic.ca/ecs/computerscience/index.php");

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        String bodyText = body.getText();

        assertTrue(bodyText.contains("1-250-472-5700"));
    }


}

