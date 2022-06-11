조건문
=====
조건문은, 특정한 조건이 참, 또는 거짓이냐에 따라 프로그램이 다른 행동을 취하도록 만드는 것입니다.
대부분의 프로그래밍 언어에서 흐름 제어를 할 때 사용하는 키워드는 if, when, while 등이 있습니다.
이번 레슨에서는 if 에 대해 다루어 보도록 하겠습니다.



Boolean
-----
Boolean 은 1비트의 값을 다루는 자료형으로, true 또는 false 일 수 있습니다.
```kotlin
val f: Boolean = false
val t: Boolean = true
```
그리고 다음과 같이, 참 또는 거짓이 나오는 구문들을 사용할 수도 있습니다.
```kotlin
val isEqual: Boolean = 1 == 1 // true
val isBigger: Boolean = 1 > 123 // false
val isEqualOrLess: Boolean = 1 <= 123 // true
```

또는 다음처럼 함수값을 사용할 수도 있습니다.
```kotlin
val result: Boolean = isEven(123) // false

fun isEven(n: Int): Boolean {
    return n % 2 == 0
}
```

if
----
if 는 Boolean 형태의 정보를 이용해 조건적으로 코드를 실행합니다.
```kotlin
if (true) {
    println(1)
}
if (false) {
    println(2)
}
// 위 코드의 출력은 1
```

if 문의 구조는 다음과 같습니다
```kotlin
if (<boolean 값>) {
    코드
}
```
if 이후에 else 또는 else if 를 붙일 수도 있습니다:
```kotlin
if (1 > 1230) {
    // false이기에 실행되지 않음
} else {
    // 윗 부분이 실패할 경우에만 실행되는 부분
    // 윗 부분이 실패하였기 떄문에 여기있는 코드는 실행됨
}
```

아래 코드는 위에서부터 아래로 내려가며 차례대로, test1(), test2(), test3() 의 결과들을 확인합니다.
그리고, 이 3가지중 하나라도 먼저 성공하면, 나머지를 확인하지 않고 바로 해당하는 구문을 실행합니다.
이 3가지다 실패하면 마지막 else 를 실행합니다.

아래 메세지 출력문 4개중 하나만 실행된다는 것입니다.
```kotlin
if (test1()) {
    println("1")
} else if (test2()) {
    println("2")
} else if (test3()) {
    println("3")
} else {
    println("전부 실패함")
}
```