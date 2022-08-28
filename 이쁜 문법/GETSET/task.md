Get/Set
=======

변수의 값을 가져오거나 설정할 때 실행할 코드를 지정하는 기능
변수 읽기, 쓰기시 실행할 코드를 수정할 수 있다, 무려 가시성도 지정할 수 있다.

또한 "가상" 변수를 만들 수도 있다.

```kotlin
class Special {
    var count: Int = 2
      private set
  
    var asString: String // 가상 변 
      get() {
          return count.toString()
      }
      set(value) {
          val i = value.toInt()
          count = i
      }
}

fun main() {
    val s = Special()
    println(s.count)
    s.count = 120 // 안됨
  
    println(s.asString) // 2
    s.asString = "-2"
    println(s.asString) // -2
    println(s.count) // -2
}
```