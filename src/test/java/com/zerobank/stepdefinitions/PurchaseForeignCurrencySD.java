package com.zerobank.stepdefinitions;
import java.util.List;
import com.zerobank.pages.Zero_PurchaseForeignCurrencyPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PurchaseForeignCurrencySD {
    Zero_PurchaseForeignCurrencyPage zeroPurchaseForeignCurrencyPage =new Zero_PurchaseForeignCurrencyPage();

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        zeroPurchaseForeignCurrencyPage.purchaseForeignClick();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
        for(String each: dataTable){
            zeroPurchaseForeignCurrencyPage.setCurrency().contains(each);
        }
    }
    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        zeroPurchaseForeignCurrencyPage.calculateClick();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertEquals("Please, ensure that you have filled all the required fields with valid values.", zeroPurchaseForeignCurrencyPage.alert());
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        zeroPurchaseForeignCurrencyPage.calculateClick();
    }
}