package by.atmm.java.aop;

import org.springframework.stereotype.Component;

/**
 * @author Andrey Slesarchuk
 * @date 2022-06-14
 */

@Component
public abstract class AbstractLibrary {

    String name;

    public abstract void getBook();

}
