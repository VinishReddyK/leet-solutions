import java.util.*;

class Solution {
    public static LinkedList<Integer> numToString(String num) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            result.add(Character.getNumericValue(num.charAt(i)));
        }
        return result;
    }

    public static LinkedList<Integer> singleDigitMultiply(LinkedList<Integer> num, int digit) {
        int carry = 0;

        LinkedList<Integer> result = new LinkedList<>();

        for(int i = num.size() - 1; i >= 0; i--) {
            int product = digit * num.get(i) + carry;
            result.addFirst(product % 10);
            carry = (product / 10);
        }
        if(carry != 0) {
            result.addFirst(carry);
        }
        return result;
    }

    public static LinkedList<Integer> addTwoNumbers(LinkedList<Integer> num1, LinkedList<Integer> num2, int index) {
        int carry = 0;
        if(num1.getFirst() == 0 && num1.size() == 1) {
          return num2;
        }
        for(int i = 0; i < index; i++) {
          num2.add(0);
        }

        LinkedList<Integer> result = new LinkedList<>();

        int a = num1.size();
        int b = num2.size();

        for(int i = a < b ? a : b; i >0; i--) {
            a--;
            b--;
            int sum = num1.get(a) + num2.get(b) + carry;
            result.addFirst(sum % 10);
            carry = sum / 10;
        }
        a--;
        b--;
        for(int i = a; i >= 0; i--) {
            int sum = num1.get(a) + carry;
            result.addFirst(sum % 10);
            carry = sum / 10;
        }
        for(int i = b; i >= 0; i--) {
            int sum = num2.get(i) + carry;
            result.addFirst(sum % 10);
            carry = sum / 10;
        }
        if(carry != 0) {
            result.addFirst(carry);
        }
        num2.removeLast();
        return result;
    }

    public String multiply(String num1, String num2) {
        LinkedList<Integer> numOne = numToString(num1);
        LinkedList<Integer> numTwo = numToString(num2);
        LinkedList<Integer> sum = new LinkedList<>();
        sum.add(0);
        int buffer = 0;
        for (int i = numTwo.size() - 1; i >= 0; i--) {
          if(numTwo.get(i) == 0){ 
            if(numTwo.getFirst() != 0 && sum.getFirst() != 0 && sum.size() > 1){ 
              sum.addFirst(0);
            }
            if(sum.getFirst() == 0 && sum.size() == 1) {
              buffer++;
            }
          }
          else sum = addTwoNumbers(sum, singleDigitMultiply(numOne, numTwo.get(i)), numTwo.size() -1 - buffer - i);
        }
        for (int i = numTwo.size() - 1; i >= 0; i--) {
          if(numTwo.get(i) != 0 || sum.getFirst() == 0){
            break;
          }
          sum.add(0);
        }
        
        String result = "";

        for (Integer integer : sum) {
          result += Integer.toString(integer);
        }
        return result;
    }
}

public class Main {
  public static void main(String[] args) {
   Solution obj = new Solution();
   System.out.println(obj.multiply("6", "5010"));
  }
}