import org.junit.Test
import java.io.ByteArrayInputStream

class Test {
    @Test fun testSolution() {
        val consoleInput = System.`in`
        try{
            repeat(100) {
                val data = "$it\n"
                System.setIn(ByteArrayInputStream(data.toByteArray()))
                assert((solution() as Int) == it) { "입력과 출력이 같지 않음!" }
            }
        } finally {
            System.setIn(consoleInput)
        }
    }
}