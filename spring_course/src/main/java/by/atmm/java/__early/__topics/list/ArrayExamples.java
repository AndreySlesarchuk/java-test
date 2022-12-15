package by.atmm.java.__early.__topics.list;

import by.atmm.java.__early.__topics.utils.Watch;
import org.junit.Test;

/**
 * Created by Andrey Slesarchuk on 02/25/2021.
 *
 */
public class ArrayExamples {

  private Watch watch = new Watch();

  @Test public void arrayTwoSum() {
    int[] m1 = new int[] { 1, 2, 3, 4 };
    int t1 = 6;
    int[] m2 = new int[] { -1, 0 };
    int t2 = -1;
    watch.start();
    Solution solution = new Solution();

    watch.totalTime("Result reverse: " + solution.reverse(48) + " Time: ");
    watch.totalTime("Result runningSum : " + solution.runningSum(m1) + " Time: ");
    watch.totalTime("Result1: " + solution.twoSum1(m1, t1) + " Time: ");
    watch.totalTime("Result2: " + solution.twoSum2(m2, t2) + " Time: ");

  }



  class Solution {

    public int reverse(int x) {
      int rev = 0;
      while (x != 0) {
        int pop = x % 10;
        x /= 10;
        if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
        if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
        rev = rev * 10 + pop;
      }
      return rev;
    }

    public int[] runningSum(int[] nums) {
      int[] output = new int[nums.length];
      output[0] = nums[0];
      for (int i = 1; i < nums.length; i++) {
        output[i] = output[i - 1] + nums[i];
      }
      return output;
    }

    public int[] twoSum2(int[] nums, int target) {
      int l = nums.length - 1;
      if ((nums[0] + nums[1]) == target) {
        return new int[] { 1, 2 };
      }
      for (int i = l; i >= 0; i--) {
        if (target >= nums[i]) {
          for (int j = 0; j < i; j++) {
            if ((nums[i] + nums[j]) == target) {
              return new int[] { i + 1, j + 1 };
            }
          }
        }
      }
      return new int[] { 0, 0 };
    }

    public int[] twoSum1(int[] nums, int target) {
      for (int i = 0; i < nums.length - 1; i++) {
        for (int j = i + 1; j <= nums.length - 1; j++) {
          if ((nums[i] + nums[j]) == target) {
            return new int[] { i, j };
          }
        }
      }
      return new int[] { 0, 0 };
    }

  }

}
