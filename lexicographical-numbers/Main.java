import java.util.*;

class Solution {
    public List<Integer> lexicalOrder(int n) {
    int k = 1;
    List<Integer> res = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      res.add(k);
      if (k * 10 <= n) {
          k *= 10;
      } else {
          if (k >= n) k /= 10;
          k += 1;
          while (k % 10 == 0) k /= 10;
        }
      }
      return res;
    }
    public static void main(String[] args) {
      Solution sol = new Solution();
      System.out.println(sol.lexicalOrder(200).toString());
    }
}