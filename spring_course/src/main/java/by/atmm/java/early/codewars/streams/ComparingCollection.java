package by.atmm.java.early.codewars.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * Примеры работы методов Stream Api
 *
 * Created by vedenin on 2021-09-24
 */
public class ComparingCollection {
  // Сравнение коллекция
  private static void testBuildStream() throws Exception {
    System.out.println("Test buildStream start");
    Set<Long> s1 = new HashSet<>(Arrays.asList(25L, 13L,55L, 11L));
    Long[] array2 = {24l, 13l,54l, 74l};
    Set<Long> s2 = new HashSet<>(Arrays.asList(array2));

    Set<Long> result = new HashSet<>();
    System.out.println("S1 = " + s1); // напечатает streamFromArrays = [a1, a2, a3]
    //s1.retainAll(s2);
    System.out.println("S2 = " + s2); // напечатает streamFromArrays = [a1, a2, a3]

    Set union = Stream.concat(s1.stream(),s2.stream()).collect(Collectors.toSet());
    Set intersect = s1.stream().filter(s2::contains).collect(Collectors.toSet());
    s1.removeIf(s -> intersect.contains(s));
    s2.removeIf(s -> intersect.contains(s));

    System.out.println("union all = " + union);
    System.out.println("intersection all = " + intersect);
    System.out.println("notIntersect S1 = " + s1);
    System.out.println("notIntersect S2 = " + s2);

  }

  public static void main(String[] args)  throws Exception {
    testBuildStream();
  }


}