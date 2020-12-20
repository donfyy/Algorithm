class _48_RotateImage_ {
    class UsingNaiveRotate {
        fun rotate(matrix: Array<IntArray>): Unit {
            val n = matrix.size
            for (i in 0 until (n shr 1)) {
                for (j in i until n - 1 - i) {
                    matrix[i][j] = matrix[n - 1 - j][i].also {
                        matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j].also {
                            matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i].also {
                                matrix[j][n - 1 - i] = matrix[i][j]
                            }
                        }
                    }
                }
            }
        }
    }
}