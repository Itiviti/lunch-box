package lunchbox;

public class Symbol
{
    private final String name;

    public Symbol(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Symbol symbol = (Symbol) o;

        return !(name != null ? !name.equals(symbol.name) : symbol.name != null);

    }

    @Override
    public int hashCode()
    {
        return name != null ? name.hashCode() : 0;
    }
}
