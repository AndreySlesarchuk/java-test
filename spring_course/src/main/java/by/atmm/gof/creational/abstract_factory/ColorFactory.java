package by.atmm.gof.creational.abstract_factory;

public class ColorFactory implements AbstractFactory<Color> {

    @Override
    public Color create(String color) {
            return new Color();

    }

}