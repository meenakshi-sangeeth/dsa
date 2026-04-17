/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st=new HashSet<>();
        for (int n:nums){
            st.add(n);
        }
        int res=0;
        for (int n:nums){
            if (st.contains(n) && !st.contains(n-1)){
                int curr=n,count=0;
                while (st.contains(curr)){
                    st.remove(curr);
                    count++;
                    curr++;
                }
                res=Math.max(count,res);
            }
            
        }
        return res;
    }
}
