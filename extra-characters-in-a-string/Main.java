import java.util.*;

class Solution {
  public int minExtraChar(String s, String[] dictionary) {
    int result = s.length();
    for (int i = 0; i < s.length(); i++) {
      int score = minExtraChar(s.substring(i + 1), dictionary);
      String cal_s = s.substring(0, i);
      if (!Arrays.asList(dictionary).contains(cal_s)) {
        score += cal_s.length();
      } 
      result = Math.min(score, result);
    }
    return result;
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.minExtraChar("leetscode", new String[]{"leet", "code", "leetcode"}));
  }
}