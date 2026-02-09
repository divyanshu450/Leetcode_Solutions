class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        int pointer = 0;
        List<Long> stack = new ArrayList<>();
        for (int num : nums) {
            long curr = num;

            while (!stack.isEmpty() && stack.get(stack.size() - 1) == curr) {//go on merging until valid....
                curr = stack.remove(stack.size() - 1) + curr;
            }

            stack.add(curr);
        }   

        return stack;
    }
}