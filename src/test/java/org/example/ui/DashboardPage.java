package org.example.ui;

import org.example.driver.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage {

    public WebDriver driver;

    public DashboardPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickOnBooks(){
        driver.findElement(DashBoardForm.BOOKS).click();
    }
    public void moveToComputers(){
        Actions actions = new Actions(DriverSetup.getDriver());
        Action action = actions.moveToElement(driver.findElement(DashBoardForm.COMPUTERS)).click().build();
        action.perform();
    }

    public void clickOnDesktop(){
        driver.findElement(DashBoardForm.DESKTOP).click();
    }

    public String performActions(){
        moveToComputers();
        clickOnDesktop();
        String title = driver.getTitle().toString();
        return title;
    }

}
