package by.atmm.java.__topics.collections.trees.binarysearchtree;

import java.util.Arrays;

/**
 * 2022-12-21
 */

public class TreeSort {

  public static void main(String[] args) {
    int[] arr = {50, 30, 70, 15, 7, 62, 22, 35, 87, 22, 31};
    System.out.println("Original array- " + Arrays.toString(arr));
    Tree tree = new Tree(arr[0]);
    for (int num : arr) {
      tree.insert(tree.node, num);
    }
    System.out.println("Sorted Array (Ascending)- ");
    tree.inOrder(tree.node);
    System.out.println();
    System.out.println("Sorted Array (Descending)- ");
    tree.inOrderDesc(tree.node);
  }
}
