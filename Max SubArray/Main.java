import java.util.*;

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int mid = nums.length / 2;
        int left = maxSubArray(Arrays.copyOfRange(nums, 0, mid));
        int right = maxSubArray(Arrays.copyOfRange(nums, mid, nums.length));

        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = mid - 1; i >= 0; i--) {
            sum += nums[i];
            if(maxLeft < sum) {
                maxLeft = sum;
            }
        }
        sum = 0;
        for(int i = mid; i < nums.length; i++) {
            sum += nums[i];
            if(maxRight < sum) {
                maxRight = sum;
            }
        }
        return Math.max(maxLeft + maxRight, Math.max(left, right));
    }
}

public class Main {
  public static void main(String[] args) {
    Solution obj = new Solution();
    int[] input = {-2,-1};
    System.out.println(obj.maxSubArray(input));
  }
}