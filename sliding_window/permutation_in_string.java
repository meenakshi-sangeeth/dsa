/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 
Constraints:
1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int k=s1.length();
        int left=0;
        int[] freq_s1=new int[26];
        int[] freq_s2=new int[26];
        for(int i=0;i<k;i++){
            freq_s1[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<k;i++){
            freq_s2[s2.charAt(i)-'a']++;
        }
        if (Arrays.equals(freq_s1,freq_s2)) return true;
        for(int right=k;right<s2.length();right++){
            freq_s2[s2.charAt(left)-'a']--;
            freq_s2[s2.charAt(right)-'a']++;
            if (Arrays.equals(freq_s1,freq_s2)) return true;
            left++;
        }
        return false;



    }
}
