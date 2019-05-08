package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends BaseUtil {
    protected WebDriverWait wait;

    //Wait for driver
    public BasePage() {

        wait = new WebDriverWait(BaseUtil.getDriver(), 30);
        BaseUtil.getDriver().manage().window().maximize();
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    //Wait for visibility of the element
    public void waitForVisibility(WebElement element) {
        try {
            wait = new WebDriverWait(BaseUtil.getDriver(), 100);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
