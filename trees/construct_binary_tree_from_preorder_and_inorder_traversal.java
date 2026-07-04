/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]
*/

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
    int preIndex=0;
    HashMap<Integer,Integer> map=new HashMap<>();

    public TreeNode buildTree(int[] preorder,int[] inorder){

        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);

        return build(preorder,0,inorder.length-1);
    }

    private TreeNode build(int[] preorder,int left,int right){

        if(left>right)
            return null;

        TreeNode root=new TreeNode(preorder[preIndex]);
        preIndex++;

        int mid=map.get(root.val);

        root.left=build(preorder,left,mid-1);
        root.right=build(preorder,mid+1,right);

        return root;
    }
}
