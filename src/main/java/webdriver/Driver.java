package webdriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.logging.Logger;


public class Driver {

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private Driver(){}

    private static WebDriver driver = null;

    public static WebDriver getDriver(){

        LOGGER.info("tentativa de conectar ao browser");

        if(driver == null){
            switch (Propriedades.BROWSER){

                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }
        }

        LOGGER.info("Conectado ao browser");
        return driver;
    }

    public static void setDriver(WebDriver drivers){
        driver = drivers;
    }

}