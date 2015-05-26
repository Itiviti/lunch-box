package lunchbox;

import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;
import javax.money.MonetaryCurrencies;
import java.math.BigDecimal;

public class CashAccount
{
    public MonetaryAmount getBalance()
    {
        return Money.of(BigDecimal.ZERO, MonetaryCurrencies.getCurrency("EUR"));
    }
}
