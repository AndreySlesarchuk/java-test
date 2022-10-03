package by.atmm.creational.abstractfactory;

public interface AbstractFactory<T> {
    T create(String type) ;
}