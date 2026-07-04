/*
Given a binary tree, determine if it is height-balanced.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true
*/

class Solution{

    public boolean isBalanced(TreeNode root){
        return height(root)!=-1;
    }

    private int height(TreeNode root){
        if(root==null)
            return 0;

        int left=height(root.left);
        if(left==-1)
            return -1;

        int right=height(root.right);
        if(right==-1)
            return -1;

        if(Math.abs(left-right)>1)
            return -1;

        return 1+Math.max(left,right);
    }
}
