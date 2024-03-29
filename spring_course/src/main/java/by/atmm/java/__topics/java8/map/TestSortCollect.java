package by.atmm.java.__topics.java8.map;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Andrey Slesarchuk on 11/03/2020.
 */
public class TestSortCollect {

  public static void main(String[] args) {

    List<Hosting> list = new ArrayList<>();
    list.add(new Hosting(1, "liquidweb.com", 80000));
    list.add(new Hosting(2, "linode.com", 90000));
    list.add(new Hosting(3, "digitalocean.com", 120000));
    list.add(new Hosting(4, "aws.amazon.com", 200000));
    list.add(new Hosting(5, "mkyong.com", 1));
    list.add(new Hosting(6, "linode.com", 100000));

    // example 1
    Map result1 = list.stream().sorted(Comparator.comparingLong(Hosting::getWebsites).reversed())
        .collect(Collectors.toMap(
            Hosting::getName, Hosting::getWebsites, // key = name, value = websites
            (oldValue, newValue) -> oldValue, // if same key, take the old key
            LinkedHashMap::new // returns a LinkedHashMap, keep order
        ));

    System.out.println("Result 1 : " + result1);

  }

}