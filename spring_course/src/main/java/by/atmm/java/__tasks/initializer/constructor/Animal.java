package by.atmm.java.__tasks.initializer.constructor;

public abstract class Animal {
    private final String fullName;

    {
        System.out.println("[Animal initial block]");
    }

    static {
        System.out.println("[Animal static initial block]");
    }

    protected Animal() {
        fullName = "Animal " + getName();
    }

    public String getFullName() {
        return fullName;
    }

    protected abstract String getName();
}