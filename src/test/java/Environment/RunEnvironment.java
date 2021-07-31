package Environment;
import org.openqa.selenium.WebDriver;

public class RunEnvironment {
    public static WebDriver driver = null;

    public static void setWebDriver(WebDriver driver) {
        RunEnvironment.driver = driver;
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

}