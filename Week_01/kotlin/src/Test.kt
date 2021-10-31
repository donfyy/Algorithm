import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.net.URI
import java.net.URL
import java.nio.charset.Charset

class Test {
    constructor(int: Int) {}
    constructor(str: String, long: Long) {}
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
//    val file = File("a/b/c/d/a.txt")
//    file.outputStream().apply {
//        write(ByteArray(0))
//        close()
//    }
//    println(file.length())
//    println(URI("-1").rawPath)
//    for (constructor in TestConstructor::class.java.declaredConstructors) {
//        println(constructor.toString())
//        println(constructor.toGenericString())
//    }
    val file = File("a/b/c")
    println(file)
    println(File(file, "c/d/a.txt").canonicalPath)
    println(File(file, "/c/d/a.txt").canonicalPath)
    println(File(file, "./c/d/a.txt").canonicalPath)
    println(File(file, "../c/d/a.txt").canonicalPath)
    println(File("a/b/c/xxxxxd/").apply {
        writeText("abc")
    }.isDirectory)
}

fun testCatch() {
    try {
        println("in try")
        throw IllegalArgumentException()
    } catch (e: Exception) {
        println("in catch")
        throw e
    } finally {
        println("finally")
    }
}

fun testCatch1() {
    try {
        println("in try")
        throw IllegalArgumentException()
    } catch (e: Exception) {
        println("in catch")
        return
    } finally {
        println("finally")
    }
}
fun isSubpath(src: String?, dest: String?): Boolean {
    src ?: return false
    dest ?: return false
    val srcFile = File(src)
    val desFile = File(dest)
    var parentFile = desFile.parentFile
    while (parentFile != null && parentFile.startsWith(srcFile)) {
        if (parentFile == srcFile) {
            return true
        }
        parentFile = parentFile.parentFile
    }
    return false
}