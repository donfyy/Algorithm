class Solution
{
public:
    int hammingDistance(int x, int y)
    {
        int z = x ^ y;
        int ret = 0;
        while (z)
        {
            z = z & z - 1;
            ret++;
        }
        return ret;
    }
};