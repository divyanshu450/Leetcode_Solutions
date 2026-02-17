class Solution {
    static int mem[][];
    public int lengthOfLIS(int[] nums) {
        if( nums.length < 1) return 0;
        if(nums.length == 1) return 1;
        mem = new int[nums.length][nums.length + 1];
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }
        return recLIS(nums, 0, -1, -1);
    }

    int recLIS(int[] nums, int i, int prevIndex, int prevVal){
        if( i == nums.length) return 0;//mem[i-1][prevVal];
        if(mem[i][prevIndex + 1] != -1) return mem[i][prevIndex+1];
        int include = 0;
        if( prevIndex == -1 || nums[i] > nums[prevIndex]){
            include = 1 +recLIS(nums, i+1, i, nums[i]);
            //mem[i] = include;
        }

        int exclude = recLIS(nums, i+1, prevIndex, prevVal);
        mem[i][prevIndex + 1] = Math.max(exclude, include);
        return mem[i][prevIndex + 1];//Math.max(include, exclude);
    }
}