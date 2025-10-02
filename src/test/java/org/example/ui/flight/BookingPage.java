package org.example.ui.flight;

import com.beust.ah.A;
import org.example.driver.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingPage {
    public WebDriver driver;

    public BookingPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectTheTrip(String trip)
    {
        switch (trip){
            case "OneWay":
                driver.findElement(BookingPageForm.ONE_WAY).click();
                break;
            case "RoundTrip":
                driver.findElement(BookingPageForm.ROUND_TRIP).click();
                break;
            case "MultiCity":
                driver.findElement(BookingPageForm.MULTI_CITY).click();
            default: throw new IllegalArgumentException ("Invalid Trip Type: Select Proper Trip");
        }
    }

    public void enterTheCityFromAndTo(){
        Actions actions = new Actions(DriverSetup.getDriver());
        Action action = actions.moveToElement(driver.findElement(BookingPageForm.FROM)).build();
        action.perform();
//        driver.findElement(BookingPageForm.FROM).click();
    }

    public void performAction(){
//        selectTheTrip("OneWay");
//        enterTheCityFromAndTo();
        driver.findElement(By.id("username_id")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("pass123");
        driver.findElement(By.id("login")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Select Counter')]")));
        boolean res = driver.findElement(By.xpath("//*[contains(text(),'Select Counter')]")).isDisplayed();

        System.out.println("CHeck visible "+res);
        if(driver.findElement(By.xpath("//*[contains(text(),'Select Counter')]")).isDisplayed())
        {
            System.out.println("iwejdkcsn x,");
            driver.findElement(By.xpath("//a[contains(text(),'X')]")).click();
        }
//        WebElement element = driver.findElement(By.xpath("(//*[@class='menu-content out page-sidebar-menu cstm-sidebar']//span[@class='collapsed ad-sign'])[1]"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].setAttribute('aria-expanded', 'true');", element);
////        js.executeScript("return window.getComputedStyle(arguments[0].click(),'::after'",element);
//        WebElement pharmacy = driver.findElement(By.xpath("//a[@href='#/Pharmacy']"));
        WebElement pharmacy = driver.findElement(By.xpath("//img[@src='/themes/theme-default/images/nav/pharmacy.png']//following-sibling::span[contains(text(),'Pharmacy')]"));
        boolean ph = pharmacy.isDisplayed();
        System.out.println(ph);
        try {
            Thread.sleep(5000);
        }catch(Exception e){

        }
        System.out.println("prescription "+driver.findElement(By.xpath("//*[contains(text(),'Prescription')]")).isDisplayed());
        try {
            Thread.sleep(5000);
        }catch(Exception e){

        }
        System.out.println("prescription "+driver.findElement(By.xpath("//*[contains(text(),'Prescription')]")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Order')]")).isDisplayed());
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
        element.click();
        String str = element.getAttribute("class");
        System.out.println(str);
        Actions actions = new Actions(driver);
        actions.moveToElement(pharmacy).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        pharmacy.click();
        String pharmacyURl = driver.getCurrentUrl().toString();

        System.out.println("Pharmacy URL "+pharmacyURl);


    }
}
