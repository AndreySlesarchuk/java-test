package by.atmm.gof.behavioral.observer.myobservable;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Andrey Slesarchuk on 07/26/2020.
 */
public class ObservableClass {

  public static void main(String[] args) {
    Subject subject = new Subject();
    Subscriber1 observer1 = new Subscriber1();
    subject.addObserver(observer1);
    Observer su3 = new Subscriber2();
    subject.addObserver(new Subscriber2());
    subject.addObserver(su3);
    subject.setChanged();
    subject.notifyObservers("Hi worlds!");
    subject.deleteObserver(su3);
    subject.setChanged();
    subject.notifyObservers("Hello All!");
  }

  static class Subject extends Observable {
    @Override
    protected synchronized void setChanged() {
      super.setChanged(); // changed = true;
    }
  }
}

class Subscriber1 implements Observer {
  @Override
  public void update(Observable o, Object arg) {
    System.out.println("s1 " + arg);
  }
}

class Subscriber2 implements Observer {
  @Override
  public void update(Observable o, Object arg) {
    System.out.println("s2 " + arg);
  }
}
