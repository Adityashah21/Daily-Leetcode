class Solution {
    public double findMaxAverage(int[] nums, int k) {
           int low=0;
        int high=k-1;
        double sum=0;
        for(int i=low;i<=high;i++){
           sum = sum + nums[i];
        }
        int n =nums.length;
        double result=sum;
        while(high<n){
            result=Math.max(result,sum);
            low++;
            high++;
            if(high==n){
                break;
            }
            sum=sum-nums[low-1]+nums[high];
        }
        return result/k;
    }
}