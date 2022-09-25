package by.atmm.gof.creational.abstract_factory;

public interface AbstractFactory<T> {
    T create(String animalType);
}