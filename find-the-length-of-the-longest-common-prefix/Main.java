import java.util.HashSet;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int max = 0;
        HashSet<Integer> arr1Set = new HashSet<Integer>();

        for(int i = 0; i < arr1.length; i++) {
          int num = arr1[i];
          while (num > 0) {
            arr1Set.add(num);
            num /= 10;
          }
        }
        for(int i = 0; i < arr2.length; i++) {
          int num = arr2[i];
          while (num > 0) {
            if(arr1Set.contains(num)) {
              max = Math.max(max, Integer.toString(num).length());
            }
            num /= 10;
          }
        }
        
        return max;
    }
    public static void main(String[] args) {
      Solution sol = new Solution();
      System.out.println(sol.longestCommonPrefix(new int[]{1, 10, 100}, new int[]{1000}));
    }
}