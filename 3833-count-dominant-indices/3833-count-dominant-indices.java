class Solution {
    public int dominantIndices(int[] nums) {
        int sum = 0;
        int count = 0;
        double avg = 0.00;
        for(int i = 0; i < nums.length - 2; i++){// 0; 1
            for(int j = i+1; j <= nums.length - 1; j++){//1,2,3 ; 2
                sum = sum + nums[j];//0+98+75+26= 199 ; 
            }
            avg = sum/(nums.length - 1 - i);//199/(4-1-0)=66.34
            if(avg < nums[i]) count++;//F
            avg = 0.00;
            sum = 0;
        }
        if(nums.length >= 2){
            // System.out.println("nums[nums.length -2] "+ nums[nums.length -2] );
            // System.out.println("nums[nums.length -1] "+ nums[nums.length -1] );
            if(nums[nums.length -2] > nums[nums.length -1]) count++;
        }
        
        return count;
    }
}