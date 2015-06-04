package lunchbox;

public class UserId
{
    private final String name;

    public UserId(String name)
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

        UserId userId = (UserId) o;

        return !(name != null ? !name.equals(userId.name) : userId.name != null);

    }

    @Override
    public int hashCode()
    {
        return name != null ? name.hashCode() : 0;
    }
}
