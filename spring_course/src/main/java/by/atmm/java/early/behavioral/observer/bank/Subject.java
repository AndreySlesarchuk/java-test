package by.atmm.java.early.behavioral.observer.bank;

/**
 * Created by Andrey Slesarchuk on 07/26/2020.
 */
public interface Subject {
  //methods to register and unregister observers
  void register(Observer obj);

  void unregister(Observer obj);

  //method to notify observers of change
  void notifyObservers();
}
