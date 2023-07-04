package by.atmm.java.__tasks.behavioral.observer.myobservable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey Slesarchuk on 07/26/2020.
 */
public class MyClass {

  public static void main(String[] args) {
    Subject subject = new Subject();
    Subscriber1 myObservable = new Subscriber1();
    subject.subscribe(myObservable);
    MyObservable su3 = new Subscriber2();
    subject.subscribe(new Subscriber2());
    subject.subscribe(su3);
    subject.notifySubscribers("Hello worlds!");
    subject.unsubscribe(myObservable);
    subject.notifySubscribers("Hello All!");
  }

  interface MyObservable {
    void callMe(String msg);
  }

  static class Subject {
    List<MyObservable> list = new ArrayList<>();

    public void subscribe(MyObservable myObservable) {
      list.add(myObservable);
    }

    public void unsubscribe(MyObservable myObservable) {
      list.remove(myObservable);
    }

    public void notifySubscribers(String msg) {
      list.forEach(item -> item.callMe(msg));
    }
  }

  static class Subscriber1 implements MyObservable {
    @Override
    public void callMe(String msg) {
      System.out.println("s1 " + msg);
    }
  }

  static class Subscriber2 implements MyObservable {
    @Override
    public void callMe(String msg) {
      System.out.println("s2 " + msg);
    }
  }

}
