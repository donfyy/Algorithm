/**
 * @param {string} S
 * @return {number[]}
 */
var partitionLabels = function(S) {
    const lastPos = new Array(26)
    const n = S.length
    const idxa = 'a'.codePointAt(0)
    for (let i = 0; i < n; i++) {
        lastPos[S.codePointAt(i) - idxa] = i
    }
    const ret = []
    let l = 0, r = 0
    for (let i = 0; i < n; i++) {
        r = Math.max(r, lastPos[S.codePointAt(i) - idxa])
        if (i == r) {
            ret.push(r - l + 1)
            l = r + 1
        }
    }
    return ret
};