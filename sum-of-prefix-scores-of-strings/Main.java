class Solution {
    public static class TrieNode {
      TrieNode[] child = new TrieNode[26];
      int score = 0;
    }

    public static TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    public static void insert(String word) {
      TrieNode current = root;
      for(int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        int pos = c - 'a';
        if(current.child[pos] == null) current.child[pos] = new TrieNode();
        current = current.child[pos];
        current.score++;
      }
    }

    public static int search(String word){
      TrieNode current = root;
      int sum = 0;
      for(int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        int pos = c - 'a';
        if(current.child[pos] == null) {
          return 0;
        }
        current = current.child[pos];
        sum += current.score;
      }
      return sum;
    }

    public int[] sumPrefixScores(String[] words) {
        for (String word : words) {
            insert(word);
        }
        int[] result = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            result[i] = search(words[i]);
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
    Solution sol = new Solution();
    int[] result = sol.sumPrefixScores(new String[]{"abc","ab","bc","b"});

    for (int i : result) {
      System.out.println(i);
    }
  }
}