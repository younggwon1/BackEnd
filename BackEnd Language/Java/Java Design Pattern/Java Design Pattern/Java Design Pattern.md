# Java Design Pattern



### Step 1. 디자인 패턴이란?

**디자인 패턴이란 어떤 상황의 문제에 대한 해법이다.** 즉, 소프트웨어를 설계할 때 특정 맥락에서 자주 발생하는 고질적인 문제들이 또 발생했을 경우 재사용할 수 있도록 해주는 해결책이다.

소프트웨어 공학론 안의 좋은 코드를 설계하기 위한 일종의 설계 디자인 방법론이다. 좋은 코드란 디자인 패턴에서는 설계적 관점에서의 좋은 코드를 말한다. 즉, 확장과 수정에 용이하여 설계 이후에도 추가적인 유지 보수 비용이 적게 들어가는 코드를 말한다.

객체 지향적으로 생각하면, 추구해야할 설계 방향은 다음과 같다.

> 객체 간 응집도는 높이고, 결합도는 낮게. 요구사항 변경시 코드 변경을 최소화하는 방향으로..

디자인 패턴은 알고리즘이 아니라 상황에 따라 자주 사용하는 설계 방법을 정리한 코딩 방법론일 뿐이며, 모든 상황의 해결책은 아니다.



#### 패턴이란?

1. 각기 다른 소프트웨어 모듈이나 기능을 가진 다양한 응용 소프트웨어 시스템들을 개발할 때도 **서로 간의 공통되는 설계 문제가 존재하며 이를 처리하는 해결책 사이에도 공통점이 있다.** 이러한 유사점을 패턴이라고 한다.

2. 패턴에는 다음의 4가지 요소가 반드시 들어가 있다.
   - 패턴 이름(Pattern name) : 몇개의 단어로 설계 문제와 해법을 서술한다.
   - 문제(Problem) : 언제 패턴을 사용하는가를 서술하며, 해결할 문제와 그 배경을 설명한다.
   - 해법(Solution) : 설계를 구성하는 요소들과 그 요소들간의 책임, 협력관계를 서술한다.
   - 결과(Consequence) : 디자인 패턴을 적용해서 얻는 결과와 장단점을 서술한다.



#### 디자인 패턴 구조

- 콘텍스트(context)
  - 문제가 발생하는 여러 상황을 기술한다. 즉, 패턴이 적용될 수 있는 상황을 나타낸다.
  - 경우에 따라서는 패턴이 유용하지 못한 상황을 나타내기도 한다.
- 문제(problem)
  - 패턴이 적용되어 해결될 필요가 있는 여러 디자인 이슈들을 기술한다.
  - 이때 여러 제약 사항과 영향력도 문제 해결을 위해 고려해야 한다.
- 해결(solution)
  - 문제를 해결하도록 설계를 구성하는 요소들과 그 요소들 사이의 관계, 책임, 협력 관계를 기술한다.
  - 해결은 반드시 구체적인 구현 방법이나 언어에 의존적이지 않으며 다양한 상황에 적용할 수 있는 일종의 템플릿이다.
    

### Step 2. 디자인 패턴의 분류법

GoF의 디자인 패턴에는 **23가지의 디자인 패턴들이 존재**하며, 이것을 디자인 패턴 카탈로그라고 명명하고 있다.

따라서 23가지의 다양한 패턴들은 저마다 추상화 수준이 천차만별이므로 조직화를 시켜서 디자인 패턴을 분류하였다.

<u>**디자인 패턴 분류 방법**</u>

1. 목적(Purpose)
   - 디자인 패턴은 **생성, 구조, 행동** 중의 한 가지의 목적을 갖는다는 전제하로 분류된다.
2. 범위(Scope)
   - 패턴을 적용하는 대상이 **클래스인지 객체인지를 구분**하는 것이다.

<u>**생성패턴**의 목적은 **객체의 생성 과정에 관여**하는 것이다.</u> 

- 객체를 생성하거나, 합성하는 방법 등을 애플리케이션 코드와 분리하게 되면 누가, 언제, 어디서, 무엇을, 어떻게, 왜 변경하든지 상관없어지는 유연성을 확보할 수 있다.

- 객체의 생성과 조합을 캡슐화해 특정 객체가 생성되거나 변경되어도 프로그램 구조에 영향을 크게 받지 않도록 유연성을 제공한다.

- <u>생성 클래스 패턴</u>은 객체를 생성하는 책임의 일부를 서브클래스가 담당하도록 넘기는 것이다.
- <u>생성 객체 패턴</u>은 이를 다른 객체에 위임하는 것이다.

<u>**구조패턴**의 목적은 **클래스나 객체의 합성**이다.</u>

- 더 큰 구조를 형성하기 위해서 어떻게 클래스와 객체를 합성하는지와 관련된 패턴이다.

- <u>구조 클래스 패턴</u>은 상속을 이용해서 클래스를 복합하는 것이다.
- <u>구조 객체 패턴</u>은 새로운 기능을 실현하기 위해 객체를 합성하는 방법을 정의한다.
- 예를 들어 서로 다른 인터페이스를 지닌 2개의 객체를 묶어 단일 인터페이스를 제공하거나 객체들을 서로 묶어 새로운 기능을 제공하는 패턴이다.

<u>**행동패턴**의 목적은 **클래스나 객체들이 상호작용하는 방법과 책임의 분산**이다.</u>

- <u>행동 클래스 패턴</u>은 상속을 이용해서 알고리즘과 제어 흐름을 기술하는 것이다. 즉, 클래스 사이에 행동 책임을 분산하기 위해서 상속을 사용한다.

- <u>행동 객체 패턴</u>은 하나의 작업을 수행하기 위해 객체 집합이 어떻게 협력하는지를 기술한다. 즉, 상속보다는 복합을 통해서 객체 사이에 행동 처리의 책임을 분산시킨다.

  => 하나의 객체가 스스로 모든 처리를 하는 것이 아니라, 관련된 객체들이 하나의 처리를 책임지는 방법이다.

- 객체간의 제어 구조보다는 객체들을 어떻게 연결시킬 것인지에 더 중점을 두는 패턴이다.

- 한 객체가 혼자 수행할 수 없는 작업을 여러개의 객체로 어떻게 분배하는지, 또 그렇게 하면서도 객체 사이의 결합도를 최소화하는 것에 중점을 둔다.



#### 분류된 디자인 패턴

![스크린샷 2020-09-17 오전 10 31 16](https://user-images.githubusercontent.com/42603919/93409100-14db6f80-f8d1-11ea-865a-ae86684e5a31.png)



#### 생성 패턴

1. 추상 팩토리(Abstract Factory)

   - 여러 객체가 하나의 클래스 내에서 선언될 수 있도록 해주는 패턴이다.
   - 구체적인 클래스에 의존하지 않고 서로 연관되거나 의존적인 객체들의 조합을 만드는 인터페이스를 제공하는 패턴이다.
   - 상세화된 서브클래스를 정의하지 않고도 서로 관련성이 있거나 독립적인 여러 객체의 군을 생성하기 위한 인터페이스를 제공한다.
   - 많은 수의 연관된 서브 클래스를 특정 그룹으로 묶어 한번에 교체할 수 있도록 만들었다.

2. 팩토리 메서드(Factory Method)

   - 객체를 생성하는 인터페이스는 미리 정의하되, 인스턴스를 만들 클래스의 결정은 서브 클래스 쪽에서 내리는 패턴이다.

     = > 여러개의 서브 클래스를 가진 슈퍼 클래스가 있을 때 input에 따라 하나의 자식 클래스의 인스턴스를 리턴해주는 방식이다.

   - 객체 생성 처리를 서브 클래스로 분리해 처리하도록 캡슐화하는 패턴이다. 즉, new 키워드를 호출하는 부분을 서브 클래스에 위임하는 것이다.
   - 이 패턴은 인스턴스화에 대한 책임을 객체를 사용하는 클라이언트에서 팩토리 클래스로 가져온다.
   - 팩토리 메서드 패턴을 사용하는 이유는 클래스간의 결합도를 낮추기 위해서이다.
   - 객체를 만들어 반환하는 함수를 제공하여 초기화 과정을 외부에서 보지 못하게 숨기고 반환 타입을 제어하는 방법이다.
     - 아예 다른 객체를 직접 만들어 넘겨주는 객체를 따로 만드는 것
     - 팩토리 기능을 하는 함수가 자기 자신에 포함되어 있고 생성자 대신 사용하는 것

3. 빌더(Builder)

   - 복잡한 객체를 생성하는 방법과 표현하는 방법을 정의하는 클래스를 별도로 분리하여, 서로 다른 표현이더라도 이를 생성할 수 있는 동일한 절차를 제공하는 패턴이다.
   - 생성자에 들어갈 매개변수가 많든 적든 차례대로 매개변수를 받아들이고 모든 매개변수를 받은 뒤에 이 변수들을 통합해서 한번에 사용한다.
   - 인스턴스를 생성자를 통해 직접 생성하지 않고, 빌더라는 내부 클래스를 통해 간접적으로 생성하게 하는 패턴이다.
   - 사용목적
     - 클래스와 사용 대상의 결합도를 낮추기 위해
     - 생성자에 전달하는 인수에 의미를 부여하기 위해

4. 프로토타입(Prototype)

   - 인스턴스를 생성할 때 사용하는 패턴으로 원본을 만들어 놓고 원본 객체를 복사하여 사용하는 방식이다.
   - 파생 클래스의 개수가 많아지지만 각 클래스의 메서드가 수행하는 알고리즘 차이가 없고 생성 시 객체의 속성에 차이만 있다면 Prototype을 사용하는 것이 효과적이다.

5. 싱글턴(Singleton)

   - 어떤 클래스의 인스턴스가 오직 하나임을 보장하며, 이 인스턴스에 접근할 수 있는 전역적인 접촉점을 제공하는 패턴이다.
   - 하나의 클래스에 단 하나의 인스턴스를 허용하는 패턴이다.
   - 즉, 인스턴스가 1개밖에 존재하지 않는 것을 보증하는 패턴이다.
   - 전역 변수를 사용하지 않고 객체를 하나만 생성하도록 하며, 생성된 객체를 어디에서든지 참조할 수 있도록 하는 패턴
   - 종류
     - Eager Initialization
       - 싱글톤 클래스의 인스턴스를 클래스 로딩 단계에서 생성하는 방법. 그러나 애플리케이션에서 해당 인스턴스를 사용하지 않더라도 인스턴스를 생성하기 때문에 자칫 낭비가 될 수 있다.
       - 이 방법을 사용할 때는 싱글톤 클래스가 다소 적은 리소스를 다룰 때이어야한다.
       - Exception에 대한 Handling도 제공하지 않는다.
     - Static Block Initialization
       - Static block을 통해서 Exception Handling에 대한 옵션을 제공.
       - 클래스 로딩 단계에서 인스턴스를 생성하기 때문에 큰 리소스를 다루는 경우에는 적합하지 않다.
     - Lazy Initialization
       - global access 한 getInstance() 메소드를 호출할 때에 인스턴스가 없다면 생성합니다.
       - 사용하지 않았을 경우 인스턴스 낭비에 대한 문제는 어느정도 해결책이 되지만, multi-thread 환경에서 동기화 문제가 있다. 따라서 구현을 해도 괜찮은 경우는 single-thread 환경이 보장됐을 때입니다.
     - Thread Safe Singleton
       - getInstance() 메소드에 synchronized를 걸어두는 방식이다. 
       - synchronized 키워드는 임계 영역(Critical Section)을 형성해 해당 영역에 오직 하나의 쓰레드만 접근 가능하게 해준다. => 멀티 쓰레드 환경에서도 정상 동작.
       - 하지만 synchronized 키워드 자체에 대한 비용이 크기 때문에 싱글톤 인스턴스 호출이 잦은 **어플리케이션에서는 성능이 떨어지게 된다.** 그래서 고안된 방식이 double checked locking 이다.
     - Bill Pugh Singleton Implementation
       - inner static helper class를 사용하는 방식이다.
       - 앞선 방식이 가지고 있는 문제점들을 대부분 해결한 방식으로, 현재 가장 널리 쓰이는 싱글톤 구현 방법이다.
     - Enum Singleton
       - 앞서 1~5번에서 살펴본 싱글톤 방식은 사실 완전히 안전할 수 없다. 왜냐하면 Java의 Reflection을 통해서 싱글톤을 파괴할 수 있기 때문이다.
       - Enum으로 싱글톤을 구현하는 방법을 제안했다.
       - 사용하지 않았을 경우의 메모리 문제를 해결하지 못한 것과 유연성이 떨어진다는 면에서의 한계를 지니고 있다.

#### 구조 패턴

1. Adapter
   - 클래스의 인터페이스를 클라이언트(사용자)가 기대하는 다른 형태의 인터페이스로 변환한다.
   - 서로 일치하지 않는(호환성이 없는) 인터페이스를 갖는 클래스들을 함께 동작할 수 있게하는 목적
   - 호환성이 없는 인터페이스 때문에 함께 사용할 수 없는 클래스를 개보하여 함께 작동하도록 해준다.
2. Bridge
   - 추상화(abstraction)와 구현(implementation)을 분리하여 각각을 독립적으로 변형(다양성)할 수 있게하는 패턴이다.
   - 이로써 구현 자체도 하나의 추상화 개념으로 다양한 변형이 가능해지고, 구현과 독립적으로 인터페이스도 다양함을 가질 수 있게 된다.
3. Composite
   - 클라이언트가 복합 객체(group of object)나 단일 객체를 동일하게 취급하는 것을 목적으로 하는 패턴이다.
   - 부분과 전체의 계층을 표현하기 위해 객체들을 모아 트리 구조로 구성하기 위한 패턴이다.
- 여러개의 객체들로 구성된 복합 객체와 단일 객체를 클라이언트에서 구별없이 다루게 해주는 패턴이다.
   
4. Decorator
   - 객체의 결합을 통해 기능을 동적으로 유연하게 확장할 수 있게 해주는 패턴이다.
   - 객체에 동적으로 새로운 책임을 추가할 수 있게 한다. 기능을 추가하려면, 서브클래스를 생성하는 것보다 융통성 있는 방법을 제공한다.
   - 주어진 상황 및 용도에 따라 어떤 객체에 책임을 덧붙이는 패턴으로, 객체에 추가적인 요건을 동적으로 첨가하며, 기능확장이 필요할 때 서브클래싱 대신 쓸 수 있는 유연한 대안이 될 수 있다.
5. Facade
   - 서브 시스템(내부 구조)에 있는 인터페이스 집합에 대해서 하나의 통합된 인터페이스를 제공한다. 
   
   - 서브 시스템을 좀 더 사용하기 편하게 하기 위해서 높은 수준의 인터페이스를 정의한다.
   
   - 하나의 인터페이스에서 복잡한 서브시스템을 통합하여 동작시킬 수 있도록 제공해주는 패턴이다.
   
     => 즉, 복잡한 일련의 작업들이 있을 때, 이를 사용자가 이해하기 쉽게끔 하나의 큰 인터페이스에서 하나의 객체인 것처럼 다루게 된다.
6. Flyweight
   
   - 비용이 큰 자원을 공통으로 사용할 수 있도록 만드는 패턴이다.
   
     - 비용이 크다는 것
       - **중복 생성될 가능성이 높은 경우**
       - **자원 생성 비용은 큰데 사용빈도가 낮은 경우**
   
   - 작은 크기의 객체들이 여러개 있는 경우, 객체를 효과적으로 사용하는 방법으로 객체를 공유하게 된다.
   
   - 어떤 클래스의 인스턴스 한 개만 가지고 여러개의 "가상 인스턴스"를 제공하고 싶을 때 사용하는 패턴이다.
   
     => 즉, 인스턴스를 가능한대로 공유시켜 쓸데없이 new 연산자를 통한 메모리 낭비를 줄이는 방식이다.
7. Proxy
   
   - 실제 기능을 수행하는 객체(real object) 대신 가상의 객체(proxy object)를 사용해 로직의 흐름을 제어하는 디자인 패턴이다.
   - 다른 객체로의 접근을 통제하기 위해서 다른 객체의 대리자 또는 다른 객체로의 정보 보유자를 제공한다.
   - 다른 객체를 대변하는 객체를 만들어서 주 객체에 대한 접근을 제어할 수 있다.



#### 행동 패턴

1. Observer
   - 한 객체의 상태 변화에 따라 다른 객체의 상태도 연동되도록 일대다 객체 의존 관계를 구성하는 패턴이다.
   - 하나의 시스템을 서로 연동되는 클래스 집합으로 분할했을 때 발생하는 공통적인 부작용은 관련된 객체 간의 일관성을 유지하도록 해야한다는 것이다.
2. State
   - 객체의 상태에 따라 **객체의 행동 내용**을 변경해주는 패턴이다.
3. Strategy
   - 행동을 클래스로 캡슐화해 동적으로 행동을 자유롭게 바꿀 수 있는 패턴이다.
   - 동일 계열의 알고리즘군을 정의하고, 각 **알고리즘을 캡슐화**하며, 이들을 상호교환이 되도록 만든다. 알고리즘을 사용하는 클라이언트와 상관없이 독립적으로 알고리즘을 다양하게 변경할 수 있게한다.
4. Template Method
   - 어떤 작업을 처리하는 일부분을 서브 클래스로 캡슐화해 전체 일을 수행하는 구조는 바꾸지 않으면서 특정 단계에서 수행하는 내역을 바꾸는 패턴이다.
   - 객체의 연산에는 알고리즘의 뼈대만을 정의하고, 수행할 구체적 처리는 서브클래스로 미루는 방법이다.
5. Command
   - 실행될 기능을 캡슐화함으로써 주어진 여러 기능을 실행할 수 있는 재사용성이 높은 클래스를 설계하는 패턴이다.
   - 요청 자체를 캡슐화 하는 것이며, 이를 통해 요청이 서로 다른 사용자를 매개변수로 만들고, 요청을 대기시키거나 로깅하며 되돌릴 수 있는 연산을 지원한다.
6. Chain of Responsibility
   - 요청을 처리할 수 있는 기회를 하나 이상의 객체에게 부여함으로써 요청하는 객체와 처리하는 객체 사이의 결합도를 없애려는 패턴이다.
   - 메시지를 보내는 객체와 이를 받아 처리하는 객체들간의 결합도를 없애기 위한 패턴이다. 하나의 요청에 대한 처리가 반드시 한 객체에서만 되지않고, 여러 객체에게 그 처리 기회를 주려는 것이 목적이다.
7. Interpreter
   - 언어에 따라서 문법에 대한 표현을 정의하는 패턴이다.
   - 언어의 문장을 해석하기 위해 정의한 표현에 기반하여 분석기를 정의한다.
8. Mediator
   - **객체들 간의 상호작용을 객체로 캡슐화**한다.
   - 객체들간의 참조 관계를 객체에서 분리함으로써 상호작용만을 독립적으로 다양하게 확대할 수 있다.
9. Memento
   - 캡슐화를 위배하지 않고 객체 내부 상태를 객체화(실체화)하여 나중에 객체가 그 상태로 복구 가능하게 한다.
10. Visitor
    - 객체 구조의 요소들에 수행할 연산을 표현한 패턴이다.
    - 연산이 처리할 요소의 클래스를 변경하지 않고도 새로운 연산을 정의할 수 있게 한다.

### Step 3. 디자인 패턴을 이용하여 문제를 푸는 방법

디자인 패턴을 이용하여 7가지의 문제에 대해 해결하는 방법을 제시한다.

1.  적당한 객체 찾기

   - 객체 = 데이터 + 프로시저(Procedure, 메소드, 연산이라 한다.)
   - 객체는 요청 혹은 메시지를 사용자에게 받으면 연산을 수행한다. 
     - <u>**요청**은 객체가 연산을 실행하게 하는 유일한 방법이다.</u> 
     - <u>**연산**은 객체의 내부 데이터의 상태를 변경하는 유일한 방법이다.</u>
   - 이러한 접근의 제약 사항으로 **객체의 내부의 상태는 캡슐화(Encapsulate)**된다고 한다. 즉, 객체 외부에서는 개체의 내부 데이터에 직접 접근할 수가 없고, 객체의 내부 데이터 표현 방법을 알 수 없다.
   - 객체지향 설계에서 가장 어려운 부분은 시스템을 구성할 객체의 분할을 결정하는 것이다.
   - 객체지향 설계는 실세계와 대응 관계를 갖지 못할 때가 많다. 분석 모델의 객체는 실세계들의 객체이지만, 설계 모델의 객체에서는 구현에 가까운 클래스들도 존재한다. 또한 실세계를 그대로 반영하는 모델링만 강조하면 미래의 실세계를 반영하지 못하는 경우가 존재하므로 설계 단계 동안 만들어야하는 새로운 추상화는 설계의 유연성을 증진하기 위해 중요하다.
   - **디자인 패턴은 덜 명확한 추상적 개념과 이것을 잡아낸 객체를 알아보는데 도움을 준다.**

2. 객체의 크기 결정

   - 객체의 규모는 디자인 패턴에서 답을 얻을 수 있다.

3. 객체 인터페이스의 명세

   - 시그니처는 객체가 선언한 모든 연산의 이름, 매개변수로 받아들이는 객체들, 연산의 반환 값을 명세한 것이다. 

   - 인터페이스는 객체가 정의하는 연산의 모든 시그니처들을 일컫는 말로 객체의 인터페이스는 객체가 받아서 처리할 수 있는 연산의 집합니다.
   - 타입은 특정 인터페이스를 나타낼 때 사용하는 이름이다. 객체가 "Math" 타입을 갖는다는 것은 "Math" 인터페이스에 정의한 연산들을 모두 처리할 수 있다는 것을 의미한다.
   - 인터페이스가 다른 인터페이스를 부분집합으로 포함할 경우
     - 포함되는 인터페이스를 서브타입
     - 포함하는 인터페이스를 슈퍼타입
   - 객체는 인터페이스로 자신을 드러내며, 외부에서 객체를 알 수 있는 방법은 인터페이스 밖에 없기 때문에 인터페이스를 통해서만 처리를 요청한다. 즉, 기능을 사용할 수 있는 통로가 되는 것이다.
   - 객체의 인터페이스는 구현에 대한 정보는 알려주지 않는다. 따라서, 서로 다른 객체는 인터페이스에 정의한 요청의 구현 방법을 자유롭게 선택이 가능한데 이를 통해서 동일한 인터페이스를 갖는 두객체라도 완전히 다른 구현을 갖는다는 뜻이다.
   - 이러한 특성으로 동일한 요청이라도 처리하는 객체들이 다르면, 구현을 어떻게했는지에 따라서 다른 결과가 나온다. 이러한 것을 런타임(프로그램 실행 중에)에 연결 짓는 것을 **동적 바인딩(Dynamic Binding)** 이라 한다.
   - 이러한 동적 바인딩을 통해서 프로그램이 기대하는 객체를 동일한 인터페이스를 갖는 다른 객체로 대체할 수 있게하는데 이것을 바로 **다형성(Polymorphism)** 이라 한다.
   - 객체지향 시스템은 다형성을 통하여 객체 간의 결합도를 없애며, 프로그램 실행 중에는 서로 간의 관련성을 다양화할 수 있게 해준다.
   - 디자인 패턴은 인터페이스에 정의해야 하는 중요 요소가 무엇이고, 어떤 종류의 데이터르 주고 받아야하는지 식별하여 인터페이스를 정의하도록 도와준다.

4. 객체 구현 명세하기

   - UML을 이용하여 클래스와 객체에 대한 정보를 명세한다.
   - UML(Unified Modeling Language)는 요구 분석, 시스템 설계, 시스템 구현 등의 시스템 개발 과정에서 개발자 사이의 의사 소통이 원할하게 이루어지도록 표준화한 통합 모델링 언어이다.

<img src="https://user-images.githubusercontent.com/42603919/93415566-c339e180-f8de-11ea-9aa9-47d8b7bbb7b7.png" alt="스크린샷 2020-09-17 오후 12 10 12" style="zoom:67%;" />

1. 재사용을 실현 가능한 것으로

   - 유연하고 재사용 가능한 소프트웨어 개발에 적용하는지를 파악할 수가 있다.

     1. 상속 대 합성
     2. 위임

     **1. 상속 대 합성** 객체지향 시스템에서 기능의 재사용을 위해 구사되는 가장 대표적인 기법은 **클래스 상속, 객체 합성**이다.

     클래스 상속은 다른 부모 클래스에서 상속받아 한 클래스의 구현을 정의하는 것으로 서브클래싱에 의한 재사용을 **화이트박스 재사용(white-box reuse)**라 한다. 화이트박스라는 말이 쓰인 것은 부모 클래스의 내부가 서브클래스에 공개 되기때문에 내부를 볼 수 있다는 의미에서 사용되었다.

     객체 합성은 클래스 상속에 대한 대안이다. 다른 객체를 여러 개 붙여서 새로운 기능 혹은 객체를 구성하는 것으로써 이런 스타일의 재사용을 **블랙박스 재사용(black-box reuse)**라고 한다. 객체의 내부는 공개되지 않고 인터페이스를 통해서만 재사용되기 때문이다.

     **상속과 합성 비교**

     *상속*

     **장점**

     컴파일 시점에 정적으로 정의되고, 프로그래밍 언어가 직접 지원하므로 그대로 사용하면 된다.

     **단점**

     1. 런타임에 상속받는 부모 클래스의 구현 변경 불가능. (상속이 컴파일 시점에 적용되므로)
     2. 부모가 서브클래스의 물리적 표현의 최소 부분만을 정의 -> 서브클래스는 정의된 물리적 표현을 전부 또는 일부 상속받는다. (서브클래스는 부모 클래스의 구현에 종속될 수밖에 없으므로, 부모 클래스 구현에 변경이 생기면 서브클래스도 변경해야된다.) -> 해결법 : 추상클래스 사용

     *객체 합성*

     장점 : 한 객체가 다른 객체에 대한 참조자를 얻는 방식으로 런타임에 동적으로 정의된다. 따라서, 객체는 인터페이스에 맞춰 구현되므로 구현 사이의 종속성이 낮아진다.

     객체 합성을 통하면, 각 클래스의 캡슐화를 유지할 수 있고, 각 클래스는 한 가지 작업에 집중할 수 있다. 따라서 **객체 합성이 클래스 합성보다 더 나은 방법이다.** 라고 책에서는 말한다.

     단점 : 가능한 구성요소의 집합이 실제로 사용할 수 있을 만큼 충분하지 않기 때문에, 기존 구성요소의 조합을 통한 재사용만으로 목적을 달성할 수 있는 경우는 드물다.

     **2. 위임(Delegation)**

     두 객체가 하나의 요청을 처리한다. 자세히 설명하면, 수신 객체가 연산의 처리를 위임자(Delegate)에게 보낸다.

     더 자세히 설명하면, 어떤 기능을 구현할 때 그 책임을 다른 객체로 떠넘기거나 그 객체의 기능을 빌려 사용하는 것을 말하며, 특정 객체의 기능을 사용하기 위해 다른 객체의 기능을 호출하는 것이다.

     이 부분은 나중에 전략패턴을 다루면서 자세히 다뤄보도록 하겠다.

2. 런차임 및 컴파일 타임의 구조를 관계 짓기

   - 객체의 관계 중에는 **집합(Aggregation)과 인지관계(Acquaintance)** 가 있다.

     집합은 한 객체가 다른 객체를 소유하거나 그것에 책임을 진다는 뜻이다. 인지는 한 객체가 다른 객체에 대해 알고 있음을 의미한다. 이를 연관(Association) 혹은 사용(using) 관계라고도 한다.

     인지 관계는 집합 관계보다 관련성이 약해서 객체들 사이의 결합도가 약하다.

     인지 관계와 집합 관계는 언어의 처리 방식이 아닌 사용 목적에 따라 결정해야 한다. 이러한 차이를 컴파일 시점에서 발견하기는 힘들지만 중요한 의미를 갖는데 집합 관계는 인지 관계와 비교하여 강력한 영속성의 개념을 갖는다. 즉, 자동차에 바퀴가 있다는 것은 영속적 사실이라는 점과 같다. 반면, 인지 관계는 자주 바뀌는데 사람과 회사의 관계를 보면 근무한다는 관련성이 있을 수도 혹은 없을 수도 있다.

     따라서 소스 코드에서 그것을 쉽게 식별하기 어려우므로, 설계자가 런타임 구조를 만들 때 객체와 타입 사이의 관계를 세심하게 설계해야한다. 복합체 패턴이나 장식자 패턴은 복잡한 실행 구조를 구축하는 데 유용하며, 감시자 패턴은 런타임 구조를 만드는데 사용한다.

3. 변화에 대비한 설계

   - 변화에 잘 대응하기 위한 소프트웨어를 설계하기 위해서는 소프트웨어를 운영하는 동안 앞으로 일어날 변화를 어떻게 수용할 것인가를 미리 고려해야 한다.

     디자인 패턴은 어떤 구체적인 원인으로 앞으로 시스템을 변경해야 한다는 것을 미리 보여줌으로써 이런 수고를 덜어준다.

     아래는 디자인 패턴을 써서 재설계를 할 수밖에 없게 하는 이유이다.

     1. 특정 클래스에서 객체 생성
     2. 특정 연산에 대한 의존성
     3. 하드웨어와 소프트웨어 플랫폼에 대한 의존성
     4. 객체의 표현이나 구현에 대한 의존성
     5. 알고리즘 의존성
     6. 높은 결합도
     7. 서브클래싱을 통한 기능 확장
     8. 클래스 변경이 편하지 못한 점

     ------

     **특정 클래스에서 객체 생성** : 객체를 생성할 때 클래스 이름을 명시하면 어떤 특정 인터페이스가 아닌 특정 구현에 종속이 된다.

     상위 문제를 해결 할 수 있는 디자인 패턴 : *추상 팩토리, 팩토리 메소드, 원형*

     **특정 연산에 대한 의존성** : 특정한 연산을 사용하면, 요청을 만족하는 한 가지 방법에만 종속된다.

     상위 문제를 해결 할 수 있는 디자인 패턴 : *책임 연쇄, 명령*

     **하드웨어와 소프트웨어 플랫폼에 대한 의존성** : 특정 플랫폼에 종속된 소프트웨어는 다른 플랫폼에 이식하기가 어려울뿐아니라 본래 플랫폼에서의 버전 변경이 까다롭다.

     상위 문제를 해결 할 수 있는 디자인 패턴 : *추상 팩토리, 가교*

     **객체의 표현이나 구현에 대한 의존성** : 사용자가 객체의 표현법, 저장법, 구현법 등… 을 알고 있으면, 객체를 변경할 때 사용자도 함께 변경해야되므로 정보은닉이 필요하다.

     상위 문제를 해결 할 수 있는 디자인 패턴 : *추상 팩토리, 가교, 메멘토, 프록시*

     **알고리즘 의존성** : 알고리즘에 종속된 객체라면 알고리즘이 변할 때마다 객체도 변경해야한다.

     상위 문제를 해결 할 수 있는 디자인 패턴 : *빌더, 반복자, 전략, 템플릿 메소드, 방문자*

     **높은 결합도** : 높은 결합도를 갖는 클래스들은 독립적으로 재사용하기 어렵다.

     상위 문제를 해결 할 수 있는 디자인 패턴 : *추상 팩토리, 가교, 책임 연쇄, 명령, 퍼사드, 중재자, 감시자*

     **서브클래싱을 통한 기능 확장** : 서브클래싱으로 객체를 재정의를 하면, 새로운 클래스마다 매번 초기화, 소멸 등에 대한 구현 오버헤드가 증가하게 된다. 또한, 서브클래스를 정의하려면 최상위 클래스부터 자신의 직계 부모클래스까지에 대한 정보를 모두 이해하고 있어야된다. 단순히 확장만으로 서브클래스를 만든다면, 서브클래싱은 클래스의 수를 엄청나게 증가시킨다.

     상위 문제를 해결 할 수 있는 디자인 패턴 : *가교, 책임 연쇄, 장식자, 감시자, 전략*

     클래스 변경이 편하지 못한 점 : 어떤 변경을 하면, 기존 서브클래스의 다수를 수정하거나 소스 코드가 필요한데 없다고 가정하면 클래스를 변경하는 작업이 어려움을 알 수가 있다.

     상위 문제를 해결 할 수 있는 디자인 패턴 : *적응자, 장식자, 방문자*



### Step 4. 디자인 패턴을 고르는 방법

1. 패턴이 어떻게 문제를 해결하는지 파악하자
2. 패턴의 의도가 무엇인지 파악하자
3. 패턴들 간의 관련성을 파악하자
4. 비슷한 목적의 패턴들을 모아서 공부하자
5. 재설계의 원인을 파악하자
6. 설계에서 가변성을 가져야 하는 부분이 무엇인지 파악하자

















#### 출처

https://dailyworker.github.io/java-design-pattern/

https://gmlwjd9405.github.io/2018/07/06/design-pattern.html

https://dailyheumsi.tistory.com/148

https://blog.naver.com/PostView.nhn?blogId=1ilsang&logNo=221104669002&parentCategoryNo=&categoryNo=59&viewDate=&isShowPopularPosts=true&from=search

https://seungdols.tistory.com/487?category=652793

http://algamza.blogspot.com/2016/04/prototype-pattern.html

https://leetaehoon.tistory.com/55?category=212584

https://readystory.tistory.com/116

https://m.blog.naver.com/scw0531/221465259625

https://free-strings.blogspot.com/2016/04/adapter-decorator-facade-proxy.html