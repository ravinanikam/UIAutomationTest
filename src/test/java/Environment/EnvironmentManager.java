package Environment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public  class EnvironmentManager {
    public static void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        RunEnvironment.setWebDriver(driver);
    }
    public static void shutDownDriver() {
        RunEnvironment.getWebDriver().quit();
    }

}
