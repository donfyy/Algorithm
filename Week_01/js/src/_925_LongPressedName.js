/**
 * @param {string} name
 * @param {string} typed
 * @return {boolean}
 */
var isLongPressedName = function(name, typed) {
    const m = name.length, n = typed.length
    let i = 0, j = 0
    while (j < n) {
        if (i < m && (name[i] === typed[j])) {
            i++
            j++
        } else if (j > 0 && typed[j] === typed[j - 1]) {
            j++
        } else {
            return false
        }
    }
    return i == m
};