import org.junit.Test
import kotlin.random.Random
import kotlin.random.nextInt

class Test {
    @Test fun testSolution() {
        repeat(1000) {
            when(val number = Random.nextInt(0 until 20)) {
                0 -> assert(solution(number) == -9)
                1 -> assert(solution(number) == 1239)
                2 -> assert(solution(number) == -23)
                3 -> assert(solution(number) == 53)
                4 -> assert(solution(number) == -91245)
                5 -> assert(solution(number) == -12)
                6 -> assert(solution(number) == -7821)
                7 -> assert(solution(number) == -45639)
                8 -> assert(solution(number) == 741589)
                9 -> assert(solution(number) == -152)
                else -> assert(solution(number) == 0)
            }
        }
    }
}