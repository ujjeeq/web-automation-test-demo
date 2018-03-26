package com.irvingfish.webautotest.simpletest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object for Main page of Unibet
 * <p>Url: <a href="https://www.unibet.com/">
 *     https://www.unibet.com/</a><p/>
 */
//TODO: add other WebElements and methods
public class MainPage {
    private WebDriver driver;

    //A linkText used by PageFactory to find the web element
    // to navigate to Aloha Page
    @FindBy(linkText = "Casino")
    private WebElement casino;

    /**
     * Constructor for MainPage
     * @param driver
     */
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /**
     * Navigate method to "Casino" Page
     * @return CasinoPage Object
     */
    public CasinoPage goToCasinoPage() {
        driver.get(casino.getAttribute("href"));
        return new CasinoPage(driver);
    }
}
