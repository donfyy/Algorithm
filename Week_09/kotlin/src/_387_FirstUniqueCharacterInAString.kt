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
            s.forEachIndexed {idx, it ->
                if (freq[it - 'a'] == -1) {
                    freq[it - 'a'] = idx
                } else {
                    freq[it - 'a'] = -2
                }
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
            val freq = IntArray(26) { -1 }
            val q = LinkedList<Pair<Char, Int>>()
            s.forEachIndexed {idx, it ->
                freq[it - 'a'] = if(freq[it - 'a'] == -1) idx else -2
                q.offer(Pair(it, idx))
                while (q.isNotEmpty()) {
                    if (freq[q.peek().first - 'a'] > -1) break
                    q.poll()
                }
            }
            return if (q.isEmpty()) -1 else q.peek().second
        }
    }
}