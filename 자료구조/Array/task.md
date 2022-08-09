배열
======

배열은 여러개의 같은 자료형의 정보들을 하나로 묶은 것입니다.
기본 자료형 전용 배열은 쓰기 쉽게 간편화되어 제공됩니다.

배열 사용법
----
생성은 다음과 같이 합니다
```kotlin
val array1: Array<Int> = arrayOf(1, 2, 3, 4, 5)
val array2: ArraY<Boolean> = BooleanArray(10) { false }
val array3: IntArray = intArrayOf(1, 2, 3, 4, 5)
```

배열 요소 접근은 다음과 같이 합니다
```kotlin
array1[0] // 1
array2[5] // false
array3[4] // 5
array1[5] // 오류!
```

배열 요소 변경은 다음과 같이 합니다
```kotlin
array1[0] = 23
array1[5] = 23 // 오류!
```