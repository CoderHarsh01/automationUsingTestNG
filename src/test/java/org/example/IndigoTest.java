package org.example;

import org.example.driver.BaseTest;
import org.example.driver.DriverSetup;
import org.example.ui.flight.BookingPage;
import org.example.wait.WaitForSometime;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class IndigoTest extends BaseTest {
    public String url = "https://www.goindigo.in/?cid=Display|Affiliate|LF|LA97|1349_%7Byour-sub-aff-id%7D";
    @BeforeClass
    public void launchDemoWebShop() throws IOException {
        String title = DriverSetup.getDriver().getTitle();
        DriverSetup.getDriver().get("https://healthapp.yaksha.com/");
        WaitForSometime.pleaseWaitForSometime();
        System.out.println(title);
//        Assert.assertEquals(title,"Demo Web Shop");
    }

    @Test(priority = 1)
    public void selectCity(){

        BookingPage bookingPage = new BookingPage(DriverSetup.getDriver());
        bookingPage.performAction();
    }

}
