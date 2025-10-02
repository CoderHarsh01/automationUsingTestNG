package org.example.driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class DriverSetup {

    private static WebDriver driver;

    private DriverSetup() {
        // prevent instantiation
    }

    /**
     * Initialize WebDriver
     */
    public static void initDriver(String browser) {
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser: " + browser);
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
    }

    /**
     * Get WebDriver instance
     */

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized. Call initDriver() first.");
        }
        return driver;
    }

    /**
     * Quit WebDriver
     */

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
