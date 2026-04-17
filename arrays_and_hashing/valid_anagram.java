/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
*/

class Solution {
    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        int[] charcount=new int[26];
        for(int i=0;i<s.length();i++){
            charcount[s.charAt(i)-'a']++;
            charcount[t.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if (charcount[i]!=0) return false;
        }
        return true;
    }
}
