package simbirsoft.eshevtsova.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
public class TestBase {
    @BeforeAll
    static void beforeAll(){

        System.setProperty("webdriver.gecko.driver", "c:\\geckodriver.exe");
        Configuration.browser="FIREFOX";
        Configuration.browserSize = "1600x900";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
