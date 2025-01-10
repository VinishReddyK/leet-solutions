import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class wordSubsets {
  class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        ArrayList<String> resWords = new ArrayList<String>();
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < words2.length; i++) {
            HashMap<Character, Integer> charCountMap = new HashMap<>();
            for (int j = 0; j < words2[i].length(); j++) {
                char ch = words2[i].charAt(j);
                int count = charCountMap.getOrDefault(ch, 0) + 1;
                charCountMap.put(ch, count);
                charCount.put(ch, Math.max(charCount.getOrDefault(ch, 0), count));
            }
        }
        for (int i = 0; i < words1.length; i++) {
            HashMap<Character, Integer> charCountMap = new HashMap<>();
            for (int j = 0; j < words1[i].length(); j++) {
                char ch = words1[i].charAt(j);
                int count = charCountMap.getOrDefault(ch, 0) + 1;
                charCountMap.put(ch, count);
            }
            int flag = 0;
            for (int j = 0; j < words1[i].length(); j++) {
                for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                    char ch = entry.getKey();
                    if (charCountMap.getOrDefault(ch, 0) < charCount.getOrDefault(ch, 0)) {
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 0) {
                resWords.add(words1[i]);
            }
        }
        return resWords;
    }
}
}
