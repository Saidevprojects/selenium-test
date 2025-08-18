package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;

public class FirstTest {
    @Test
    public void testGoogleTitle() throws Exception {
        String username = System.getenv("LT_USERNAME");
        String accessKey = System.getenv("LT_ACCESS_KEY");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("browserVersion", "latest");
        caps.setCapability("platformName", "Windows 10");

        WebDriver driver = new RemoteWebDriver(
            new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"),
            caps
        );

        driver.get("https://www.google.com");
        Assert.assertTrue(driver.getTitle().contains("Google"));
        driver.quit();
    }
}
