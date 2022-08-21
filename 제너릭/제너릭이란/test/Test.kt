import junit.framework.TestCase.assertEquals
import org.junit.Test

class Test {
    @Test
    fun testSolution() {
        val instance = GenericTest<Comparable<*>>()
        val dArray: Double = instance.get<Double>(1.0, 2.0, 3.0, 4.0)
        val iArray: Int = instance.get<Int>(1, 2, 3, 4)
        val sArray: String = instance.get<String>("a", "b", "c", "d")

        assertEquals("Double 이 일치하지 않습니다!", 3.0, dArray)
        assertEquals("Int 이 일치하지 않습니다!", 3, iArray)
        assertEquals("String 이 일치하지 않습니다!", "c", sArray)
    }
}