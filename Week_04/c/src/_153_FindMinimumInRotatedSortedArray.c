int findMin(int *nums, int numsSize)
{
    int l = 0, r = numsSize - 1, m = 0;
    while (l < r)
    {
        if (nums[r] > nums[l])
            break;
        m = l + ((r - l) >> 1);
        if (nums[m] >= nums[l])
            l = m + 1;
        else
            r = m;
    }
    return nums[l];
}