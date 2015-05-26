package lunchbox;

public class Transaction
{
    private final int quantity;
    private final Symbol symbol;
    private final Side side;

    public Transaction(int quantity, Symbol symbol, Side side)
    {
        this.quantity = quantity;
        this.symbol = symbol;
        this.side = side;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public Symbol getSymbol()
    {
        return symbol;
    }

    public Side getSide()
    {
        return side;
    }
}
