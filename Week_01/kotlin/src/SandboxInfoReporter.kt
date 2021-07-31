import java.io.File
import java.util.*

class SandboxInfoReporter {
    data class Info(
        val totalSize: Long,
        val maxFileSize: Long,
        val maxNameLength: Int,
        val maxPathLength: Int,
        val depth: Int,
        val maxName: String,
        val maxPath: String,
        val duration: Long,
        val fileNum: Int,
    )

    fun report(dir: File?) {
        if (dir == null || !dir.isDirectory) return
        var totalSize = 0L
        var maxFileSize = 0L
        var fileNum = 0
        var maxPath = ""
        var maxName = ""
        var depth = 0
        val start = System.currentTimeMillis()
        val q = LinkedList<File>().apply { add(dir) }
        while (q.isNotEmpty()) {
            var size = q.size
            while (size-- > 0) {
                val file = q.poll()
                if (file.isFile) {
                    maxFileSize = maxOf(file.length(), maxFileSize)
                    if (maxName.length < file.name.length) {
                        maxName = file.name
                    }
                    fileNum++
                    totalSize += file.length()

                } else if (file.isDirectory) {
                    file.listFiles()?.forEach { q.offer(it) }
                }
                if (file.canonicalPath.length > maxPath.length) {
                    maxPath = file.canonicalPath
                }
            }
            depth++
        }
        maxPath = maxPath.substring(dir.canonicalPath.length)
        val info = Info(
            totalSize,
            maxFileSize,
            maxName.length,
            maxPath.length,
            depth,
            maxName,
            maxPath,
            System.currentTimeMillis() - start,
            fileNum
        )
        println(info)
    }
}

fun main() {
    SandboxInfoReporter().report(File("./.."))
}