/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    const n = s.length
    if (n !== t.length) return false
    let freq = Array(26).fill(0)
    const a = 'a'.charCodeAt()
    for (let i = 0; i < n; i++) {
        freq[s[i].charCodeAt() - a]++
        freq[t[i].charCodeAt() - a]--
    }
    for (let it of freq) {
        if (it !== 0) return false
    }
    return true
};