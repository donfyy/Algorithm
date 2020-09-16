int majorityElement(int* nums, int n){
    if (n < 1) return -1;
    int cnt = 1, curr = nums[0];
    for (int i = 1; i < n; i++) {
        if (cnt == 0) {
            cnt++;
            curr = nums[i];
        } else if(nums[i] == curr) {
            cnt++;
        } else {
            cnt--;
        }
    }
    return curr;
}