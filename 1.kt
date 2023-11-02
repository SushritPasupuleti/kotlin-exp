fun main() {
	println("Hello, world!")

	val greet = "Hello, world!"

	println("greet: $greet")

	println("greet sanitized: ${sanitize(greet)}")

	var n: Int? = 10;

	val sanitizedN: Int = sanitizeForFib(n);

	println("fib($n): ${fib(sanitizedN)}")
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
