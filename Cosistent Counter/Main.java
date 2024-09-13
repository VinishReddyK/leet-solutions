class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
      int count = 0;
      for (String word : words) { 
        int flag = 0;
        for (char c : word.toCharArray()) {
          if (!allowed.contains(String.valueOf(c))) {
            flag = 1;
              break;
          }
        }
        if (flag == 0)
        count++;
      }
      return count;
    }

    public static void main(String[] args) {
      Solution solution = new Solution();
      System.out.println(solution.countConsistentStrings("ab", new String[]{"ad","bd","aaab","baa","badab"})); // Output: 2));
    }
}