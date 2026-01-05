package driver.drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver() {
        WebDriver driver = null;

        switch (getBrowserType()){
            case "chrome"->{
                System.setProperty(
                        "webdriver.chrome.driver",
                        System.getProperty("user.dir") + "/src/main/java/driver/drivers/chromedriver.exe"
                );
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox"->{
                //43
//                System.setProperty(
//                        "webdriver.chrome.driver",
//                        System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe"
//                );
//                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//                driver = new ChromeDriver(chromeOptions);
                break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }
    public static String getBrowserType() {
        String browserType = null;

        try{
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/properties/config.properties");
            properties.load(file);
            browserType = properties.getProperty("browser").toLowerCase().trim();

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return browserType;
    }

    public static void cleanupDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }
}
