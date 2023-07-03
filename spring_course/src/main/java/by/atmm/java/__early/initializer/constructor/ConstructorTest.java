package by.atmm.java.__early.initializer.constructor;

public class ConstructorTest {
    public static void main(String[] args) {
        Animal animal = new Dog();
        System.out.println("-----------------------------------------------");
        Dog dog = new Dog();
        System.out.println("-----------------------------------------------");
        System.out.println(animal.getFullName());
        System.out.println(dog.getName());
    }
}
