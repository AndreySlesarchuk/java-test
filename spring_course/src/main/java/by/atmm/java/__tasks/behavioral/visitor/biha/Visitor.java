package by.atmm.java.__tasks.behavioral.visitor.biha;

/**
 * Created by Andrey Slesarchuk on 05/25/2020.
 */
public interface Visitor {

  void action(Employee employee);

  void action(Head head);

  void action(Chairman chairman);

}
