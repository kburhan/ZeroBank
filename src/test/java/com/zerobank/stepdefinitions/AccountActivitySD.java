package com.zerobank.stepdefinitions;
import java.util.List;
import com.zerobank.pages.Zero_ActivityPage;
import com.zerobank.pages.Zero_LoginPage;
import com.zerobank.utilities.BrowserUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountActivitySD {
    Zero_LoginPage zeroLoginPage =new Zero_LoginPage();
    Zero_ActivityPage zeroActivityPage =new Zero_ActivityPage();
    WebDriverWait wait;

    @Then("Account drop down default option should be Savings")
    public void account_drop_down_default_option_should_be_Savings() {
        BrowserUtilities.wait(5);
        Assert.assertTrue(zeroActivityPage.setDefaultOptionSaving().isSelected());
    }
    @Then("Transactions table should have column")
    public void transactions_table_should_have_column(List<String>column) {
        System.out.println("Expected: "+column);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(5);
        Assert.assertEquals(column, zeroActivityPage.accountActivityTabNames());
    }

    @When("User navigate to {string}")
    public void user_navigate_to(String string) {
        zeroLoginPage.navigate_to_tabName(string);
        BrowserUtilities.wait(5);
    }

    @Then("following account drop down should be available")
    public void following_account_drop_down_should_be_available(List<String> dropDown) {
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(5);
        Assert.assertEquals(dropDown, zeroActivityPage.dropDown());

    }


}