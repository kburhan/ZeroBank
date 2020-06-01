package com.zerobank.stepdefinitions;
import org.openqa.selenium.*;
import com.zerobank.pages.Zero_PayBills;
import com.zerobank.utilities.BrowserUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PayBillsSD {

    Zero_PayBills zeroPayBills =new Zero_PayBills();
    WebDriverWait wait;
    WebDriver driver;

    @When("User navigate to Pay Bills")
    public void user_navigate_to_Pay_Bills() {
        BrowserUtilities.wait(5);
        zeroPayBills.payBillsNavigate();
    }

    @Then("User make payments")
    public void user_make_payments() {
        BrowserUtilities.wait(5);
        zeroPayBills.makePayments("200","2020-06-20","credit card payment");
    }

    @Then("The payment was successfully submitted should be displayed")
    public void the_payment_was_successfully_submitted_should_be_displayed() {
        BrowserUtilities.wait(5);
        Assert.assertTrue(zeroPayBills.getSuccesfullMessage().isDisplayed());
    }
    @Then("make a payment without entering the amount or date, Please fill out this field message! should be displayed")
    public void make_a_payment_without_entering_the_amount_or_date_Please_fill_out_this_field_message_should_be_displayed() {
        BrowserUtilities.wait(5);
        zeroPayBills.makePayments("","","credit card payment");
        BrowserUtilities.wait(5);
        Assert.assertEquals(zeroPayBills.alertMessage(),"Please fill out this field.");
    }


}