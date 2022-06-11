import org.junit.Assert
import org.junit.Test
import kotlin.random.Random

class Test {
    @Test fun testSolution() {
        repeat(1000) {
            val b = Random.nextBoolean()
            val number = solution(b)

            if (b) assert(number % 2 == 0)
            else assert(number % 2 == 1)
        }
    }
}