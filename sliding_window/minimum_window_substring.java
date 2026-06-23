/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:
m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.

*/

class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        int len=t.length();
        int[] freq_s=new int[256];
        int[] freq_t=new int[256];
        for (char c : t.toCharArray()) {
            freq_t[c]++;
        }

        int count=0,min=999999,left=0;
        int idx=-1;

        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            freq_s[c]++;
            if(freq_t[c]>0 && freq_s[c]<=freq_t[c]) count++;
            if(count==len){
                while(freq_t[s.charAt(left)] == 0 || freq_s[s.charAt(left)] > freq_t[s.charAt(left)]) {
                    freq_s[s.charAt(left)]--;
                    left++;
                }
                int length=right-left+1;
                if(length<min){
                    min=length;
                    idx=left;
                }
            }

        }
        if (idx==-1) return "";
        else return s.substring(idx,idx+min);
    }
}

