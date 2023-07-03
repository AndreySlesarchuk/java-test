package by.atmm.java.__early.initializer.constructor;

import by.atmm.java.__early.initializer.constructor.Animal;

public class Dog extends Animal {
    {
        System.out.println("[Dog initial block]");
    }

    static {
        System.out.println("[Dog static initial block]");
    }

    private String thisName = "Dog";

    protected String getName() {
        return thisName;
    }
}
