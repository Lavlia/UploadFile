package pageObject;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class BaseUtil {
    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    //To quit the drivers and browsers at the end only.
    private static List<WebDriver> storedDrivers = new ArrayList<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                storedDrivers.stream().forEach(WebDriver::quit);
            }
        });
    }

    protected BaseUtil() {
    }

    protected static WebDriver getDriver() {
        return drivers.get();
    }

    protected static void addDriver(WebDriver driver) {
        storedDrivers.add(driver);
        drivers.set(driver);
    }

    protected static void removeDriver() {
        storedDrivers.remove(drivers.get());
        drivers.remove();
    }

}
