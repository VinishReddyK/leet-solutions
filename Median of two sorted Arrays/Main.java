class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        boolean even = (length % 2 == 0);
        int mid = even ? length / 2 - 1: length / 2;

        double[] arr = new double[length];
        int a = 0, b = 0;
        for(int i = 0; i < length; i++) {
            if(a < nums1.length && b < nums2.length) {
                if(nums1[a] <= nums2[b]) {
                    arr[i] = nums1[a];
                    a++;
                } else {
                    arr[i] = nums2[b];
                    b++;                    
                }
            } else if(a < nums1.length) {
                arr[i] = nums1[a];
                    a++;
            } else {
                arr[i] = nums2[b];
                b++;
            }
        }
        
        if(even) {
            return (arr[mid] + arr[mid + 1]) / 2;
        } else {
            return arr[mid];
        }
    }
}

public class Main {
  public static void main(String[] args) {
    Solution obj = new Solution();
    int[] a = {1, 2}, b = {3, 4};
    System.out.println("Median : " + obj.findMedianSortedArrays(a, b));
  }
}