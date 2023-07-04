package by.atmm.java.__tasks.__topics.list;

import by.atmm.java.__tasks.__topics.utils.Watch;

import java.util.*;

/**
 * Created by Andrey Slesarchuk on 11/08/2020.
 * https://www.codeflow.site/ru/article/java-remove-value-from-list#
 */
public class ListRemove {

  public static void removeAll1(List<Integer> list, int element) {
    while (list.contains(element)) {
      list.remove(element);
    }
  }

  public static void removeFor(List<Integer> list, int element) {
    while (list.contains(element)) {
      for (int i = 0; i < list.size(); i++) {
        if (Objects.equals(element, list.get(i))) {
          list.remove(i);
          i--;
        }
      }
    }
  }

  // Error ConcurrentModificationException
  public static void removeForEach(List<Integer> list, int element) {
    for (Integer number : list) {
      if (Objects.equals(number, element)) {
        list.remove(number);
      }
    }
  }

  public static void removeWithIterator(List<Integer> list, int element) {
    for (Iterator<Integer> i = list.iterator(); i.hasNext();) {
      Integer number = i.next();
      if (Objects.equals(number, element)) {
        i.remove();
      }
    }
  }

  public static void main(String[] args) {
    Watch watch = new Watch();
    List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    int valueToRemove = 8;
    watch.start();
    removeFor(list1, valueToRemove);
    watch.totalTime("List removeFor time = "); // 1 - 333 260 107 243 642, 2 -
                                               // 333 674 579 937 381
    System.out.println("First - " + Optional.ofNullable(list1.toString()).orElse("nothing"));

    List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    watch.start();
    removeWithIterator(list2, valueToRemove);
    watch.totalTime("List removeWithIterator time = "); // 1 - 334 319 733 627
    
    System.out.println("Second - " + Optional.ofNullable(list2.toString()).orElse("nothing"));

    // list = new ArrayList<>(Arrays.asList(4, 5, 6));
    // removeAll2(list, valueToRemove);
    // System.out.println("Second - " + list.toString());

    // then
    // assertThat(list).isEqualTo(list(2, 3));
  }

}
