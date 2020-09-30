// cnt: 跳跃次数
// end: 当前这次跳跃可以选择的起跳位置的右界
// maxPos: 当前这次跳跃完成后可以到达的最远位置
// 每一次起跳时，总是找能够跳的最远的起跳位置。
// O(n) O(1)
int jump(int *nums, int n)
{
    int cnt = 0, end = 0, maxPos = 0;
    for (int i = 0; i < n - 1; i++)
    {
        maxPos = fmax(maxPos, i + nums[i]);
        if (i == end)
        {
            end = maxPos;
            cnt++;
        }
    }
    return cnt;
}