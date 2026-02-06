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

class NodeIdx {
    TreeNode node;
    int idx;

    NodeIdx(TreeNode node, int idx) {
        this.node = node;
        this.idx = idx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        /*
            The problem statement says that we need to find the widht, i.e. distance between left most node and right most node. For this the basic intuition is to have BFS traversal and use maths, as parent to left child (2*i) and right (2*i + 1) where i is index (0 for root). These are index rules. Keep in mind, BFS = queue + size (for that level). This alone will help in variety of problem like zigzag, right-left view, level order traversal, average of levels.. etc.
        BFS Skeleton: Alone unlocks 30+ tree problems
             Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                int size = q.size();   // nodes in THIS level--this is the Key to control and freeze the loop

                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();

                    if (node.left != null) q.add(node.left);
                    if (node.right != null) q.add(node.right);
                }
            }
        */
        Queue<NodeIdx> q = new LinkedList<>();
        q.add(new NodeIdx(root, 0));
        int maxWidth = 0;
        while (!q.isEmpty()) {
            int size = q.size();   // nodes in THIS level--this is the Key to control and freeze the loop
            int base = q.peek().idx;
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {

                NodeIdx cur = q.poll();
                int idx = cur.idx - base;   // normalized index
                TreeNode node = cur.node;

                if (i == 0) first = idx;
                if (i == size - 1) last = idx;

                if (node.left != null)
                    q.add(new NodeIdx(node.left, 2 * idx));

                if (node.right != null)
                    q.add(new NodeIdx(node.right, 2 * idx + 1));
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }
}