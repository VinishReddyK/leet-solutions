import java.util.*;

class Main{
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] timeints = new int[n];
        for (int i = 0; i < n; i++) {
            String[] time = timePoints.get(i).split(":");
            timeints[i] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        }
        Arrays.sort(timeints);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, timeints[i] - timeints[i - 1]);
        }

        if(Math.abs(timeints[0] - timeints[n - 1]) > 720) {
            minDiff = Math.min(minDiff, Math.abs(Math.abs(timeints[0] - timeints[n - 1]) - 1440));
        }
        
        return minDiff;
    }
    public static void main(String[] args) {
        Main main = new Main();
        List<String> timePoints = Arrays.asList("05:31", "22:00", "00:00");
        System.out.println(main.findMinDifference(timePoints)); // Output: 827
    }
}