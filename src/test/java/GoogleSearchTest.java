import Environment.EnvironmentManager;
import Environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GoogleSearchTest {
    public WebDriver driver;
    @BeforeEach
    public  void setUp(){
        EnvironmentManager.initWebDriver();
        driver = RunEnvironment.getWebDriver();
        driver.get("https://www.google.co.uk/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(By.id("L2AGLb")).click();
    }

    @Test
    public void testSearchBar(){
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Wembley stadium");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
        var firstResult = driver.getTitle();
        assertEquals(firstResult,"Wembley stadium - Google Search");
    }

    @Test
    public  void testClearButton(){
        var searchInputDField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        var text = "Test clear button";
        searchInputDField.sendKeys(text);
        var clearButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[3]/div[1]"));
        assertEquals(true, clearButton.isDisplayed());
        clearButton.click();
        assertEquals("", searchInputDField.getText());
        assertNotEquals(text, searchInputDField.getText());
    }
    @Test
    public  void searchCategories(){
        driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input")).sendKeys("Wembley stadium");
        driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b")).click();
        driver.findElement(By.cssSelector("#hdtb-msb > div:nth-child(1) > div > div:nth-child(3) > a")).click();
    }



    @AfterEach
    public void closeDriver(){
        driver.close();
        driver.quit();
    }
}
