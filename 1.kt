val fibItems = arrayOf(12, 45, 34, 22)

fun main() {
    println("Hello, world!")

    val greet = "Hello, world!"

    println("greet: $greet")

    println("greet sanitized: ${sanitize(greet)}")

    var n: Int? = 10

    val sanitizedN: Int = sanitizeForFib(n)

    println("fib($n): ${fib(sanitizedN)}")

    println("Printing fibItems")
    printArrayItems(batchFib(fibItems))

	println("Converting fibItems to map")

	val fibMap = convertToMap(fibItems)

	println("Printing fibMap")

	printMapItems(fibMap)
}

fun sanitize(s: String): String {
    return s.replace(Regex("[^a-zA-Z0-9]"), "_")
}

fun sanitizeForFib(n: Int?): Int {
    if (n == null) throw Exception("n is null")
    if (n < 0) throw Exception("n is negative")
    if (n > 20) throw Exception("n is too large")
    return n
}

fun fib(n: Int): Int {
    if (n <= 1) return n
    return fib(n - 1) + fib(n - 2)
}

fun batchFib(items: Array<Int>): Array<Int> {
    return items.map { fib(it) }.toTypedArray()
}

fun printArrayItems(items: Array<Int>) {
    for (item: Int in items) {
        println(item)
    }
}

fun convertToMap(items: Array<Int>): Map<Int, Int> {
	val map = mutableMapOf<Int, Int>()
	for (item: Int in items) {
		map[item] = fib(item)
	}
	return map
}

fun printMapItems(map: Map<Int, Int>) {
	for ((key, value) in map) {
		println("$key: $value")
	}
}
