import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirstTest {
    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Mandatory capabilities
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("browserVersion", "latest");
        caps.setCapability("platformName", "Windows 10");

        // LambdaTest options (wrapped inside LT:Options)
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", System.getenv("LT_USERNAME"));
        ltOptions.put("accessKey", System.getenv("LT_ACCESS_KEY"));
        ltOptions.put("build", "GitHub Actions Selenium Build");
        ltOptions.put("name", "FirstTest");

        caps.setCapability("LT:Options", ltOptions);

        RemoteWebDriver driver = new RemoteWebDriver(
            new URL("https://hub.lambdatest.com/wd/hub"), 
            caps
        );

        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
        driver.quit();
    }
}
