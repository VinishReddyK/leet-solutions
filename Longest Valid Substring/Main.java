// Fails 13 Cases
import java.util.List;

class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        int maxLength = 0;
        for(int i = 0; i < word.length(); i++) {
            break_twice: {
              for (int j = i + 1; j < word.length() + 1; j++) {
                String s = word.substring(i, j);
                if (s.length() < maxLength) continue;
                for (String f : forbidden) {
                  if (s.contains(f)) {
                    break break_twice;
                  }
                }
                maxLength = Math.max(maxLength, s.length());
              }
            }
        }
        return maxLength;
    }
}
        