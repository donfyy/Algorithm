class _20__ {
    fun isNumber(s: String): Boolean {
        val n = s.length;
        var i = 0;
        fun trim() {
            while (i < n && s[i] == ' ') i++
        }
        fun scanUnsignedInteger(): Boolean {
            val before = i
            while (i < n && s[i] in '0'..'9') i++
            return i > before
        }
        fun scanInteger(): Boolean {
            if (i < n && (s[i] == '+' || s[i] == '-')) i++
            return scanUnsignedInteger()
        }
        trim()
        var ret = scanInteger()
        if (i < n && s[i] == '.') {
            i++
            ret = scanUnsignedInteger() || ret
        }
        if (i < n && (s[i] == 'E' || s[i] == 'e')) {
            i++
            ret = ret && scanInteger()
        }
        trim()
        return ret && i == n
    }
}