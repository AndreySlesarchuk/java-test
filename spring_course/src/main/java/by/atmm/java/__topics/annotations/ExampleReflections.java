package by.atmm.java.__topics.annotations;


import org.reflections.Reflections;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Andrey Slesarchuk on 12/18/2020.
 */
public class ExampleReflections {
  private static final Home HOME = new Home();

  public static void main(String[] args) {

    Reflections reflections = new Reflections("by.atmm.java.early.other.annotations");

    Set<Class<?>> superCats = reflections.getTypesAnnotatedWith(SuperCat.class);

    for (Class<?> clazz : superCats) {
      toCat(clazz).ifPresent(Cat::meow);
    }
  }

  private static Optional<Cat> toCat(Class<?> clazz) {
    try {
      return Optional.of((Cat) clazz.getDeclaredConstructor(Home.class).newInstance(HOME));
    }
    catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }
}