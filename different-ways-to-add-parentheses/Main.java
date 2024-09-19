import java.util.*;

class Solution {
    public static int applyOp(int a, int b, String op){
        switch(op){
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: 
              System.out.println("Invalid operator"); 
              return 0;
        }
    }

    public List<Integer> diffWaysToCompute(String expression) {
      List<Integer> results = new ArrayList<>();
      if (expression.matches("\\d+")) {
        results.add(Integer.parseInt(expression));
        return results;
      }

      for (int i = 0; i < expression.length(); i++) {
        if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/') {
          for (int left : diffWaysToCompute(expression.substring(0, i))) {
            for (int right : diffWaysToCompute(expression.substring(i + 1))) {
              results.add(applyOp(left, right, Character.toString(expression.charAt(i))));
            }
          }
        }
      }
      return results;
    }

    public static void main(String[] args) {
      Solution solution = new Solution();
      List<Integer> sol = solution.diffWaysToCompute("2*3-4*5");
      System.out.println(sol.toString());
    }
}