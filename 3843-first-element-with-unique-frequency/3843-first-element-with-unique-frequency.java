class Solution {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // step 1: count freq first
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0) + 1);//maps like number:freq
        }
        //step 2: count how many times each freq appears
        Map<Integer, Integer> hm = new HashMap<>();// maps like freq: freq count eg: 30: 2
        for(int count : map.values()){
            hm.put(count, hm.getOrDefault(count, 0)+1);
        }

        //step 3: return first unique freq
        for(int n : nums){
            if(hm.get(map.get(n)) == 1){//get this number's freq, check how many number's have that freq, == 1 meaning it is unique (only one number has this freq not that freq is 1);
                return n;
            }
        }
        return -1;
    }
}