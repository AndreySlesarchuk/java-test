package by.atmm.java.__early.initializer;

public class ConstructorTest {
    public static void main(String[] args) {
        Animal animal = new Dog();
        //Dog dog = new Dog();

        System.out.println(animal.getFullName());
        //System.out.println(dog.getName());
    }
}
