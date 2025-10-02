package org.example;


import org.example.data.CsvDataProvider;
import org.example.driver.BaseTest;
import org.example.driver.DriverSetup;
import org.example.driver.ManageCookies;
import org.example.model.UserData;
import org.example.ui.DashboardPage;
import org.example.ui.LoginPage;
import org.example.wait.WaitForSometime;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AppTest extends BaseTest {

    public WaitForSometime wait = new WaitForSometime();
    @BeforeClass
    public void launchDemoWebShop() throws IOException {
        String title = DriverSetup.getDriver().getTitle();
        DriverSetup.getDriver().get("https://demowebshop.tricentis.com/");
        WaitForSometime.pleaseWaitForSometime();
        System.out.println(title);
//        Assert.assertEquals(title,"Demo Web Shop");
    }

    @Test(priority = 1,
            dataProvider = "csvUserData",dataProviderClass = CsvDataProvider.class)
    public void loginPage(UserData userData) throws IOException {
//        DriverSetup.getDriver().get("https://demowebshop.tricentis.com/");
        LoginPage loginPage = new LoginPage();
        loginPage.performActions(userData);
        ManageCookies manageCookies = new ManageCookies(DriverSetup.getDriver());
        System.out.println("Random Email in UI "+manageCookies.getStoredEmail());

        String currentTile = DriverSetup.getDriver().getTitle();
        Assert.assertEquals(currentTile,"Demo Web Shop");
    }

    @Test(priority = 2)
    public void logout(){
        DashboardPage dashboardPage = new DashboardPage(DriverSetup.getDriver());
        String title = dashboardPage.performActions();
        Assert.assertEquals(title,"Demo Web Shop. Computers");
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown(){
        DriverSetup.quitDriver();
    }

//    @Test(dataProvider = "csvUserData", dataProviderClass = CsvDataProvider.class)
//    public void testRegistration(UserData user) {
//        System.out.println("Running Scenario: " + user.getScenarioID());
//        System.out.println("Gender: " + user.getGender());
//        System.out.println("Name: " + user.getFirstName() + " " + user.getLastName());
//        System.out.println("Email: " + user.getEmail());
//
//        // here you can use POM classes to perform actions
//        // e.g., loginPage.selectGender(user.getGender());
//    }
}

