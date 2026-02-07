class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0; int right = nums.length - 1;

        while(left < right){
            int mid = ( left+right ) / 2;//get mid

            if(mid % 2 == 1){//not even
                mid--;
            }
            if(nums[mid] == nums[mid + 1]){//
                left = mid + 2;
            }
            else{
                right = mid;
            }
        }
        return nums[left];
    }
}