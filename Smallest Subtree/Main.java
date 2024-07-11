import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 

class Solution {
    public static ArrayList<TreeNode> treeToArray(TreeNode root) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int nullCount = 0;
        while (!queue.isEmpty()) {
            if(nullCount == queue.size()) break;
            TreeNode node = queue.poll();
                result.add(node);
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
                if(node.left == null) nullCount++;
                if(node.right == null) nullCount++;
            } else {
                queue.add(null);
                queue.add(null);
                nullCount++;
            }
        }

        int i = result.size() - 1;
        while (i >= 0 && result.get(i) == null) {
            result.remove(i);
            i--;
        }

        return result;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        ArrayList<TreeNode> tree = new ArrayList<>();
        tree = treeToArray(root);

        ArrayList<Integer> parents = new ArrayList<>();

        int leftIndex = 0;
        int mul = 1;

        if(tree.size() == 1) {
          return root;
        }

        while(true) {
          mul *= 2;
          if(leftIndex + mul >= tree.size() - 1) {
            break;
          }
          leftIndex += mul;
        }

        for (int i = leftIndex + 1; i < tree.size(); i++) {
          if(tree.get(i) != null) parents.add(i);
        }
        while (parents.size() > 1) {
          for (int i = parents.size() - 1; i >= 0; i--) {
            int pos = (parents.remove(i) + 1) / 2 - 1;
            if(!parents.contains(pos)) parents.add(pos);   
          }
        }

        return tree.get(parents.get(0));
    }
}

public class Main {
  public static void main(String[] args) {
    Solution obj = new Solution();

    TreeNode root = new TreeNode(3);
    TreeNode node5 = new TreeNode(5);
    TreeNode node1 = new TreeNode(1);
    TreeNode node6 = new TreeNode(6);
    TreeNode node2 = new TreeNode(2);
    TreeNode node0 = new TreeNode(0);
    TreeNode node8 = new TreeNode(8);
    TreeNode node7 = new TreeNode(7);
    TreeNode node4 = new TreeNode(4);

    root.left = node5;
    root.right = node1;
    node5.left = node6;
    node5.right = node2;
    node1.left = node0;
    node1.right = node8;
    node2.left = node7;
    node2.right = node4;
      
    TreeNode result = obj.subtreeWithAllDeepest(root);
    
    System.out.println("Tree converted to ArrayList: " + result.val);
  }
}