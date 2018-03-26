package com.irvingfish.webautotest.simpletest.pages;

import com.irvingfish.webautotest.simpletest.pages.games.KingKongFuryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object for "Casino" Page of Unibet
 * <p>Url: <a href="https://www.unibet.com/casino">
 *     https://www.unibet.com/casino</a><p/>
 */
//TODO: add other WebElements and methods
public class CasinoPage {


    private WebDriver driver;

    //A little complicated Xpath expression used by PageFactory
    // to find the web element to navigate to King Kong Game Page
    private static final String XPATH_KING_KONG
            = "//section[starts-with(@id,'filtered-games-result')]/div/div[2]/div/ul/li/a/article/div[3]/ul[2]/li[2]/button";
    @FindBy(xpath = XPATH_KING_KONG)
    private WebElement kingKong;

    /**
     * Constructor for CasinoPage
     * @param driver WebDriver
     */
    public CasinoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /**
     * navigate method to "King Kong Fury" Page
     * @return KingKongFuryPage Object
     */
    public KingKongFuryPage goToKingKongGame() {
        kingKong.click();
        return new KingKongFuryPage(driver);
    }
}
