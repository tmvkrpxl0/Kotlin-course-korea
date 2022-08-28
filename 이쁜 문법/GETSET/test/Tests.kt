import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        val house = House("name")
        repeat(10) {
            house.enter()
        }
        Assert.assertEquals("집 상태 메세지가 다릅니다!", "name 10", house.status)
        house.status = "ffff 3"
        Assert.assertEquals("ffff", house.name)
        Assert.assertEquals(house.count, 3)
    }
}