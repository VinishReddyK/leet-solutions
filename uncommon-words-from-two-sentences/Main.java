import java.util.*;

class Solution {
  public String[] uncommonFromSentences(String s1, String s2) {
    String[] words1 = s1.split("\\s+");
    String[] words2 = s2.split("\\s+");
    Map<String, Integer> wordCount = new HashMap<>();
    
    for (String word : words1) {
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }
    
    for (String word : words2) {
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }
    
    List<String> uncommonWords = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
      if (entry.getValue() == 1) {
        uncommonWords.add(entry.getKey());
      }
    }
    
    return uncommonWords.toArray(new String[0]);
    }
    
  public static void main(String[] args) {
    Solution solution = new Solution();
    String s1 = "this apple is sweet";
    String s2 = "this apple is sour";
    String[] result = solution.uncommonFromSentences(s1, s2);
    System.out.println(Arrays.toString(result)); // Output: [sweet]
  }
}