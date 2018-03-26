package com.irvingfish.webautotest.simpletest.tests;

import com.irvingfish.webautotest.simpletest.pages.CasinoPage;
import com.irvingfish.webautotest.simpletest.pages.MainPage;
import com.irvingfish.webautotest.simpletest.pages.games.KingKongFuryPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class GameTestDemo {
    private static Logger LOGGER = LoggerFactory.getLogger(GameTestDemo.class);
    private final static String UNIBET_URL = "https://www.unibet.com/";
    private WebDriver driver = null;
    private MainPage mainPage;

    /**
     * Before test, start WebDriver and start from Main Page
     */
    @Before
    public void before() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(UNIBET_URL);
        mainPage = new MainPage(driver);
    }

    /**
     * A test include navigate from Main page of NetEnt to "Aloha! Cluster Pays"
     * Game Page, and Load the game and simple play
     */
    @Test
    public void gameLoadAndPlay() {
        CasinoPage casinoPage = mainPage.goToCasinoPage();
        KingKongFuryPage kingKongGame = casinoPage.goToKingKongGame();
        try {
            kingKongGame.clickContinue();
            kingKongGame.multiTimePlay(3);
            kingKongGame.clickBetUp();
            kingKongGame.multiTimePlay(1);
            kingKongGame.clickBetDown();
            kingKongGame.autoPlayTenTimes();
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
            //add save screen capture for troubleshooting
            saveScreenCapture(kingKongGame.getScreen());
            //to fail the test
            throw new RuntimeException(findFailed.getMessage());
        }
    }

    /**
     * After test, close the Web Driver
     */
    @After
    public void after() {
        driver.close();
    }

    /**
     * save the Screen capture might for troubleshooting purpose
     *
     * @param screen
     */
    private void saveScreenCapture(Screen screen) {

        String path = screen.capture().save(".");
        LOGGER.info("A Screen capture has been saved to " + path);
    }

}
