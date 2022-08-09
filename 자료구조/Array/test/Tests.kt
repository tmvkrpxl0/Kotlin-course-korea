import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        val array: Array<String> = part1()
        Assert.assertEquals("배열 크기가 맞지 않습니다!", 10, array.size)
        Assert.assertArrayEquals("배열 내용이 같지 않습니다!", array,
            arrayOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")
        )

        val modified = part2(array)
        Assert.assertArrayEquals("배열 내용이 변경되지 않습니다!", array,
            arrayOf("a", "b", "C", "d", "e", "f", "g", "h", "i", "j")
        )
    }
}