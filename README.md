# web-automation-test-demo
A Web GUI Automation Test Demo on a Unibet Casino Game: by using [Selenium](https://www.seleniumhq.org/) and [SikuliX](http://sikulix.com/) frameworks to automatically navigate to the game and play the game, you can check the demo on Youtube by: https://youtu.be/41qVezebdFU 

* [Technologies Used](#technologies-used)
* [License](#license)

## Technologies Used

* [Selenium](https://www.seleniumhq.org/)
  * Maven dependency setting
  ```xml
  <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-java</artifactId>
      <version>3.4.0</version>
  </dependency>
  ```
  * Usage
    * [Page Object Pattern](https://github.com/SeleniumHQ/selenium/wiki/PageObjects) and [Page Factory](https://github.com/SeleniumHQ/selenium/wiki/PageFactory)
    * [Xpath Syntax](https://www.guru99.com/xpath-selenium.html) Check example in the file: [CasinoPage.java](src/main/java/com/irvingfish/webautotest/simpletest/pages/CasinoPage.java)
* [SikuliX](http://sikulix.com/)
  * Maven dependency setting
  ```xml
  <dependency>
      <groupId>com.sikulix</groupId>
      <artifactId>sikulixapi</artifactId>
      <version>1.1.0</version>
  </dependency>
  ```
   * Usage : Check example in the file: [KingKongFuryPage.java](src/main/java/com/irvingfish/webautotest/simpletest/pages/games/KingKongFuryPage.java)
 
 ## License
Apache 2.0, see [LICENSE](LICENSE)
