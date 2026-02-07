class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0; int right = nums.length - 1;

        while(left < right){// T
            int mid = ( left+right ) / 2;//get mid | 4, 2, 1

            if(mid % 2 == 1){//not even | F, F, T
                mid--;//T-> 0
            }
            if(nums[mid] == nums[mid + 1]){// 3 == 4-> F(broken pair), 2 == 3->F, 1 == 1->T(pair not broken)
                left = mid + 2;// 0 + 2 = 2--> left == right and loop ends
            }
            else{
                right = mid;//4, 2
            }
        }
        return nums[left];
    }
}