/*
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
    // ... your code
    return encoded_string;
}
Machine 2 (receiver) has the function:

vector<string> decode(string s) {
    //... your code
    return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods
*/

class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String i : strs){
            sb.append(i.length());
            sb.append("#");
            sb.append(i);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i=0, n=str.length();
        while (i<n){
            int len=0;
            while (str.charAt(i)!='#'){
                len=len*10+str.charAt(i)-'0';
                i++;
            }
            i++;
            res.add(str.substring(i, i + len));
            i=i+len;
        }
        return res;
    }
}

