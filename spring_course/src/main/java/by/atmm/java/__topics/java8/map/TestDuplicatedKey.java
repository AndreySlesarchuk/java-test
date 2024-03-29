package by.atmm.java.__topics.java8.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Andrey Slesarchuk on 11/03/2020.
 */
public class TestDuplicatedKey {

  public static void main(String[] args) {

    List<Hosting> list = new ArrayList<>();
    list.add(new Hosting(1, "liquidweb.com", 80000));
    list.add(new Hosting(2, "linode.com", 90000));
    list.add(new Hosting(3, "digitalocean.com", 120000));
    list.add(new Hosting(4, "aws.amazon.com", 200000));
    list.add(new Hosting(5, "mkyong.com", 1));

    list.add(new Hosting(6, "linode.com", 100000)); // new line

    // key = name, value - websites , but the key 'linode' is duplicated!?
    Map<String, Long> result1 = list.stream().collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites, (oldValue, newValue) -> oldValue));

    System.out.println("Result 1 : " + result1);

  }
}