class GenericTest<T> {
    fun run(input: T): T {
        return input
    }
}

fun main() {
    val g = GenericTest<String>()
    g.run("a")
}