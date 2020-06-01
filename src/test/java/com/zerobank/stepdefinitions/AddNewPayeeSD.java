package com.zerobank.stepdefinitions;
import com.zerobank.pages.Zero_NewPayeePage;
import com.zerobank.utilities.BrowserUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.Map;

public class AddNewPayeeSD {
    Zero_NewPayeePage zeroNewPayeePage =new Zero_NewPayeePage();

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        zeroNewPayeePage.addNewPAyeeClick();
    }
    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> dataTable) {
        zeroNewPayeePage.addNewPayeeInformation(dataTable.get("Payee Name"),dataTable.get("Payee Address"), dataTable.get("Account"),dataTable.get("Payee details"));
    }
    @Given("click add button")
    public void click_add_button() {
        zeroNewPayeePage.addButtonClick();
    }

    @Then("message The new payee The Offices of Burhan Kaya was successfully created.")
    public void message_The_new_payee_The_Offices_of_Burhan_Kaya_was_successfully_created() {
        String message="The new payee The Offices of Burhan Kaya was successfully created.";
        Assert.assertEquals(message, zeroNewPayeePage.message());
    }

}