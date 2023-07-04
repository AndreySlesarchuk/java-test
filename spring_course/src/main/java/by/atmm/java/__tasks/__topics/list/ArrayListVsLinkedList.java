package by.atmm.java.__tasks.__topics.list;

import by.atmm.java.__tasks.__topics.utils.Watch;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrey Slesarchuk on 11/07/2020.
 */
public class ArrayListVsLinkedList {

  private Watch watch = new Watch();

  private static final int MAX = 500000;

  String[] strings = maxArray();

  ////////////// ADD ALL ////////////////////////////////////////
  @Test
  public void arrayListAddAll() {
    List<String> stringList = Arrays.asList(strings);
    List<String> arrayList = new ArrayList<>(MAX);

    watch.start();
    arrayList.addAll(stringList);
    watch.totalTime("Array List addAll() = ");// 101,16719 Nanoseconds
  }

  @Test
  public void linkedListAddAll() {
    List<String> stringList = Arrays.asList(strings);
    watch.start();
    List<String> linkedList = new LinkedList<>();
    linkedList.addAll(stringList);
    watch.totalTime("Linked List addAll() = "); // 2623,29291 Nanoseconds
  }

  // Note: ArrayList is 26 time faster here than LinkedList for addAll()

  ///////////////// INSERT /////////////////////////////////////////////
  @Test
  public void arrayListAdd() {
    List<String> arrayList = new ArrayList<>(MAX);
    watch.start();
    for (String string : strings)
      arrayList.add(string);
    watch.totalTime("Array List add() = ");// 152,46840 Nanoseconds
  }

  @Test
  public void linkedListAdd() {
    List<String> linkedList = new LinkedList<>();
    watch.start();
    for (String string : strings)
      linkedList.add(string);
    watch.totalTime("Linked List add() = "); // 966,62216 Nanoseconds
  }

  // Note: ArrayList is 9 times faster than LinkedList for add sequentially

  /////////////////// INSERT IN BETWEEN ///////////////////////////////////////
  @Test
  public void arrayListInsertOne() {
    List<String> stringList = Arrays.asList(strings);
    List<String> arrayList = new ArrayList<>(MAX + MAX / 10);
    arrayList.addAll(stringList);
    String insertString0 = getString(true, MAX / 2 + 10);
    String insertString1 = getString(true, MAX / 2 + 20);
    String insertString2 = getString(true, MAX / 2 + 30);
    String insertString3 = getString(true, MAX / 2 + 40);
    watch.start();
    arrayList.add(insertString0);
    arrayList.add(insertString1);
    arrayList.add(insertString2);
    arrayList.add(insertString3);
    watch.totalTime("Array List add() = ");// 36527
  }

  @Test
  public void linkedListInsertOne() {
    List<String> stringList = Arrays.asList(strings);
    List<String> linkedList = new LinkedList<>();
    linkedList.addAll(stringList);

    String insertString0 = getString(true, MAX / 2 + 10);
    String insertString1 = getString(true, MAX / 2 + 20);
    String insertString2 = getString(true, MAX / 2 + 30);
    String insertString3 = getString(true, MAX / 2 + 40);
    watch.start();
    linkedList.add(insertString0);
    linkedList.add(insertString1);
    linkedList.add(insertString2);
    linkedList.add(insertString3);
    watch.totalTime("Linked List add = ");// 29193
  }

  // Note: LinkedList is 3000 nanosecond faster than ArrayList for insert
  // randomly.

  ////////////////// DELETE
  @Test
  public void arrayListRemove() {
    List<String> stringList = Arrays.asList(strings);
    List<String> arrayList = new ArrayList<>(MAX);

    arrayList.addAll(stringList);
    String searchString0 = getString(true, MAX / 2 + 10);
    String searchString1 = getString(true, MAX / 2 + 20);

    watch.start();
    arrayList.remove(searchString0);
    arrayList.remove(searchString1);
    watch.totalTime("Array List remove() = ");// 20,56,9095 Nanoseconds
  }

  @Test
  public void linkedListRemove() {
    List<String> linkedList = new LinkedList<>();
    linkedList.addAll(Arrays.asList(strings));
    String searchString0 = getString(true, MAX / 2 + 10);
    String searchString1 = getString(true, MAX / 2 + 20);
    watch.start();
    linkedList.remove(searchString0);
    linkedList.remove(searchString1);
    watch.totalTime("Linked List remove = ");// 20,45,4904 Nanoseconds
  }

  // Note: LinkedList is 10 millisecond faster than ArrayList while removing
  // item.

  ///////////////////// SEARCH ///////////////////////////////////////////
  @Test
  public void arrayListSearch() {
    List<String> stringList = Arrays.asList(strings);
    List<String> arrayList = new ArrayList<>(MAX);
    arrayList.addAll(stringList);
    String searchString0 = getString(true, MAX / 2 + 10);
    String searchString1 = getString(true, MAX / 2 + 20);
    watch.start();
    arrayList.contains(searchString0);
    arrayList.contains(searchString1);
    watch.totalTime("Array List addAll() time = ");// 186,15,704
  }

  @Test
  public void linkedListSearch() {
    List<String> linkedList = new LinkedList<>();
    linkedList.addAll(Arrays.asList(strings));
    String searchString0 = getString(true, MAX / 2 + 10);
    String searchString1 = getString(true, MAX / 2 + 20);
    watch.start();
    linkedList.contains(searchString0);
    linkedList.contains(searchString1);
    watch.totalTime("Linked List addAll() time = ");// 189,64,981
  }

  // Note: Linked List is 500 Milliseconds faster than ArrayList

  private String[] maxArray() {
    String[] strings = new String[MAX];
    Boolean result = Boolean.TRUE;
    for (int i = 0; i < MAX; i++) {
      strings[i] = getString(result, i);
      result = !result;
    }
    return strings;
  }

  private String getString(Boolean result, int i) {
    return String.valueOf(result) + i + String.valueOf(!result);
  }
}
