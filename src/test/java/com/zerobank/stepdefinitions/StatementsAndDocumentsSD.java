package com.zerobank.stepdefinitions;
import com.zerobank.pages.Zero_StatementsAndDocumentsPage;
import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StatementsAndDocumentsSD {
    Zero_StatementsAndDocumentsPage zeroStatementsAndDocumentsPage =new Zero_StatementsAndDocumentsPage();
    @Given("User navigate to Online Statements")
    public void user_navigate_to_Online_Statements() {
        zeroStatementsAndDocumentsPage.onlineStatementsClick();
        BrowserUtilities.wait(5);
    }
    @Given("the user accesses the Statements & Documents tab")
    public void the_user_accesses_the_Statements_Documents_tab() {
        BrowserUtilities.waitForPageToLoad(10);
        Assert.assertEquals("Zero - Online Statements",Driver.getDriver().getTitle());
    }
    @When("the user selects the Recent Statements Year {int}")
    public void the_user_selects_the_Recent_Statements_Year(Integer int1) {
        zeroStatementsAndDocumentsPage.selectYear(int1);
    }
    @Then("{int} statements should be displayed for that year")
    public void statements_should_be_displayed_for_that_year(int count) {
        BrowserUtilities.wait(5);
        Assert.assertEquals(zeroStatementsAndDocumentsPage.numberStatementDisplayed(),count);
    }

    @When("the user clicks on statement {string}")
    public void the_user_clicks_on_statement(String string) {
        zeroStatementsAndDocumentsPage.statementClick(string);
    }

    @Then("the downloaded file name should contain {string}")
    public void the_downloaded_file_name_should_contain(String string) {
        Assert.assertTrue(zeroStatementsAndDocumentsPage.statementName(string).contains(string));
    }
    @Then("the {string} file type should be pdf")
    public void the_file_type_should_be_pdf(String string) {
        Assert.assertTrue(zeroStatementsAndDocumentsPage.fileNameAndType(string).contains(string));
    }
}