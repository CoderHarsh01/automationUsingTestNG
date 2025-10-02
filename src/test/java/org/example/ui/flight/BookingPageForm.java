package org.example.ui.flight;

import org.openqa.selenium.By;

public class BookingPageForm {

    public static By ONE_WAY = By.xpath("//*[@class='custom-radio ' and @aria-label='oneWay']//following-sibling::span");
    public static By ROUND_TRIP = By.xpath("//*[@class='custom-radio ' and @aria-label='roundTrip']//following-sibling::span");
    public static By MULTI_CITY = By.xpath("//*[@class='custom-radio ' and @aria-label='multiCity']//following-sibling::span");
    public static  By FROM = By.xpath("//*[@class='label_top' and contains(text(),'From')]");
    public static By TO = By.xpath("//*[@class='label_top' and contains(text(),'To')]");
}
