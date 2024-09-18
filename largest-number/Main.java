class Solution {
    public String largestNumber(int[] nums) {
      String[] strNums = new String[nums.length];
      for (int i = 0; i < nums.length; i++) {
        strNums[i] = String.valueOf(nums[i]);
      }
      
      for (int i = 0; i < strNums.length - 1; i++) {
            for (int j = 0; j < strNums.length - 1 - i; j++) {
                if ((strNums[j + 1] + strNums[j]).compareTo(strNums[j] + strNums[j + 1]) > 0) {
                    String temp = strNums[j];
                    strNums[j] = strNums[j + 1];
                    strNums[j + 1] = temp;
                }
            }
        }
      
      StringBuilder sb = new StringBuilder();

      for (int i = 0; i < strNums.length; i++) {
        sb.append(strNums[i]);
      }
      return sb.toString().replaceAll("^0+", "0");
    }
    public static void main(String[] args) {
      Solution solution = new Solution();
      // int[] nums = {10, 2};
      int[] nums = {0, 0}; // Output: 0
      System.out.println(solution.largestNumber(nums)); // Output: 210
    }
}