import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {

    @Test
    public void testGoogleTitle() throws MalformedURLException {
        // Fetch credentials from GitHub Actions secrets
        String username = System.getenv("LT_USERNAME");
        String accessKey = System.getenv("LT_ACCESS_KEY");

        // LambdaTest Grid URL
        String gridURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";

        // Desired Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "latest");
        capabilities.setCapability("platformName", "Windows 10");
        capabilities.setCapability("build", "GitHub Actions Selenium Build");
        capabilities.setCapability("name", "FirstTest");

        // Start Remote WebDriver
        WebDriver driver = new RemoteWebDriver(new URL(gridURL), capabilities);

        // Test
        driver.get("https://www.google.com");
        System.out.println("Title is: " + driver.getTitle());

        // Cleanup
        driver.quit();
    }
}
