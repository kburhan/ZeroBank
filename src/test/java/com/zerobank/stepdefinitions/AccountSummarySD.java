package com.zerobank.stepdefinitions;
import java.util.List;
import com.zerobank.pages.Zero_AccountSummaryPage;
import com.zerobank.utilities.BrowserUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountSummarySD {

    Zero_AccountSummaryPage zeroAccountSummaryPage =new Zero_AccountSummaryPage();
    WebDriverWait wait;

    @And("following account types should be available")
    public void following_account_types_should_be_available(List<String> dataTable) {
        System.out.println("Expected Types: " + dataTable);
        BrowserUtilities.waitForPageToLoad(20);
        BrowserUtilities.wait(5);
        Assert.assertEquals(dataTable, zeroAccountSummaryPage.getAccountSummaryTypes());
    }

    @Then("Credit Accounts table must have columns")
    public void credit_Accounts_table_must_have_columns(List<String> columns) {
        System.out.println("Expceted columns: "+columns);
        BrowserUtilities.waitForPageToLoad(20);
        BrowserUtilities.wait(5);
        Assert.assertEquals(columns, zeroAccountSummaryPage.getCreditAccountsColumns());
    }

}