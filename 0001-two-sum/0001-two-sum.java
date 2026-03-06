class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        int ans[] = new int[2];
        int newT = 0;
        for(int i = 0; i < nums.length ; i++){
            newT = target - nums[i]; 
            if(hm.containsKey(newT)){//[true:2, ]
              System.out.println("TRUE" + newT);
              int index = hm.get(newT);
                if(nums[index] + nums[i] == target){
                  ans[0] = index;
                  ans[1] = i;
                  return ans;
                //  break;
                   // ans[0] = 
                }
            }
            hm.put(nums[i], i);//hm = {2: 0, }

        }
        return ans;
    }
}