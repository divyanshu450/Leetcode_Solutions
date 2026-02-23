class Solution {
    public String longestPalindrome(String s) {
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++)
        {
          int len1 = lopalin(s, i, i);//odd case
          int len2 = lopalin(s, i, i+1);//even case
            int len= Math.max(len1, len2);
            if(len>end-start)
            {
                start=i-((len-1)/2); // going left from i-th pos
                    end=i+(len/2);// going right from i-th pos
            }
        }
        
       return s.substring(start, end+1);
    }
    
    public int lopalin(String s, int left, int right)
    {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }
        
        return right-left-1;
    }
}