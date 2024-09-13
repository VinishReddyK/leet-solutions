import java.util.Arrays;

class Solution {
  public int[] xorQueries(int[] arr, int[][] queries) {
    int[] result = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int xorResult = 0;
      for (int j = queries[i][0]; j <= queries[i][1]; j++) {
        xorResult ^= arr[j];
      }
      result[i] = xorResult;
    }
    return result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] res = solution.xorQueries(new int[]{1,3,4,8}, new int[][]{{0,1},{1,2},{0,3},{3,3}});
    System.out.println(Arrays.toString(res)); // Output: [2,7,14,8]
  }
}
