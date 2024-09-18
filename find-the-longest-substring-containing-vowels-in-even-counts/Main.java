import java.util.*;

class Solution {
    public int findTheLongestSubstring(String s) {
      HashMap<Integer, Integer> state = new HashMap<Integer, Integer>();

      state.put(0, -1);

      int maxLength = 0;
      int binary = 0;

      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if(c == 'a') {
          binary ^= 1 << 0;
        } else if(c == 'e') {
          binary ^= 1 << 1;
        } else if(c == 'i') {
          binary ^= 1 << 2;
        } else if(c == 'o') {
          binary ^= 1 << 3;
        } else if(c == 'u') {
          binary ^= 1 << 4;
        }

        if (!state.containsKey(binary)) {
          state.put(binary, i);
        } else {
          maxLength = Math.max(maxLength, i - state.get(binary));
        }
      }

      return maxLength;
    }
    
    public static void main(String[] args) {
      Solution solution = new Solution();
      System.out.println(solution.findTheLongestSubstring("eleetminicoworoep")); // Output: 13
    }
}