import org.junit.Assert
import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.random.Random
import kotlin.random.nextInt

class Test {
    @Test fun testSolution() {
        val `in` = System.`in`

        val length = Random.nextInt(50..200)

        val testData = (1..length).map { Random.nextInt(-2000000..2000000) }.toIntArray()
        val inputString = testData.joinToString("\n", postfix = "\n")
        System.setIn(inputString.byteInputStream())

        val toCheck = testData.map { it + 2 }

        val result: List<Int> = solution(length)

        System.setIn(`in`)
        Assert.assertArrayEquals(toCheck.toIntArray(), result.toIntArray())
    }
}