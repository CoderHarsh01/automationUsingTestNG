package org.example.driver;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class ManageCookies {

    public WebDriver driver;
    public ManageCookies(WebDriver driver){
        this.driver = driver;
    }

    public void storeName(String email){
        Cookie cookie = new Cookie("userEmail",email);
        driver.manage().addCookie(cookie);
    }

    public String getStoredEmail(){
        Cookie cookie = driver.manage().getCookieNamed("userEmail");
        String email = cookie.getValue();
        return email;
    }
}
