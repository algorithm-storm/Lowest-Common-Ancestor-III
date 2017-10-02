/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */



public class Solution {

    public static void main(String [] args){

        TreeNode root = new TreeNode(1);
        TreeNode leftTree = new TreeNode(2);
        root.left = leftTree;
        TreeNode rightTree4 = new TreeNode(4);
        TreeNode rightTree5 = new TreeNode(5);
        TreeNode rightTree = new TreeNode(3);
        rightTree.left = rightTree4;
        rightTree.right = rightTree5;
        root.right = rightTree;

        Solution a = new Solution();
        System.out.println(a.lowestCommonAncestor3(root,root.left,root.right).val);

    }

    class ResultType {
        public boolean a_exist;
        public boolean b_exist;
        TreeNode node;
        public ResultType(boolean a_exist, boolean b_exist, TreeNode node){
            this.a_exist = a_exist;
            this.b_exist = b_exist;
            this.node = node;
        }
    }


    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */


    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {

        ResultType result =  helper(root,A,B);
        if(result.a_exist && result.b_exist){
            return result.node;
        }
        else {
            return null;
        }

    }


    public ResultType helper(TreeNode root, TreeNode A, TreeNode B){

        if(root == null){
            return new ResultType(false,false,null);
        }

        ResultType leftTree = helper(root.left,A,B);
        ResultType rightTree = helper(root.right,A,B);

        boolean a_exist = leftTree.a_exist || rightTree.a_exist || root == A;
        boolean b_exist = leftTree.b_exist || rightTree.b_exist || root == B;

        if(A == root || B == root){
            return new ResultType(a_exist,b_exist,root);
        }

        if(leftTree.node != null && rightTree.node != null){
            return new ResultType(a_exist,b_exist,root);
        }

        if(leftTree.node !=null){
            return new ResultType(a_exist,b_exist,leftTree.node);
        }

        if(rightTree.node != null){
            return new ResultType(a_exist,b_exist,rightTree.node);
        }

        return new ResultType(a_exist,b_exist,null);

    }
}