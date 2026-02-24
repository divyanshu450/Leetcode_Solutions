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
    public boolean isBalanced(TreeNode root) {
        /*
        WHAT THE ACTUAL QUESTION IS:
        For every node,
        | height(left subtree) - height(right subtree) | <= 1
        */
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        if (left == -1) return -1;

        int right = height(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}
//--STUPID APPROACH:
// if(root == null) return true;
//         boolean bool = false;
//         int diff1 = 0;
//         int diff2 = 0;
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()){
//            for(int i = 0; i < q.size(); i++){
//             TreeNode node = q.poll();
//             System.out.println("node val: "+node.val);
//                 if(node.left != null){
//                     q.add(node.left);
//                    // diff1++;
//                     System.out.println("diff1: "+diff1);
//                     // System.out.println("1- q.val: "+node.val);
//                 } 
//                 if(node.right != null){
//                     q.add(node.right);
//                   //  diff1++;
//                     System.out.println("diff2: "+diff2);
//                    // System.out.println("2 - q.val: "+node.val);
//                 }
//                 if(node.left == null && node.right == null){
//                     diff2 = diff1;//fix
//                 } 
//                 if(node.left == null || node.right == null){
//                     diff1++;
//                 } 
//            }
//            if(Math.abs(diff1 - diff2) == 1) bool = true;
//            diff1 = 0;
//            //diff2 = 0;
//         }
//         // System.out.println("diff1: "+diff1);
//         // System.out.println("Math.abs(diff1 - diff2): "+Math.abs(diff1 - diff2));
//         return bool ? true : false;
//     }