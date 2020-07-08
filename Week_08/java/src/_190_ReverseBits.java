/**
 * 第一遍：2020/07/07周三 ✅
 * 第二遍：2020/07/08周四 ✅
 * 第二遍：2020/07/03周五
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 * 我去，我居然只想着对调位数。。。。。。。。。
 */
public class _190_ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0, power = 31;
        while (n != 0) {
            ret += (n & 1) << power;
            n = n >>> 1;
            power--;
        }
        return ret;
    }
}