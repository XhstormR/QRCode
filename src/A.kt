import java.io.File

fun main(args: Array<String>) {
    a("""D:\QRCodeDir""")
}

fun a(s: String) {
    val map = File(s).listFiles().map { QRCode.decode(it.toString()) }.groupBy { it }.mapValues { it.value.count() }
    for ((k, v) in map) {
        println("$k：$v")
    }
}
