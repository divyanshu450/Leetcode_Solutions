class Solution {
    public int scoreDifference(int[] nums) {
        if(nums.length < 2 && nums[0] % 2 != 0) return 0 - nums[0];
        if(nums.length < 2 && nums[0] % 2 == 0) return nums[0];
        int p1 = 0, p2 = 0;
        boolean a1 = true; boolean a2 = false;
        for(int i = 0; i < nums.length; i++){
            if((i + 1) % 6 == 0){
                if(a2){
                    a1 = true;
                    a2 = false;
                }
                else{
                    a1 = false;
                    a2 = true;
                }
            }
            if(a1 && nums[i] % 2 != 0){
                a2 = true;
                a1 = false;
            }
            else if(a2 && nums[i] % 2 != 0){
                a2 = false;
                a1 = true;
            }
            p1 += a1 ? nums[i] : 0;
            p2 += a2 ? nums[i] : 0;
        }
        return p1 - p2;
    }
}