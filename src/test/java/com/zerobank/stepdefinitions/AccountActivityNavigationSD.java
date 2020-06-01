package com.zerobank.stepdefinitions;
import com.zerobank.pages.AccountActivityNavigationPageBase;
import com.zerobank.utilities.BrowserUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountActivityNavigationSD {

    AccountActivityNavigationPageBase accountActivityNavigationPageBase = new AccountActivityNavigationPageBase();
    WebDriverWait wait;

    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
        BrowserUtilities.wait(5);
        accountActivityNavigationPageBase.savingClicked().click();
    }
    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String string) {
        BrowserUtilities.wait(5);
        accountActivityNavigationPageBase.clickTo(string);
    }
    @And("Account drop down should have {string} selected")
    public void accountDropDownShouldHaveSelected(String string) {
        BrowserUtilities.wait(5);
        Assert.assertTrue(accountActivityNavigationPageBase.clickLink(string).isSelected());

    }

}