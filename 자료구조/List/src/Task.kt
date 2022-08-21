import java.util.*

fun main() {
    val list: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5, 6)
    val arrayList = arrayListOf(7, 8, 9, 10)

    val combined = list + arrayList

    for(element in combined) {
        println(element)
    }
}

fun solution(length: Int): List<Int> {
    val scanner = Scanner(System.`in`)
    return (1..length).map { scanner.nextInt() + 2 }
}
