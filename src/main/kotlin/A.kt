import java.io.File

fun main(args: Array<String>) {
    a("""D:\QRCodeDir""")
}

fun a(dir: String) {
    val map: Map<String, Int> = File(dir).listFiles()
            .map { QRCode.decode(it.toString()) }
            .groupBy { it }
            .mapValues { it.value.count() }
    map
            .forEach { (k, v) -> println("$k：$v") }
}
