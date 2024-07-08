import java.util.*;

class Solution {
    public List<String> getResult(String s, int open, int close) {
        List<String> result = new ArrayList<>();
        if(open == 0 && close == 0) {
            result.add(s);
            return result;
        }
        if(open > 0) {
            result.addAll(getResult(s + "(", open - 1, close));
        }
        if(close > 0 && close > open) {
            result.addAll(getResult(s + ")", open, close - 1));
        }
        return result;
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = getResult("", n, n);
        return result;
    }
}

public class Main {
  public static void main(String[] args) {
    Solution obj = new Solution();
    
    List<String> res = obj.generateParenthesis(3);
    for(int i = 0; i < res.size(); i++) {
        System.out.println(res.get(i));
    }
  }
}