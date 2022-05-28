import org.junit.Test
import kotlin.random.Random

class Test {
    @Test fun testSolution() {
        val console = System.`in`
        try {
            repeat(100) {
                val left = Random.nextInt(-100, 100)
                val right = Random.nextInt(-100, 100)
                val data = "$left\n$right\n"
                System.setIn(data.byteInputStream())
                assert(solution() == left * right)
            }
        } finally {
            System.setIn(console)
        }
    }
}