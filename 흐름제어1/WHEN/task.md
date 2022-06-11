WHEN
======
If문 여러개 간소화하기


when 은 다음과 같은 형태로 사용할 수 있습니다
```kotlin
val a = 11
when {
    a == 1 -> println(1)
    a == 2 -> println(2)
    a == 3 -> println(3)
}
```

```kotlin
when {
    <boolean> -> 코드
    <boolean> -> 코드
    <boolean> -> 코드
    <boolean> -> 코드
    <boolean> -> 코드
    <boolean> -> 코드
    <boolean> -> 코드
    <boolean> -> 코드
    <boolean> -> 코드
    <boolean> -> 코드
    <boolean> -> 코드
    ....
}
```

또는 다음과 같이 사용할 수 있습니다
```kotlin
val a = 123
when(a) {
    1 -> println(1)
    2 -> println(2)
    3 -> println(3)
    4 -> println(4)
    5 -> println(5)
    6 -> println(6)
    7 -> println(7)
}
```

```kotlin
when(정보) {
    정보와 비교할것1 -> 코드
    정보와 비교할것2 -> 코드
    정보와 비교할것3 -> 코드
    정보와 비교할것4 -> 코드
    정보와 비교할것5 -> 코드
    정보와 비교할것6 -> 코드
    정보와 비교할것7 -> 코드
    정보와 비교할것8 -> 코드
}
```

만약 when 에 작성한 모든 비교 구문과 해당하지 않을 때 어떠한 코드를 실행하도록 하고 싶으시다면, 다음처럼 할 수 있습니다:
```kotlin
// 비교 1,2,3,4 가 전부다 false 일 경우 else 를 실행함
when {
    비교1 -> 코드
    비교2 -> 코드
    비교3 -> 코드
    비교4 -> 코드
    else -> 코드
}

val a = 23549078
// 아래 when 구문은 else 에 적힌 코드를 실행함
when(a) {
    1 -> 코드
    2 -> 코드
    3 -> 코드
    4 -> 코드
    else -> 코드
}
```