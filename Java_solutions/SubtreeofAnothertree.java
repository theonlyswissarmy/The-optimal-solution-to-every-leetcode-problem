class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }else if (root == null || subRoot == null){
            return false;
        }
        if(root.val == subRoot.val && sametree(root.left, subRoot.left) && sametree(root.right, subRoot.right)){
            return true;
        }else{
            if (root.left != null && isSubtree(root.left, subRoot)){
                return true;
            }else if(root.right != null && isSubtree(root.right, subRoot)){
                return true;
            }else{
                return false;
            }
        }
    }
    public boolean sametree(TreeNode root,TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }else if (root == null || subRoot == null){
            return false;
        }else if(root.val == subRoot.val && sametree(root.right, subRoot.right) && sametree(root.left, subRoot.left)){
            return true;
        }else{
            return false;
        }
    }

}
