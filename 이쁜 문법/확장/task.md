확장
=======

확장이미 다른 사람이 정의한 클래스에 새로운 요소를 추가하는 것

```kotlin
val Int.str: String
    get() {
        return toString()
    }

fun Int.isEven(): Boolean {
    return this % 2 == 0
}

fun main() {
    println(2.isEven()) // true
}
```