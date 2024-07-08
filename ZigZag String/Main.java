
class Solution {
    public String convert(String s, int numRows) {
      String result = "";
      char[] charArray = s.toCharArray();
      if(numRows == 1) {
        return s;
      }
      for(int i = 0; i < charArray.length; i += numRows + numRows-2) {
        result += charArray[i];
      }

      if(numRows > 2) {
        for(int i = 1; i < numRows - 1; i++) {
          if (charArray.length < i + 1) break;
          result += charArray[i];
          for( int j = i + numRows + numRows - 2*(i+1); j < charArray.length; j += numRows + numRows - 2*(i + 1)) {
            result += charArray[j];
            j += 2*(i);
            if(j < charArray.length)  result += charArray[j];
          }
        }
      }

      for(int i = numRows - 1; i < charArray.length && i >= 0; i += numRows + numRows - 2) {
        result += charArray[i];
      }
      return result;
    }
} 

public class Main {
  public static void main(String[] args) {
    Solution obj = new Solution();
    System.out.println(obj.convert("A", 3));
  }
}