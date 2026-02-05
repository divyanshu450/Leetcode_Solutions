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

 class NodeInfo{
    int row;
    int val;
    NodeInfo(int row, int val){
        this.row = row;
        this.val = val;
    }
 }
 
class Solution {
    Map<Integer, List<NodeInfo>> colMap = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        recursiveDFSCall(root, 0, 0);//phase 1-> only collecting row and col for each node in tree;

        //phase 2-> traversing and accumulating data;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cols = new ArrayList<>(colMap.keySet());
        Collections.sort(cols);

        for (int col : cols) {
            List<NodeInfo> list = colMap.get(col);

            Collections.sort(list, (a, b) -> {
                if (a.row != b.row) return a.row - b.row;
                return a.val - b.val;
            });

            List<Integer> vertical = new ArrayList<>();
            for (NodeInfo n : list) {
                vertical.add(n.val);
            }
            result.add(vertical);
        }
        return result;


    }

    void recursiveDFSCall(TreeNode root, int row, int col)  {

        if(root == null) return;
        
        colMap.computeIfAbsent(col, k -> new ArrayList<>()).add(new NodeInfo(row, root.val));
        recursiveDFSCall(root.left, row + 1, col - 1);
        recursiveDFSCall(root.right, row + 1, col + 1);
        return;
    }
}