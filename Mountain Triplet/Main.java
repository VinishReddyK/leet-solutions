// import java.util.*;

// SOLUTION ONE
// class Solution {
//   public int minimumSum(int[] nums) {
//     ArrayList<Integer> Nums = new ArrayList<>();
//         for (int number : nums) {
//             Nums.add(number);
//         }
//     int minSum = Integer.MAX_VALUE;
//     for(int i = 0; i < Nums.size() - 2; i++) {
//       for(int j = i+1; j < Nums.size() - 1; j++) {
//         for(int k = j+1; k < Nums.size(); k++) {
//           if(Nums.get(j) > Nums.get(k) && Nums.get(j) > Nums.get(i)) {
//             int tempSum = Nums.get(i) + Nums.get(j) + Nums.get(k);
//             if(minSum > tempSum) {
//               minSum = tempSum;
//             }
//           }
//         }
//       }
//     }

//     if(minSum == Integer.MAX_VALUE) {
//       return -1;
//     }
//     System.out.println(minSum);
//     return (int) minSum;
//   }
// }

// SOLUTION TWO
// class MinHeapSortWithIndices {
//     static class IndexedValue {
//         int value;
//         int originalIndex;

//         public IndexedValue(int value, int originalIndex) {
//             this.value = value;
//             this.originalIndex = originalIndex;
//         }
//     }

//     public int[][] minHeapSortWithIndices(int[] arr) {
//         IndexedValue[] indexedArr = new IndexedValue[arr.length];
//         for (int i = 0; i < arr.length; i++) {
//             indexedArr[i] = new IndexedValue(arr[i], i);
//         }

//         PriorityQueue<IndexedValue> minHeap = new PriorityQueue<>(
//             arr.length, 
//             (a, b) -> {
//                 if (a.value == b.value) {
//                     return b.originalIndex - a.originalIndex;
//                 }
//                 return a.value - b.value;
//             }
//         );
//         Collections.addAll(minHeap, indexedArr);

//         int[][] result = new int[arr.length][2];
//         int index = 0;
//         while (!minHeap.isEmpty()) {
//             IndexedValue iv = minHeap.poll();
//             result[index][0] = iv.value;
//             result[index][1] = iv.originalIndex;
//             index++;
//         }

//         return result;
//       }
// }

// class Solution {
//   public int minimumSum(int[] nums) {
//     ArrayList<Integer> Nums = new ArrayList<>();
//         for (int number : nums) {
//             Nums.add(number);
//         }
//     MinHeapSortWithIndices obj = new MinHeapSortWithIndices();
//     int[][] sortedArray = obj.minHeapSortWithIndices(nums);
//     for (int[] is : sortedArray) {
//       System.out.println(is[0] + " " + is[1]);
//     }
//     int minimum = Integer.MAX_VALUE;
//     LinkedList<LinkedList<Integer>> triplet = new LinkedList<>();
//     triplet.add(new LinkedList<>());
//     triplet.add(new LinkedList<>());
//     triplet.add(new LinkedList<>());

//     for(int i = 0; i < Nums.size(); i++) {
//       for(int j = 0; j < i; j++){
//         if(i == j) continue;
//         for(int k = j+1; k < i; k++) {
//           if(k == j || k == i) continue;
//           triplet.get(0).clear();
//           triplet.get(1).clear();
//           triplet.get(2).clear();
//           triplet.get(0).add(sortedArray[j][0]);
//           triplet.get(1).add(sortedArray[k][0]);
//           triplet.get(2).add(sortedArray[i][0]);
//           triplet.get(0).add(sortedArray[j][1]);
//           triplet.get(1).add(sortedArray[k][1]);
//           triplet.get(2).add(sortedArray[i][1]);
//           for(int l = 0; l < 3; l++) {
//             for(int m = 0; m < 3; m++) {
//               if(m == l) continue;
//               for(int n = 0; n < 3; n++) {
//                 if(n == l || n == m) continue;
//                 if (triplet.get(l).get(1) < triplet.get(m).get(1) &&
//                     triplet.get(m).get(1) < triplet.get(n).get(1) &&
//                     triplet.get(l).get(0) < triplet.get(m).get(0) &&
//                     triplet.get(m).get(0) > triplet.get(n).get(0)) {

//                     int tempMin = triplet.get(l).get(0) + triplet.get(m).get(0) + triplet.get(n).get(0);
//                     if (tempMin < minimum) {
//                         minimum = tempMin;
//                     }
//                 }
//               }
//             }
//           }
//           if(minimum != Integer.MAX_VALUE) return minimum;
//         }
//       }
//     }
//     return -1;
//   }
// }


class Solution {
  public int minimumSum(int[] nums) {
    int[] past = new int[nums.length];
    int[] future = new int[nums.length];
    int min = nums[0];
    for(int i = 1; i < nums.length - 1; i++) {
      past[i] = min;
      if(nums[i] <= min) {
        min = nums[i];
      } 
    }
    
    min = nums[nums.length - 1];
    for(int j = nums.length - 2; j >= 1; j--) {
      future[j] = min;
      if(nums[j] <= min) {
        min = nums[j];
      }
    }

    min = Integer.MAX_VALUE;

    for(int i = 1; i < nums.length - 1; i++) {
      if(!(past[i] < nums[i] && future[i] < nums[i])) continue;
      int tempSum = nums[i] + past[i] + future[i];
      if(min > tempSum) {
        min = tempSum;
      }
    }

    return min == Integer.MAX_VALUE? -1: min;
  }
}

public class Main {

  public static void main(String[] args) {
    Solution solObj = new Solution();
    int[] nums = {8,6,1,5,3};
    System.out.println(solObj.minimumSum(nums));
  }
}