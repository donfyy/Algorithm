import java.io.File

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
    println(Test().testQuestionMark("aaaa"))
    println(Test().testQuestionMark("baaaa"))
    println(Test().testQuestionMark(null))
}