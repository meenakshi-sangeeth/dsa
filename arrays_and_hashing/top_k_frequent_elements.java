/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int ele : nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        int maxf=0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxf=Math.max(maxf,entry.getValue());
        }
        ArrayList<ArrayList<Integer>> buckets=new ArrayList<>();
        for (int i=0;i<=maxf;i++){
            buckets.add(new ArrayList<>());
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            buckets.get(entry.getValue()).add(entry.getKey());
        }
        int[] res=new int[k];
        int j=0;
        for (int i=maxf;i>=0;i--){
            Collections.sort(buckets.get(i),Collections.reverseOrder());
            for (int ele: buckets.get(i)){
                res[j++]=ele;
                if (j==k) return res;
            }
        }
        return res;
    }
}
