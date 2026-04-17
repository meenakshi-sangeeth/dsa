/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
*/

class Solution {
    public String hash(String str){
        int[] freq=new int[26];
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<str.length();i++){
            freq[str.charAt(i)-'a']++;
        }
        for (int i=0;i<26;i++){
            sb.append(freq[i]);
            sb.append('$');
        }
        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for (String str: strs){
            String key=hash(str);
            if (!map.containsKey(key)){
                map.put(key,res.size());
                res.add(new ArrayList<>());
            }
            res.get(map.get(key)).add(str);
        }
        return res;
    }
}
