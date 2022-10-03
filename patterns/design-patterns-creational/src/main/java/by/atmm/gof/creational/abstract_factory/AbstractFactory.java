package by.atmm.gof.creational.abstract_factory;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-26
 */

public interface AbstractFactory<T> {
    T create(String type);
}