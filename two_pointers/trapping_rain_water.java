/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
*/

class Solution {
    public int trap(int[] height) {
        int lmax=height[0],rmax = height[height.length-1];
        int i=1,j=height.length-2;
        int res=0;
        while (i<=j){
            if (lmax<rmax){
                int amt=lmax-height[i];
                if (amt>0) res=res+amt;
                lmax=Math.max(height[i],lmax);
                i++;
            }
            else{
                int amt=rmax-height[j];
                if (amt>0) res=res+amt;
                rmax=Math.max(height[j],rmax);
                j--;
            }           
        }
        return res;
    }
}
