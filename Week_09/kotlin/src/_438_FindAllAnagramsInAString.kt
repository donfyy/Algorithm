import java.util.*
import kotlin.collections.ArrayList

fun findAnagrams(s: String, p: String): List<Int> {
    if (p.length > s.length) return Collections.emptyList()
    val table = IntArray(26)
    for (c in p) {
        table[c - 'a']++
    }
    var count = p.length
    val ret = ArrayList<Int>()
    var left = 0;
    var right = 0;
    while (right < s.length) {
        if (table[s[right++] - 'a']-- > 0) count--
        if (count == 0) ret.add(left)
        if (right - left >= p.length && table[s[left++] - 'a']++ >= 0) count++
    }
    return ret
}