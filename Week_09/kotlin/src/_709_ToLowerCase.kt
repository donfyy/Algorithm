class _709_ {
    fun toLowerCase(str: String): String {
        val ret = str.toCharArray()
        for (i in ret.indices) {
            ret[i] = (ret[i].toInt() or 32).toChar()
        }
        return String(ret)
    }
}