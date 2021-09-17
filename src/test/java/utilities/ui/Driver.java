package utilities.ui;

import org.openqa.selenium.WebDriver;

public class Driver {
    private Driver() {

    }


    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            switch (ConfigsReader.getProperty("browser").toLowerCase()) {
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver(Boolean.parseBoolean(ConfigsReader.getProperty("headless")));
                    break;
                case "firefox":
                    driver = FireFoxWebDriver.loadFireFoxDriver(Boolean.parseBoolean(ConfigsReader.getProperty("headless")));
                    break;
                default:
                    driver = ChromeWebDriver.loadChromeDriver(Boolean.parseBoolean(ConfigsReader.getProperty("headless")));
                    break;

            }
        }
        return driver;

    }

    public static void closeDriver() {
        if (driver == null) return;

        try {
            driver.close();
            driver.quit();
            driver = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
