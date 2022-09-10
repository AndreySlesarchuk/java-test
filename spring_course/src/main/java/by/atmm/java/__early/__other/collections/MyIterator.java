package by.atmm.java.__early.__other.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyIterator {

  public static void main(String[] args) {
    List<String> states = new ArrayList<String>();
    states.add("Германия");
    states.add("Франция");
    states.add("Италия");
    states.add("Испания");

    Iterator<String> iter = states.iterator();
    while(iter.hasNext())
      System.out.println(iter.next());
  }
}
