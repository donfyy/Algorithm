bool PredictTheWinner(int* nums, int numsSize){
    const int n = numsSize;
    if (n <= 0) return false;
    int dp[n], i = 0, j = 0;
    for (; i < n; i++) dp[i] = nums[i];
    for (i = n - 2; i >= 0; i--) {
        for (j = i + 1; j < n; j++) {
            dp[j] = fmax(nums[i] - dp[j], nums[j] - dp[j - 1]);
        }
    }
    return dp[n - 1] >= 0;
}