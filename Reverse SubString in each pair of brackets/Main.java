import java.util.*;

class Solution {
    public String reverseParentheses(String s) {
        char[] sArr = ("((" + s + "))").toCharArray();
        ArrayList<Character> string = new ArrayList<>();

        int i = 0;
        boolean flag = true;
        while (true) {
          i++;
          while(i < sArr.length && sArr[i] != '(' && sArr[i] != ')') {
            if(flag)
            string.addLast(sArr[i]);
            else
            string.addFirst(sArr[i]);
            i++;
          }

          flag = !flag;
          if(i >= sArr.length) {
            break;
          }
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : string) {
            sb.append(ch);
        }

        return sb.toString();
    }
}

public class Main {
  public static void main(String[] args) {
    String input = "(u(love)i)";
    Solution obj =  new Solution();
    System.out.println(obj.reverseParentheses(input));
  }  
}
