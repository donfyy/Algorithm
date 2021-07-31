import java.io.File
import java.io.FileOutputStream
import java.nio.charset.Charset

class Test {
    var awesomeVar1: String? = "some awesome string value"
    var awesomeVar2: String? = null

    fun doSomeAwesomePrinting() {
        awesomeVar1?.let {
            awesomeVar2?.let {
                println("awesome output 2")
            }
        } ?: run {
            println("awesome output 1")
        }
    }

    fun testQuestionMark(name: String?): Boolean {
        return name?.let { name.startsWith("a") } ?: true
    }
}

fun main() {
//    Test().doSomeAwesomePrinting()
//    println(Test().testQuestionMark("aaaa"))
//    println(Test().testQuestionMark("baaaa"))
//    println(Test().testQuestionMark(null))

//    val file = File("")
//    println(file.absoluteFile)
//    file.list()?.forEach { println(it) }
//    val testFile = File("abc.txt")
//    FileOutputStream(testFile).apply {
//        val byte = "h1".encodeToByteArray()
//        write(byte, 0, byte.size)
//        close()
//    }
//    FileOutputStream(testFile).apply {
//        val byte = "h2".encodeToByteArray()
//        write(byte, 0, byte.size)
//        close()
//    }

    println(60L/8L)
    println(0.1 + 0.2 == 0.3)
}