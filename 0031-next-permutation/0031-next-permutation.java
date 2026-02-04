class Solution {
    /*
    permutations problem are in different approach altogether, but this one is very specific and below is the only implementation.
    ALGO:
     eg: [1,2,6,5,4,3]

     -> scan right to left, such that nums[i] < nums[i+1]--> i.e. first idx(this is our pivot) where incresing stops. i.e. 2<6; but 6 !< 5 or 5 !< 4...
     -> the idea being, thereafter, all are in desc order like 6-5-4..
     -> find nearest higher than that of pivot(pos = 1), eg: 2<3, but 2<4 is not nearest...
     -> swap the values of the nearest and pivot (2 and 3=> [1,3,6,5,4,2])
     -> simply reverse after pivot=> 1,3,2,4,5,6--> ANS.

     IF NO PIVOT: simly reverse eg: [3,2,1] => [1,2,3]
    */
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        int i = nums.length - 2;
        while(i >= 0 && (nums[i+1] <= nums[i])) i--;//scan right to left and first 1st idx where nums[i] < nums[i + 1]
        pivot = i;
        System.out.println(pivot);
        if(pivot != -1){//pivot exists, therefore find closest; if not, reverse the entire array
            for(int n = nums.length -1; n > pivot; n--){
                if(nums[n] > nums[pivot]){
                    swap(nums, n, pivot);
                    break;
                }
            }
        }
        else{
            System.out.println("pivot: "+ pivot);
            reverse(nums, 0, nums.length - 1);
            return;
        }
        reverse(nums, pivot + 1,  nums.length - 1);
        return;
    }

    void swap(int[] nums, int n, int pivot){
        int temp = nums[pivot];
        nums[pivot] = nums[n];
        nums[n] = temp;
    }

    void reverse(int[] nums, int pivot, int n){
        while(pivot < n){
            swap(nums, n--, pivot++);
        }
    }
}