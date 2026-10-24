class Solution {
    public int search(int[] nums, int target) {

        int n = nums.length;
        int low = 0;
        int high = n-1;
        int idx = -1;

        while(low<=high){
            int mid = (high+low)/2;

            if(nums[mid]>target){
                high = mid-1;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                return mid;
            }
        }

        return idx;
    }
}