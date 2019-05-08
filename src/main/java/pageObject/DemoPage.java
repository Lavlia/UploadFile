package pageObject;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoPage extends BasePage {
    public DemoPage() {
        super();
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    private WebElement seleniumDropdownMenuElement;

    @FindBy(xpath = "//a[text()='File Upload']")
    private WebElement fileUploadSelectedElement;

    public WebElement getSeleniumDropdownMenuElement() {
        return seleniumDropdownMenuElement;
    }

    public WebElement getFileUploadSelectedElement() {
        return fileUploadSelectedElement;
    }

    public void selectFromDropdown(){
        Actions dropdown = new Actions(getDriver());
        Action selectElement = dropdown.moveToElement(getFileUploadSelectedElement()).click().build();
            selectElement.perform();
        }


    @Override
    public void waitForVisibility(WebElement element) {
        super.waitForVisibility(element);
    }

    @Override
    public void clickOnElement(WebElement element) {
        super.clickOnElement(element);
    }


}
