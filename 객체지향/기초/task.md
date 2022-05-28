# 객체 지향
객체 지향은 특정 문제나 구조를 모델링 한 것을 그대로 반영할 때 유용한 개념으로, 현실에 존재하는 여러 "객체" 들을 컴퓨터에 그대로 옮겨놓은 것이다.
이때 객체는, 특정 행동을 하는 존재들로서, 각각 자신만의 정보를 가지고 있음과 동시에 특정 행동을 취하여 프로그램의 흐름에 변화를 줄 수 있다.

## 객체 정의하기
객체를 정의하기 위해서는 클래스를 먼저 작성해야 한다. 그리고 그 클래스의 새로운 인스턴스를 생성한 것이 객체가 된다.

### 클래스
클래스는 객체를 만드는 방법을 기술하는 설명서와 같다, 이 설명서를 가지고 새로운 객체를 만들어 메모리에 작성한다.
클래스는 다음과 같이 작성한다:
```kotlin
class Name {
  val a = 1
  var b = 2
  
  fun f(x: Int): String {
      return "c"
  }
}
```

먼저 `class` 를 작성한 이후 클래스의 이름을 입력한다. 그 다음 중괄호를 열어 그 안에 클래스의 내용을 작성한다.
클래스 안에 들어갈 내용은 필드와 메서드가 있다. 필드는 클래스 안에 정의된 변수이고, 메서드는 클래스 안에 정의된 함수로, 클래스 내부의 모든 필드에 접근할 수 있다. ([가시성 제한자 참고][접근제한자])

...나도 왜 이름이 2개나 있는지는 모르겠지만 객체지향 프로그래밍 언어에서는 서로 같은 말로 쓰이니 그냥 참고로 알아두면 좋다.

클래스의 인스턴스 생성은 함수 호출과 비슷한데, 다음과 같이 한다:
```kotlin
Name()
val a = Name()
var b = Name()
// 이때 이 3가지 모두 메모리 다른 곳에 저장되어 있다, 즉 위 3가지는 Name 을 기반으로 생성한 3개의 다른 정보이다.
```

그리고 클래스에 정의된 변수와 함수는 다음과 같이 접근한다:
```kotlin
val name = Name()
println(name.a)
println(name.b)
name.b = 123
// name.a = 1 는 val 이라 불가능
println(name.c(2))
```

#### 생성자 기초
게임을 개발한다고 했을 때, 다음과 같은 클래스를 만들었다고 해보자.
```kotlin
class Player {
    var name = ""
    var ip = ""
    var id = 0
}
```
그리고 새로운 플레이어가 서버에 접속할 때 마다 새로운 `Player` 객체가 필요한데, 이때 `name`, `ip`, 그리고 `id` 를 따로 다시 지정해 주어야 한다.
```kotlin
val p = Player()
p.name = "bbb"
p.ip = "127.0.0.1"
p.id = 123897
```
하지만 이를 생성자를 활용하면 간단하게 줄일 수 있다.
```kotlin
val p = Player("bbb", "127.0.01", 123897)
```
클래스 이름 뒤에 적던 소괄호는 장식이 아니다. 이 소괄호는 생성자에

생성자는 클래스의 인스턴스를 만들어 주는 함수, 또는 메서드를 칭하는 것이다, 그렇기에 인자가 있을 수도 있고 없을 수도 있다.
맨 처음 클래스 정의 방법에 대해 배울 때는 생성자를 언급하지도 않았고, 만들지도 않았는데 인스턴스를 만들 수 있던 이유는
Kotlin 에서 기본 생성자를 만들어 주기 때문이다. 기본 생성자는 받는 인자가 없다.
그러나 현재 상황에서는 우리가 직접 생성자를 정의해야 한다, 위처럼 인자를 몇개 받도록 해야 한다.
```kotlin
class Player(name: String, ip: String, id: Int) {
    var name = ""
    var ip = ""
    var id = 0
}
```

위처럼 `Player` 다음에 함수 인자들을 정의하는 것과 동일하게 생성자의 인자들을 정의할 수 있다.
하지만 이는 생성자의 인자들을 정의하지만, 그게 끝이다, `Player#name` 의 값을 변경하지 않는다, 생성자의 구현은 작성하지 않았다.
또한 생성자의 인자는 오직 클래스의 생성자 안에서만 사용할 수 있다, 다른 곳에선 사용할 수 없다.
그렇기에 괄호 안에 정의한 `name`, `ip`, `id` 는 생성자에서만 사용할 수 있다.

생성자의 구현은 다음과 같이 `init` 안에 작성한다.

```kotlin
class Player(name: String, ip: String, id: Int) {
    init {
        this.name = name
        this.ip = ip
        this.id = id
    }
    var name = ""
    var ip = ""
    var id = 0
}
```

`this.name` 은, 이 클래스에 정의된 필드 `Player#name` 을 칭하는 것이다, 생성자의 인자와 이름이 동일하니 혼동을 피하기 위해서 `this` 를 사용했다.
생성자의 인자와 이름이 다르다면 `this` 를 사용하지 않아도 된다.
```kotlin
class Player(a: String, b: String, c: Int) {
    init {
        name = a
        ip = b
        id = c
    }
    var name = ""
    var ip = ""
    var id = 0
}
```

생성자도 또 하나의 함수이기 때문에 변수값 변경 말고도 다른 일들을 할 수 있다.

```kotlin
class Player(name: String, ip: String, id: Int) {
    var name = ""
    var ip = ""
    var id = 0
    
    init {
        this.name = name
        this.ip = ip
        this.id = id
        
        println("Created!")
    }
}
```

근데 생성자를 변수 값 지정하는데만 쓸꺼면 다음처럼 더 간결하게 작성할 수도 있다.

```kotlin
class Player(val name: String, val ip: String, val id: Int) {
    init {
        println("Created!")
    }
}
```
위 문법은 생성자에서만 허용된다, 생성자의 인자를 지정함과 동시에, 같은 이름이 클래스의 필드를 만들어 준다, 그리고 변수 지정까지 자동으로 다 해준다.

### 상속과 구현
가끔 클래스를 만들 때, 여러 클래스에 동일한 함수가 필요한 경우가 있을 수 있다.

```kotlin
class Monster {
    fun die() {
        // .....
    }
}

class Animal {
    fun die() {
        // .....
    }
}
```
이때 상속을 활용하면 `die` 를 한번만 정의해도 위 `Monster` 와 `Animal` 둘 다 `die` 라는 함수를 가지도록 할 수 있다.

```kotlin
open class LivingThing {
    fun die() {
        // ....
    }
}

class Monster: LivingThing() {
    // ...
}

class Animal: LivingThing() {
    // ....
}
```

`클래스 이름: 상속할 클래스 이름()` 식으로 작성한다.
상속할 클래스는 `open` 과 함께 정의되어야만 하며
이때, `LivingThing` 은 부모 클래스, 또는 상위 클래스라고 하며 `Monster` 와 `Animal` 은 `LivingThing` 의 하위 클래스, 또는 자식 클래스라고 한다.
`LivingThing` 에 존재하는 모든 변수와 함수는 [`private`][접근제한자] 만 아니라면 `Monster` 와 `Animal` 에서 사용할 수 있다.
만약 부모 클래스에 생성자가 있다면 다음과 같이 작성해야 한다:

```kotlin
open class Parent(val a: Int) {
    
}

class Child1(a: Int): Parent(a) {
    init {
        println(a)
    }
}

class Child2: Parent(2) {
    init {
        println(a)
    }
}
```

이러면 다음과 같은 것이 가능해 지는데
```kotlin
fun main() {
    val p: Parent = Child1(23)
    val p2: Parent = Child2()
    test(p)
    test(p2)
    test(Child2())
}

fun test(i: Parent) {
    println(i.a)
}
```
즉, `Child1` 과 `Child2` 를 `Parent` 로 안전하게 형변환 시킬 수 있다, `Child1` 과 `Child2` 에는 `Parent` 에 있는 모든 것이 포함되어 있을테니 안전함을 알 수 있다.

그런데 함수의 존재만 정의하고 싶을 때가 있다, 예를 들어 데이터베이스를 만든다고 할 때, 인터넷에 저장하거나 파일에 저장한다고 하면
```kotlin
class NetworkDB {
    fun save() {
        // ....
    }
}

class FileDB {
    fun save() {
        // ....
    }
}
```

이런 상황에서, 이때 `NetworkDB` 와 `FileDB` 에 이름과 인자가 같은 `save()` 함수가 있지만 그 내용은 달라져야 하는데 그 내용은 달라야 한다.
이때 인터페이스를 사용할 수 있다.

```kotlin
interface Database {
    fun save()
}

class NetworkDB : Database {
    override fun save() {
        // 네트워크 관련된 코드
    }
}

class FileDB : Database {
    override fun save() {
        // 파일 관련 코드
    }
}
```

이때, `NetworkDB` 와 `FileDB` 는 `Database` 를 구현한다고 한다. 상속이라고 하지 않는 것은 `Database` 로 부터 실질적으로 상속해 받아오는 것이 없다.
그렇기에 인터페이스는 클래스의 규격이라고 볼 수 있다.
그리고 다음과 같은 코드가 가능하다:
```kotlin
fun verify(db: Database) {
    db.save()
}
```
이 함수는 `Database` 를 구현하는 모든 클래스와 호환된다, 왜냐하면 뭐가 오든간에 `save` 함수는 존재할 테니 말이다.

상속은 하나만 되지만 구현은 여러개가 가능하다. 또한 상속과 구현을 동시에 할 수 있다.

```kotlin
open class Parent1 {
    
}

open class Parent2 {
    
}

interface Interface1 {
    
}

interface Interface2 {
    
}

class Child1: Parent1(), Parent2() { // 불가능
    
}

class Child2: Parent1(), Interface1, Interface2 // 가능

```

그런데, 위에서 `override` 란 키워드를 사용한 적이 있다.
이 키워드의 역할은, 상속받은 것을 덮어 씌울때, 또는 인터페이스로부터 구현을 강요받은 것을 구현할 때 사용한다.
```kotlin
open class Parent{
    fun print() {
        println("parent")
    }
}

class Child: Parent(){
    override fun print() {
        println("child")
    }
}

fun main() {
    Child().print()
}
```
위 프로그램의 출력은 "child" 이다, `Child` 의 `print` 가 `Parent` 로 부터 상속받은 `print` 를 덮어씌운 것이다. Override 는 덮어씌움을 강조할 때 사용된다.


### 가시성
클래스를 작성하다보면 외부에서 변경하거나 읽을 필요가 없는 값들이 있을 수도 있다. 또는 라이브러리를 만든다고 했을 때, 라이브러리 사용자들이
건들면 안될만한 값들이나 사용하면 안될 함수들이 있을 수도 있다. 이때는 외부에서 접근 가능 여부를 결정하는 가시성 제한자를 사용한다.
```kotlin
class NetworkStatus {
    private var ip = ""
    var connected = false
    
    private fun getCredentials(): String {
        ip = "bbbb"
    }
    
    fun test() {
        ip = "cccc"
    }
}

fun main() {
    val status = NetworkStatus()
    status.ip = "aaa" // 불가능
    status.connected = true // 가능
    
    status.getCredentials() // 불가능
    status.test() // 가능
}
```

가시성 제한자는 4 종류가 있다: `private`, `protected`, `internal`, 그리고 `public` 이 있다.
`private` 는 같은 클래스 안에서만 사용할 수 있도록 한다, 자식 클래스에서도 조차 사용할 수 없다.
`protected` 는 같은 클래스 또는 자식 클래스에서 사용할 수 있도록 한다.
`internal` 은 같은 모듈 안에서만 사용할 수 있도록 한다, 동일한 프로젝트에 정의된 클래스들이면 다 사용할 수 있다.
`public` 은 모든 곳에서 사용할 수 있도록 한다.

[접근제한자]: #가시성