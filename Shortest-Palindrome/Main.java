import java.util.*;

class Solution {
    public String shortestPalindrome(String s) {
      String res = "";
      int len = s.length();

      for(int i = len - 1; i >= 0; i--) {
        int j =0;
        for(j = 0; j < i; j++) {
          if(s.charAt(j) != s.charAt(i - j)) {
            res += s.charAt(i);
            break;
          }
        }
        if (j == i) break;
      }
      return res + s;
    }
    public static void main(String[] args) {
      Solution sol = new Solution();
      System.out.println(sol.shortestPalindrome("abcd"));
    }
}