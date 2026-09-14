class Solution {
    public boolean canJump(int[] nums) {
        int maxReach =0;
        int i=0;

        for(int num : nums){
            if(i>maxReach){
                return false;
            }

            maxReach = Math.max(maxReach, i+nums[i]);
            i++;
        }
    return true;
    }
}