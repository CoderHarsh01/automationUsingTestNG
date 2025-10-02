package org.example.ui;

import org.example.actions.RandomEmailGenerator;
import org.example.driver.DriverSetup;
import org.example.driver.ManageCookies;
import org.example.model.UserData;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private static WebDriver driver;

    public LoginPage() {
        this.driver = DriverSetup.getDriver();
    }

    public void clickOnRegisterLink() {
        driver.findElement(LoginPageForm.REGISTER_NEW_ACCOUNT).click();
    }

    public void selectGender(String gender) {
        switch (gender) {
            case "male", "Male":
                driver.findElement(LoginPageForm.GENDER_MALE).click();
                break;
            case "female", "Female":
                driver.findElement(LoginPageForm.GENDER_FEMALE).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid gender value provided: " + gender + " Allowed only male/female");
        }
    }

    public void enterFirstName(String fName) {
        driver.findElement(LoginPageForm.FIRST_NAME).sendKeys(fName);
    }

    public void enterLastName(String lName) {
        driver.findElement(LoginPageForm.LAST_NAME).sendKeys(lName);
    }

    public void enterEmail() {
       String email = RandomEmailGenerator.generateRandomEmail();
        System.out.println("Random Email "+email);
        ManageCookies manageCookies = new ManageCookies(DriverSetup.getDriver());
        manageCookies.storeName(email);
        driver.findElement(LoginPageForm.EMAIL).sendKeys(email);
    }
    public void enterPassword(String password) {
        driver.findElement(LoginPageForm.PASSWORD).sendKeys(password);
    }
    public void confirmPassword(String cPassword) {
        driver.findElement(LoginPageForm.CONFIRM_PASSWORD).sendKeys(cPassword);
    }
    public void clickRegisterButton() {
        driver.findElement(LoginPageForm.REGISTER_BUTTON).click();
    }
    public void logout(){
        driver.findElement(LoginPageForm.LOGOUT).click();
    }
    public void clickContinueButton() {
        driver.findElement(LoginPageForm.CONTINUE_BUTTON).click();
    }
    public void performActions(UserData userData) {
        clickOnRegisterLink();
        selectGender(userData.getGender());
        enterFirstName(userData.getFirstName());
        enterLastName(userData.getLastName());
        enterEmail();
        enterPassword(userData.getPassword());
        confirmPassword(userData.getPassword());
        clickRegisterButton();
        clickContinueButton();
    }
}
