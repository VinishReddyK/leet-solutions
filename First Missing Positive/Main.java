class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        for(int i = 0; i < n; i++) {
            int abs = Math.abs(nums[i]);
            if(abs <= n) {
                if(nums[abs - 1] > 0) nums[abs - 1] *= -1;
            }
        }

        for(int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] input = {1,1};
        System.out.println(obj.firstMissingPositive(input));
    }   
    
}