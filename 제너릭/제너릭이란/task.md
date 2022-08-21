제너릭
=====

정수 배열의 크기를 반환하는 함수를 만든다고 해보자
```kotlin
fun sizeOf(array: Array<Int>): Int {
    return array.size
}
```

근데 위 함수가 Array<Int> 말고도 Array<String>, Array<Double>, 그리고 다른 모든 자료형과 잘 작동하도록 만들고 싶다면 어떻게 해야 할까?
그리고 가만 생각해보면 Array 뒤의 <> 는 무엇일까?

제너릭은 자료형 안에 다른 자료형을 담는 것이며, <> 는 어떤 자료형이 담겨져 있는지를 표시하는 것이다
* Array<Int> - Array 라는 자료형에 Int 라는 또 다른 자료형을 담은 것
* Stream<Array<Byte>> - Stream 이라는 자료형에 Byte 를 담고 있는 Array 를 담은 것

아래 코드는 모든 형태의 Array 들을 받을 수 있는 함수이다. * 은 프로그래머 사이에서 "모든 것" 이라는 뜻을 가지고 있어 kotlin 에서도 이를 채택하였다.
```kotlin
fun sizeOf(array: Array<*>): Int {
    return array.size
}
```

또한 다음처럼 제너릭 안에 또 제너릭을 사용할 수도 있다.
```kotlin
fun sizeOf(array: Array<Comparable<*>>): Int {
    return array.size
}
```

### 제너릭 함수 정의하기
```kotlin
import java.io.Serializable

fun <A, B, C: A, HI> generic(input: C): HI {
    // ....
}

fun <A> test(): A where A: Serializable, A: Comparable<*> {
    // ....
}

// 사용법
fun main() {
    generic<Comparable<*>, Int, String, Double>("a")
    test<String>() // String 은 Serializable, Comparable 둘다 구현함
}
```

### 제너릭 클래스 정의하기
```kotlin
class GenericTest<T> {
    fun run(input: T): T {
        return input
    }
}

fun main() {
    val g = GenericTet<String>()
    g.run("asdf")
}
```