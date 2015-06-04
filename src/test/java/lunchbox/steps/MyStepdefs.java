package lunchbox.steps;

import static org.assertj.core.api.Assertions.assertThat;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lunchbox.CashAccount;
import lunchbox.InvalidTransactionException;
import lunchbox.LunchBox;
import lunchbox.Portfolio;
import lunchbox.Side;
import lunchbox.Symbol;
import lunchbox.Transaction;
import lunchbox.UserId;

public class MyStepdefs
{
    public static final String SUCCESS = "Success";
    public static final String FAILURE = "Failure";

    UserId identifiedUserId;
    LunchBox lunchbox = new LunchBox();
    private String result;

    @Given("^(.+) is identified$")
    public void user_is_identified(String user) throws Throwable
    {
        identifiedUserId = lunchbox.createUser(user);
    }

    @Given("^s?he has (\\d+) on (?:his|her) account$")
    public void has_cash_on_account(int amount) throws Throwable
    {
        // FIXME implement
    }

    @And("^(\\w+) is selling at (\\d+) per share$")
    public void instrument_is_selling_at_amount_per_share(String instrument, int price) throws Throwable
    {
        // FIXME implement
    }

    @When("^s?he buys (\\d+) shares of (\\w+)$")
    public void buys_shares_of_instrument(int quantity, String instrument) throws Throwable
    {
        getIdentifiedUserPortfolio().addTransaction(new Transaction(quantity, new Symbol(instrument), Side.BUY));
        result = SUCCESS;
    }

    @Then("^s?he should get a confirmation of success$")
    public void gets_a_confirmation_of_success() throws Throwable
    {
        assertThat(result).isEqualTo(SUCCESS);
    }

    @And("^h(?:is|er) account balance should be (\\d+)$")
    public void his_account_balance_is(int amount) throws Throwable
    {
        CashAccount cashAccount = lunchbox.getCashAccount(identifiedUserId);
        assertThat(cashAccount.getBalance().getNumber().numberValue(Integer.class)).isEqualTo(amount);
    }

    @And("^h(?:is|er) portfolio should contain (\\d+) shares? of (\\w+)$")
    public void portfolio_should_contain_shares(int quantity, String symbol) throws Throwable
    {
        assertThat(getIdentifiedUserPortfolio().getPosition(new Symbol(symbol)).getQuantity()).isEqualTo(quantity);
    }

    @And("^h(?:is|er) portfolio contains (\\d+) shares of (\\w+)$")
    public void portfolio_contains_shares(int quantity, String symbol) throws Throwable
    {
        getIdentifiedUserPortfolio().addTransaction(new Transaction(quantity, new Symbol(symbol), Side.BUY));
    }

    @When("^s?he sells (\\d+) shares of (\\w+)$")
    public void he_sells_shares(int quantity, String symbol) throws Throwable
    {
        try
        {
            getIdentifiedUserPortfolio().addTransaction(new Transaction(quantity, new Symbol(symbol), Side.SELL));
            result = SUCCESS;
        }
        catch (InvalidTransactionException e)
        {
            result = FAILURE;
        }
    }

    private Portfolio getIdentifiedUserPortfolio()
    {
        return lunchbox.getPortfolio(identifiedUserId);
    }

    @Given("^(.+)'s portfolio contains (\\d+) shares of (\\w+)$")
    public void user_s_portfolio_contains_shares(String user, int quantity, String symbol) throws Throwable
    {
        UserId userId = lunchbox.createUser(user);
        lunchbox.getPortfolio(userId).addTransaction(new Transaction(quantity, new Symbol(symbol), Side.BUY));
    }

    @Then("^s?he should be rejected$")
    public void she_should_be_rejected() throws Throwable
    {
        assertThat(result).isEqualTo(FAILURE);
    }
}
