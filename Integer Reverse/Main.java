class Solution {
    public int reverse(int x) {
        long flag = x < 0 ? -1 : 1;
        x = Math.abs(x);
        long res = 0;
        long i = 1;
        long  temp = x;
        while(temp > 0) {
            temp /= 10;
            i *= 10;
        }

        while(x > 0) {
            i /= 10;
            res += (x % 10) * i;
            x /= 10;
        }
        if ( res < -1 * Math.pow(2, 31) || res > Math.pow(2, 31) - 1) {
          return 0;
        }
        return (int) (res * flag);
    }
}

public class Main {
  public static void main(String[] args) {
    Solution obj = new Solution();
    System.out.println(obj.reverse(1534236469));
  }
  
}