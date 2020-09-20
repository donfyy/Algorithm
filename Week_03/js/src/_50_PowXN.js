var myPow = function(x, n) {
    let ret = 1.0;
    let N = n < 0? -n: n;
    while (N) {
        if (N & 1) {
            ret *= x;
        }
        x *= x;
        N >>>= 1;
    }
    return n < 0? 1 / ret : ret;
};