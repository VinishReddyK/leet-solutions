import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> numOne = new HashMap<>();
        HashMap<Integer, Integer> numTwo = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums1.length; i++) {
            if(numOne.containsKey(nums1[i])) {
                numOne.put(nums1[i], numOne.get(nums1[i]) + 1);
                continue;
            }
            numOne.put(nums1[i], 1);
        }
        for(int i = 0; i < nums2.length; i++) {
            if(numTwo.containsKey(nums2[i])) {
                numTwo.put(nums2[i], numTwo.get(nums2[i]) + 1);
                continue;
            }
            numTwo.put(nums2[i], 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : numOne.entrySet()) {
            int numOneFreq = entry.getValue();
            int numTwoFreq = numTwo.getOrDefault(entry.getKey(), 0);
            if(numTwoFreq == 0) continue;

            for(int i = 0; i < Math.min(numOneFreq, numTwoFreq); i++) {
              result.add(entry.getKey());
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
      }
}

public class Main {
  public static void main(String[] args) {
   Solution obj = new Solution();
   int[] n1 = {1, 2, 2, 3}, n2 = {2, 2, 3, 4, 5};

   int[] result = obj.intersect(n1, n2);
   for (int i : result) {
    System.out.print(i + " ");
   }
  }
}