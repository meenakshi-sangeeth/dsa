/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int ele: nums){
            if (!set.contains(ele)){
                set.add(ele);
            }
            else return true;

        }
        return false;
    }
}
