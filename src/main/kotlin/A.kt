import java.io.File

fun main(args: Array<String>) {
    a("""D:\QRCodeDir""")
}

fun a(dir: String) {
    File(dir).listFiles()
            .map { QRCode.decode(it.toString()) }
            .groupBy { it }
            .mapValues { it.value.count() }
            .forEach { k, v -> println("$k : $v") }
}
