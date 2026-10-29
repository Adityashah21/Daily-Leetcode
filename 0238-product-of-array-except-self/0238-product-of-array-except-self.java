class Solution {
public int[] productExceptSelf(int[] nums) {
int n = nums.length;
int[] ans = new int[n];

    // Step 1: Store the product of all elements to the left
    ans[0] = 1;

    for (int i = 1; i < n; i++) {
        ans[i] = ans[i - 1] * nums[i - 1];
    }

    // Step 2: Multiply by the product of all elements to the right
    int rightProduct = 1;

    for (int i = n - 1; i >= 0; i--) {
        ans[i] *= rightProduct;
        rightProduct *= nums[i];
    }

    return ans;
}

}
