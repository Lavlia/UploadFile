package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadFilePage extends BasePage {

    public UploadFilePage() {
        super();
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='uploadfile_0']")
    private WebElement uploadFileTextboxElement;

    @FindBy(xpath = "//input[@id='terms']")
    private WebElement termsCheckboxElement;

    @FindBy(xpath = "//button[@id='submitbutton']")
    private WebElement submitFileButtonElement;

    @FindBy(xpath = "//h3[@id='res']")
    private WebElement messageElement;

    public WebElement getUploadFileTextboxElement() {
        return uploadFileTextboxElement;
    }

    public WebElement getTermsCheckboxElement() {
        return termsCheckboxElement;
    }

    public WebElement getSubmitFileButtonElement() {
        return submitFileButtonElement;
    }

    public WebElement getMessageElement() {
        return messageElement;
    }

    public void chooseValidFile() {
        getUploadFileTextboxElement().sendKeys("F:\\repo\\FileUploadExercises\\src\\Lisa Simpsons.jpg");
    }

    public void chooseInvalidFile() {
        getUploadFileTextboxElement().sendKeys("path/to/large/file");
    }

    public void chooseNoFile() {
        getUploadFileTextboxElement().sendKeys("");
    }

    public String getMessage() {
        String message = getMessageElement().getAttribute("textContent");
        return message;
    }

    public String getFileName() {
        String fileName = getUploadFileTextboxElement().getAttribute("value");
        return fileName;
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
