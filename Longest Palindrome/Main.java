class Solution {
    public static boolean isPalindrome(String s){
      int position = 0;
      while(true){
        int rightPos = s.length() - 1 - position;
        if(position == rightPos || position > rightPos)
        break;
        if(s.charAt(position) != s.charAt(rightPos))
        return false;
        position++;
      }
      return true;
    }

    public String longestPalindrome(String s) {
      for(int i = s.length() + 1; i > 1; i--) {
        int j = 0;
        while (j + i < s.length() + 1) {
          String subString = s.substring(j, j + i);
          if(isPalindrome(subString))
            return subString;
          j++;
        }
      }
      return String.valueOf(s.charAt(0));
    }
}

public class Main {
  public static void main(String[] args) {
    Solution solObj = new Solution();
    String result = solObj.longestPalindrome("ab");
    System.out.println(result);
  }
}