package stepsDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pageObject.BaseUtil;
import pageObject.DemoPage;
import pageObject.UploadFilePage;

public class UploadFileSteps extends BaseUtil {

    private DemoPage demoPage = new DemoPage();
    private UploadFilePage uploadFilePage = new UploadFilePage();

    //Start background
    @Given("^User is on Website demo.guru99.com$")
    public void userIsOnWebsiteDemoGuruCom() {
        getDriver().get("http://demo.guru99.com/");
    }

    @When("^User clicks on “Selenium” field from main menu$")
    public void userClicksOnSeleniumFieldFromMainMenu() {
        demoPage.waitForVisibility(demoPage.getSeleniumDropdownMenuElement());
        demoPage.clickOnElement(demoPage.getSeleniumDropdownMenuElement());
    }

    @And("^User selects “File Upload” from the drop down$")
    public void userSelectsFileUploadFromTheDropDown() {
        demoPage.selectFromDropdown();
    }

    //Background stops

    @When("^User choose a file from his/her device$")
    public void userChooseAFileFromHisHerDevice() {
        uploadFilePage.chooseValidFile();
    }

    @When("^User choose a file from his/her device with invalid size$")
    public void userChooseAFileFromHisHerDeviceWithInvalidSize() {
        uploadFilePage.chooseInvalidFile();
    }

    @When("^User did not choose a file from his/her device$")
    public void userDidNotChooseAFileFromHisHerDevice() {
        uploadFilePage.chooseNoFile();

    }

    @And("^User checks the checkbox for “I accept terms of service”$")
    public void userChecksTheCheckboxForIAcceptTermsOfService() {
        uploadFilePage.waitForVisibility(uploadFilePage.getTermsCheckboxElement());
        uploadFilePage.clickOnElement(uploadFilePage.getTermsCheckboxElement());
    }

    @And("^User did not check the checkbox for “I accept terms of service”$")
    public void userDidNotCheckTheCheckboxForIAcceptTermsOfService() {
        //No action
    }

    @And("^User press the “Submit File” button$")
    public void userPressTheSubmitFileButton() {
        uploadFilePage.waitForVisibility(uploadFilePage.getSubmitFileButtonElement());
        uploadFilePage.clickOnElement(uploadFilePage.getSubmitFileButtonElement());
    }

    @Then("^User should see the success message$")
    public void userShouldSeeTheSuccessMessage() {
        uploadFilePage.waitForVisibility(uploadFilePage.getMessageElement());
        String message = uploadFilePage.getMessage();
        Assert.assertTrue(message.contains("successfully uploaded"),
                "The message did not contains 'successfully uploaded'");
    }

    @Then("^User should not see the success message$")
    public void userShouldNotSeeTheSuccessMessage() {
        uploadFilePage.waitForVisibility(uploadFilePage.getMessageElement());
        String message = uploadFilePage.getMessage();
        Assert.assertFalse(message.contains("successfully uploaded"),
                " The message contains 'successfully uploaded'");
    }
}
