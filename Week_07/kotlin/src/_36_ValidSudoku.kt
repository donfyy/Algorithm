fun isValidSudoku(board: Array<CharArray>): Boolean {
    if (board.isEmpty() || board[0].isEmpty()) return false
    val row = Array<BooleanArray>(9){BooleanArray(9)}
    val col = Array<BooleanArray>(9){BooleanArray(9)}
    val block = Array<BooleanArray>(9){BooleanArray(9)}
    for (i in 0..8 ) {
        for (j in 0..8) {
            val ch = board[i][j]
            val c = ch - '1'
            if (ch == '.') continue
            if (row[i][c] || col[c][j] || block[i / 3 * 3 + j / 3][c]) return false
            row[i][c] = true
            col[c][j] = true
            block[i / 3 * 3 + j / 3][c] = true
        }
    }
    return true;
}


fun isValidSudoku2(board: Array<CharArray>): Boolean {
    if (board.isEmpty() || board[0].isEmpty()) return false
    for (i in 0..8) {
        for (j in 0..8) {
            val c = board[i][j]
            if (c == '.') continue
            for (k in 0..8) {
                if (k != j && board[i][k] == c) return false
                if (k != i && board[k][j] == c) return false
                val ki = i / 3 * 3 + k / 3;
                val kj = j / 3 * 3 + k % 3;
                if (ki != i && kj != j && board[ki][kj] == c) {
                    //kj 写成了ki 草
                    println("hhh")
                    return false
                }
            }
        }
    }
    return true;
}

fun main() {
    println(isValidSudoku(
            arrayOf(charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
                    charArrayOf('.', '.', '.', '.', '.', '6', '.', '.', '.'),
                    charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
                    charArrayOf('.', '.', '.', '.', '8', '.', '.', '.', '.'),
                    charArrayOf('9', '.', '.', '.', '7', '5', '.', '.', '.'),
                    charArrayOf('.', '.', '.', '.', '5', '.', '.', '8', '.'),
                    charArrayOf('.', '.', '9', '.', '.', '.', '.', '.', '.'),
                    charArrayOf('2', '.', '6', '.', '.', '.', '.', '.', '.'),
                    charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'))
    ))
}
