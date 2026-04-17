/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prec=new int[nums.length];
        int[] succ=new int[nums.length];
        int[] pdt=new int[nums.length];
       
        prec[0]=1;
        for (int i=1; i<nums.length;i++){
            prec[i]=prec[i-1]*nums[i-1];
        }
        succ[nums.length-1]=1;
        for (int i=nums.length-2; i>=0;i--){
            succ[i]=succ[i+1]*nums[i+1];
        }
        for (int i=0; i<nums.length;i++){
            pdt[i]=prec[i]*succ[i];
        }
        return pdt;
    }
}
