int search(int *nums, int numsSize, int target)
{
    int l = 0, r = numsSize - 1, m;
    while (l <= r)
    {
        m = l + ((r - l) >> 1);
        if (nums[m] == target)
            return m;
        if (nums[m] <= nums[r])
        {
            if (target > nums[m] && target <= nums[r])
                l = m + 1;
            else
                r = m - 1;
        }
        else
        {
            if (target >= nums[l] && target < nums[m])
                r = m - 1;
            else
                l = m + 1;
        }
    }
    return -1;
}