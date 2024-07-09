import java.util.*;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] charArray = s.toCharArray();
        int sum = 0;
        for(int i = 0; i < charArray.length; i++) {
            if(i + 1 < charArray.length){
                if(charArray[i] == 'I') {
                    if(charArray[i + 1] == 'V'){
                        sum += 4;
                        i++;
                        continue;
                    }
                    if(charArray[i + 1] == 'X'){
                        sum += 9;
                        i++;
                        continue;
                    }
                }
                if(charArray[i] == 'X') {
                    if(charArray[i + 1] == 'L'){
                        sum += 40;
                        i++;
                        continue;
                    }
                    if(charArray[i + 1] == 'C'){
                        sum += 90;
                        i++;
                        continue;
                    }
                }
                if(charArray[i] == 'C') {
                    if(charArray[i + 1] == 'D'){
                        sum += 400;
                        i++;
                        continue;
                    }
                    if(charArray[i + 1] == 'M'){
                        sum += 900;
                        i++;
                        continue;
                    }
                }
            }
            sum += map.get(charArray[i]);
        }

        return sum;
    }
}

public class Main {
  public static void main(String[] args) {
    String input = "MCMXCIV";
    Solution obj = new Solution();
    System.out.println(obj.romanToInt(input));
  }
}