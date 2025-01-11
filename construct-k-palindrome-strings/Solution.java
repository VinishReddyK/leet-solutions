class Solution {
    public boolean canConstruct(String s, int k) {
        int doubles = 0;
        int singles = 0;
        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';

            counts[index]++;
        }

        for (int count : counts) {
            doubles += count / 2;
            singles += count % 2;
        }

        if (singles <= k) {
            if (singles + doubles > k) {
                return true;
            } else {
                int diff = k - singles - doubles;
                if (diff <= doubles)
                    return true;
            }
        }

        return false;
    }
}