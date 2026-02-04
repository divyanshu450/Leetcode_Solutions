/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return recursiveCall(root, list);
    }

    List<Integer> recursiveCall(TreeNode root, List<Integer> list){
        if(root == null) return list;
        recursiveCall(root.left, list);
        list.add(root.val);
        recursiveCall(root.right, list);
        return list;
    }
}