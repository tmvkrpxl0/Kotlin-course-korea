while
=======

while 은 if 와 매우 비슷한 구조를 가진다


```kotlin
if (a > 100) {
    
}

while (a > 100) {
    
}
```
기능상 차이점은 괄호 안의 조건이 실패할 때 까지 계속 반복한다는 것이다.
아래 코드는 총 10번 실행된다
```kotlin
var a = 0
while (a < 10) {
    a += 1
    println("repeat")
}
```