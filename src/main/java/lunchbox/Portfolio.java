package lunchbox;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Portfolio
{
    private final CopyOnWriteArrayList<Transaction> transactions = new CopyOnWriteArrayList<>();

    public Position getPosition(Symbol symbol)
    {
        Collector<Transaction, ?, Integer> collector = Collectors.summingInt((Transaction t) -> t.getSide() == Side.BUY ? t.getQuantity() : -t.getQuantity());
        int sum = transactions.stream().filter(t -> t.getSymbol().equals(symbol)).collect(collector);
        return new Position(sum);
    }

    public void addTransaction(Transaction transaction) throws InvalidTransactionException
    {
        if (transaction.getSide() == Side.SELL)
        {
            Symbol symbol = transaction.getSymbol();
            Position positionBefore = getPosition(symbol);
            if (positionBefore.getQuantity() < transaction.getQuantity())
            {
                throw new InvalidTransactionException("not enough share available");
            }
        }
        transactions.add(transaction);
    }
}
