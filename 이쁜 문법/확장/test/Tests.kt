import org.junit.Assert
import org.junit.Test
import kotlin.random.Random
import kotlin.random.nextInt

class Test {
    @Test fun testSolution() {
        repeat(32) {
            val randomPower = Random.nextInt(0..30)
            Assert.assertEquals((1.shl(randomPower)), Int.binPowerOf(randomPower))
            val up = Random.nextDouble()
            val down = Random.nextDouble(2.0, 10000.0)
            Assert.assertEquals(up/down, Double.fraction(up, down), 0.3)
        }

        Assert.assertEquals(-1, Int.negativeOne)
    }
}