package lunchbox.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class MyStepdefs
{
    @Given("^(.+) is identified$")
    public void user_is_identified(String user) throws Throwable
    {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^s?he has (\\d+) on (?:his|her) account$")
    public void has_cash_on_account(int amount) throws Throwable
    {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^(\\w+) is selling at (\\d+) per share$")
    public void instrument_is_selling_at_amount_per_share(String instrument, int price) throws Throwable
    {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @When("^s?he buys (\\d+) shares of (\\w+)$")
    public void buys_shares_of_instrument(int quantity, String instrument) throws Throwable
    {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
