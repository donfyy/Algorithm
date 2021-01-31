import java.util.*

class _387_FirstUniqueCharacterInAString_ {
    class UsingHash {
        fun firstUniqChar(s: String): Int {
            val freq = IntArray(26)
            s.forEach { freq[it - 'a']++ }
            s.forEachIndexed { idx, it -> if (freq[it - 'a'] == 1) return idx }
            return -1
        }
    }

    class UsingHash2 {
        fun firstUniqChar(s: String): Int {
            val freq = IntArray(26) { -1 }
            s.forEachIndexed { idx, it ->
                freq[it - 'a'] = if (freq[it - 'a'] == -1) idx else -2
            }
            var ret = s.length
            freq.forEach {
                if (it > -1) {
                    ret = minOf(ret, it)
                }
            }
            return if (ret == s.length) -1 else ret
        }
    }

    class UsingHashAndQueue {
        fun firstUniqChar(s: String): Int {
            val freq = IntArray(26)
            val q = LinkedList<Int>()
            s.forEachIndexed { idx, it ->
                q.offer(idx)
                freq[it - 'a']++
                while (q.isNotEmpty() && freq[s[q.peek()] - 'a'] > 1) {
                    q.poll()
                }
            }
            return if (q.isEmpty()) -1 else q.poll()
        }
    }
}