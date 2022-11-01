package by.atmm.java.__early.initializer;

public class Dog extends Animal
{
    {
        System.out.println("[Dog initial block]");
    }

    static {
        System.out.println("[Dog static initial block]");
    }

    private String thisName = "DDog";

    protected String getName()
    {
        return thisName;
    }
}
