package countingbits

class _190_ {
    class Solution {
        // you need treat n as an unsigned value
        fun reverseBits(n: Int): Int {
            var ret = 0
            var m = n;
            var power = 32;
            while (power-- >= 0) {
                ret = ret or ((m and 1) shl power)
                m = m ushr 1
            }
            return ret;
        }
    }
}