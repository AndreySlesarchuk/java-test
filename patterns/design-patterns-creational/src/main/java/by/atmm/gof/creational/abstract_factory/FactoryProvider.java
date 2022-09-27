package by.atmm.gof.creational.abstract_factory;

public class FactoryProvider {

    private FactoryProvider() {
        throw new IllegalStateException("Utility class");
    }

    public static AbstractFactory getFactory(String choice){

        if("Toy".equalsIgnoreCase(choice)){
            return new AnimalFactory();
        }
        else if("Color".equalsIgnoreCase(choice)){
            return new ColorFactory();
        }

        return null;
    }
}