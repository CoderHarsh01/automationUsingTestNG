package org.example.ui;

import org.openqa.selenium.By;

public class LoginPageForm {

    public static By REGISTER_NEW_ACCOUNT = By.xpath("//*[@class='ico-register']");
    public static By GENDER_MALE = By.xpath("//*[@class='gender']//following-sibling::label[@for='gender-male']");
    public static By GENDER_FEMALE = By.xpath("//*[@class='gender']//following-sibling::label[@for='gender-female']");
    public static By FIRST_NAME = By.xpath("//input[@id='FirstName']");
    public static By LAST_NAME = By.xpath("//input[@id='LastName']");
    public static By EMAIL = By.xpath("//input[@id='Email']");
    public static By PASSWORD = By.xpath("//input[@id='Password']");
    public static By CONFIRM_PASSWORD = By.xpath("//input[@id='ConfirmPassword']");
    public static By REGISTER_BUTTON = By.xpath("//input[@id='register-button']");
    public static By CONTINUE_BUTTON = By.xpath("//*[@class='button-1 register-continue-button']");
    public static By LOGOUT = By.xpath("//*[@class='ico-logout']");

}
