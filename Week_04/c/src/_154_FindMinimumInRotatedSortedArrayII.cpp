int findMin(int *nums, int numsSize)
{
    int l = 0, r = numsSize - 1, m = 0;
    while (l < r)
    {
        m = l + ((r - l) >> 1);
        if (nums[m] > nums[r])
            l = m + 1;
        else if (nums[m] < nums[r])
            r = m;
        else
            r--;
    }
    return nums[l];
}