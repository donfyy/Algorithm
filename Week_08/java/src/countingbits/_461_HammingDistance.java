package countingbits;

class _461_HammingDistance {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int ret = 0;
        while (z != 0) {
            z = z & z - 1;
            ret++;
        }
        return ret;
    }
}