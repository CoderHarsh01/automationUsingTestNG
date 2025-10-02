package org.example.driver;



import org.testng.annotations.*;

public class BaseTest {

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    @BeforeClass
    public void setUp(String browser) {
        DriverSetup.initDriver(browser);
    }

    @AfterMethod(alwaysRun = true)
    @AfterClass
    public void tearDown() {
        DriverSetup.quitDriver();
    }
}
