class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
       for(int s:set){
        if(!set.contains(s - 1)){
            int currVal = s;
            int count = 1;
            while(set.contains(currVal + 1)){
                count = count + 1;
                currVal = currVal + 1;
            }
            max = Math.max(max, count);
        }
       }
       return max;
    }
}