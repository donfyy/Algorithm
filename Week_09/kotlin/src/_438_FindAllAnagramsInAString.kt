import java.util.*
import kotlin.collections.ArrayList


class _FindAllAnagramsInAString_ {
    class Solution {
        fun findAnagrams(s: String, p: String): List<Int> {
            // 该滑动窗口算法，并没有将窗口的长度限制为p的长度
            // 而是先移动右端点，直到窗口中包含了p中所有的字符，记该条件为a，
            // 在条件a不变的情况下，移动左端点，减小窗口的长度，最终如果窗口的长度和p的长度相同
            // 则当前窗口中的字符满足题目要求，也就是p的字母异位词.
            if (p.length > s.length) return Collections.emptyList()
            // 统计p中每个字符出现的次数
            val freq = HashMap<Char, Int>()
            for (c in p) {
                freq[c] = freq.getOrDefault(c, 0) + 1
            }
            // 获得p中字符的个数
            var count = freq.size
            // 滑动窗口的左端点和右端点
            var left = 0
            var right = 0
            // 保存子串的起始索引
            val ret = ArrayList<Int>()
            while (right < s.length) {
                // 先移动右端点
                var c = s[right]
                // 如果字符出现在p中
                if (freq.containsKey(c)) {
                    // 将字符出现的次数-1
                    freq[c] = freq[c]!! - 1
                    // 如果字符出现的次数为0，说明[left, right]中c出现的次数和c在p中出现的次数相同
                    if (freq[c]!! == 0) count--
                }
                right++
                // 如果p中每个字符都在[left, right]中出现了
                while (count == 0) {
                    // 如果[left, right]中字符的个数和p中字符的个数相同，那么s[left, right]就是p的字母异位词
                    if (right - left == p.length) ret.add(left)
                    c = s[left]
                    // 将left指向的字符从窗口中移除
                    if (freq.containsKey(c)) {
                        // 如果字符c出现在p中，
                        // 如果当前c在[left, right]中出现的次数和c在p中出现的次数相同，
                        // 则p中的所有字符不会出现在[left, right]中，因此移动right
                        // 那么将c出现的次数增加
                        if (freq[c]!! == 0) count++
                        freq[c] = freq[c]!! + 1
                    }
                    left++
                }
            }
            return ret
        }
    }

    class SlideWindow {
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
    }

}