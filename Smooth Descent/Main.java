class Solution {
    public long getDescentPeriods(int[] prices) {
      int smoothLength = 1;
      long sum = 1;
      for(int i = 0; i < prices.length; i++) {
        if(i == 0) continue;
        if(prices[i - 1] == prices[i] + 1) {
          smoothLength++;
        } else {
          smoothLength = 1;
        }
        sum += smoothLength;
      }
      return sum;
    }
}

public class Main {
  public static void main(String[] args) {
    Solution obj = new Solution();
    int[] input = {12,11,10,9,8,7,6,5,4,3,4,3,10,9,8,7};
    System.out.println(obj.getDescentPeriods(input));
  }
}