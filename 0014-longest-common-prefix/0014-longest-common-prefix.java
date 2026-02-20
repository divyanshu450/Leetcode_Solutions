class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++)//from the second element of string array
        {
            while(strs[i].indexOf(prefix)!=0)
                prefix=prefix.substring(0, prefix.length()-1);//reduce the character by 1
        }
        
        return prefix;
    }
}