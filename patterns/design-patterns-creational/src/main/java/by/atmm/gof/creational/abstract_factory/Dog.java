package by.atmm.gof.creational.abstract_factory;

public class Dog implements Animal {
    @Override
    public String getType() {
        return "Dog";
    }

    @Override
    public String makeSound() {
        return "Woff";
    }

}