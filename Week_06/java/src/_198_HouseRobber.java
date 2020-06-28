/**
 * 第一遍：2020/06/28周日 ✅
 * 第二遍：2020/06/28周一
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 * //1.f(i)[0] = max(f(i - 1)[0], f(i - 1)[1]) f(i)[1] = f(i - 1)[0] + value(i)
 * //2.f(i) = max(f(i - 2), f(i - 3)) + value(i)
 * //3.f(i) = max(f(i - 1), f(i - 2) + value(i))超哥的dp方程是这个，这个状态方程表示到第i个房屋时偷或不偷的一个最大值，
 * 这个题目非常经典，至少目前发现三种状态表示的定义，也就有3种状态转移方程，
 * 第一种方式是升维的思想，后面两种没有升维，可以理解找最大值的过程是第二个维度
 */
class _198_HouseRobber {
    public int rob(int[] nums) {
        //1.f(i)到第i个房屋能够偷到的最大金额，f(i)[0]第i个房屋不偷的最大金额，f(i)[1]第i个房屋偷的最大金额
        //f(i)[0] = max(f(i - 1)[0], f(i - 1)[1]) f(i)[1] = f(i - 1)[0] + value(i)
        //2.f(i)到第i个房屋必偷时能够偷到的最大金额，然后找到所有最大金额中的最大值
        //f(i)以第i个元素为结尾的连续子数组的最大和，要找到所有连续子数组的最大和的最大值
        if (nums == null || nums.length == 0) return 0;
        int dpi0 = 0;
        int dpi1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int i0 = Math.max(dpi0, dpi1);
            int i1 = dpi0 + nums[i];

            dpi0 = i0;
            dpi1 = i1;
        }
        return Math.max(dpi0, dpi1);
    }

    public int rob2(int[] nums) {
        //1.f(i)到第i个房屋能够偷到的最大金额，f(i)[0]第i个房屋不偷的最大金额，f(i)[1]第i个房屋偷的最大金额
        //f(i)[0] = max(f(i - 1)[0], f(i - 1)[1]) f(i)[1] = f(i - 1)[0] + value(i)
        //2.f(i)到第i个房屋必偷时能够偷到的最大金额，然后找到所有最大金额中的最大值
        //f(i) = max(f(i - 2), f(i - 3)) + value(i)
        //f(i) = max(f(i - 1), f(i - 2) + value(i))超哥的dp方程是这个，这个状态方程表示到第i个房屋时偷或不偷的一个最大值，
        //这个定义搞的我有点懵逼。。。
        //f(i)以第i个元素为结尾的连续子数组的最大和，要找到所有连续子数组的最大和的最大值
        if (nums == null || nums.length == 0) return 0;
        int dpi_1 = nums[0];
        int dpi_2 = 0;
        int dpi_3 = 0;
        int ret = dpi_1;
        for (int i = 1; i < nums.length; i++) {
            int dp = Math.max(dpi_2, dpi_3) + nums[i];
            ret = Math.max(ret, dp);
            dpi_3 = dpi_2;
            dpi_2 = dpi_1;
            dpi_1 = dp;
        }
        return ret;
    }
}