package com.irvingfish.webautotest.simpletest.pages.games;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/**
 * Page Object for "King Kong Fury" Page of Unibet
 * <p>Url: <a href="https://www.unibet.com/casino/king-kong-fury-1.1009602">
 * https://www.unibet.com/casino/king-kong-fury-1.1009602</a><p/>
 */
//TODO: add other WebElements and methods
public class KingKongFuryPage {

    private WebDriver driver;

    //The game section is in iframe which is on another page,
    // need Sikuli api help to test.
    private Screen screen;
    private static final String IMAGE_RESOURCE = "src/main/resources/images/";

    /**
     * constructor for KingKongFuryPage
     *
     * @param driver
     */
    public KingKongFuryPage(WebDriver driver) {
        this.driver = driver;
        screen = new Screen();
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * A behave method to Click anywhere to continue
     * <p>
     * After game load, there is Continue Button to proceed
     *
     * @throws FindFailed
     */
    public void clickContinue() throws FindFailed {
        Pattern continueZone = new Pattern(IMAGE_RESOURCE + "ctn.png");
        screen.wait(continueZone, 15);
        screen.click(continueZone);
        screen.click(continueZone);// Add twice as an workaround since the first time no response
    }

    /**
     * A behave method to Click Play Button
     * <p>
     * Play Button is the main Button to Play
     *
     * @throws FindFailed
     */
    public void clickPlay() throws FindFailed {
        clickButton("play");
    }

    /**
     * A behave method to Click BetUp Button
     * <p>
     * BetUp Button is the Button to increase bet for per play
     *
     * @throws FindFailed
     */
    public void clickBetUp() throws FindFailed {
        clickButton("betUp");
    }

    /**
     * A behave method to Click BetDown Button
     * <p>
     * BetDown Button is the Button to decrease bet for per play
     *
     * @throws FindFailed
     */
    public void clickBetDown() throws FindFailed {
        clickButton("betDown");
    }

    /**
     * A behave method to Auto play with ten times
     *
     * @throws FindFailed
     */
    public void autoPlayTenTimes() throws FindFailed {
        clickButton("autoPlayBtn");
        clickButton("ten");
        clickButton("tenTimePlay");

        //wait playButton show again then exit this method
        Pattern playButton = new Pattern(IMAGE_RESOURCE  + "play.png");
        screen.wait(playButton, 150);
    }


    private void clickButton(String buttonName) throws FindFailed {
        Pattern button = new Pattern(IMAGE_RESOURCE + buttonName + ".png");
        screen.wait(button, 15);
        screen.click(button);
    }

    /**
     * getter for screen
     *
     * @return Screen
     */
    public Screen getScreen() {
        return screen;
    }


    public void multiTimePlay(int times) throws FindFailed {
        for (int i = 0; i < times; i++) {
            clickPlay();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
