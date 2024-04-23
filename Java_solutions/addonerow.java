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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1){
            TreeNode insertme = new TreeNode(val);
            insertme.left = root;
            return insertme; 
        }else if (depth == 2){
            TreeNode insertme = new TreeNode(val);
            insertme.left = root.left;
            root.left = insertme;
            insertme = new TreeNode(val);
            insertme.right = root.right;
            root.right = insertme;
        }else{
            if(root.right != null){

                downonerow(root.right, val, depth, 2);
            }
            if(root.left != null){

                downonerow(root.left, val, depth, 2);
            }
        }
        return root;
    }
    public void downonerow(TreeNode root, int val, int tardep, int ourdepth){
        if (tardep == ourdepth + 1){
            TreeNode insertme = new TreeNode(val);
            insertme.left = root.left;
            root.left = insertme;
            insertme = new TreeNode(val);
            insertme.right = root.right;
            root.right = insertme;
        }else{
            if(root.right != null){
                downonerow(root.right, val, tardep, ourdepth+1);
            }
            if(root.left != null){

                downonerow(root.left, val, tardep, ourdepth+1);
            }
        }
    }
}
