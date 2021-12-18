# Java Design Pattern Analysis

#### 생성 패턴

**추상 팩토리(Abstract Factory)**

<img src="https://user-images.githubusercontent.com/42603919/93544078-1cb21700-f998-11ea-88a8-dcb795e88ba7.png" alt="추상팩토리 패턴" style="zoom: 50%;" />



1. Client를 만들 때는 추상팩토리를 바탕으로 만들어진다. 실제 팩토리는 실행할 때 결정된다.

   - 코드
     - **Client 쪽은 Simulate.java,Student.java에 해당**한다.
     - **Simulate.java 내부 코드**를 보게 되면 <u>MsStudentFactory(), UndrGraduateStudentFactory(), PhdStudentFactory() 를 바탕으로 Client가 만들어진다.</u>
     - **Student.java 내부 코드**를 보게 되면 <u>type, course, paper, degreeDocument 값을 받아 출력해주는 흐름으로 코드가 구성</u>되어 있다.

2. AbstractFactory는 모든 구상 팩토리에서 구현해야하는 인터페이스이다. 제품을 생산하기 위한 일련의 메소드들이 정의되어있다.

   - 코드

     - package가 factory인 부분에 해당한다. 내부를 살펴보면, **인터페이스인 AbstractFactory는 StudentFactory.java에 해당**한다. StudentFactory.java 내부를 살펴보면, <u>createCourse(), createPaper(), createDegreeErnDoc() 즉, 제품을 생산하기 위한 일련의 메소드들이 정의</u>되어 있다.

     - **ConcreateFactory에 해당하는 부분은 MsStudentFactory.java, PhdStudentFactory.java, UndrGraduateStudentFactory.java이다.** 이 부분을 통해 <u>구상 팩토리에서는 서로 다른 제품군(학사, 석사, 박사)을 구현한다는 것을 알 수 있다.</u> 

       각각의 내부를 살펴보면, AbstractFactory인 StudentFactory를 상속받아 구현되어있다. 그리고 createCourse(), createPaper(), createDegreeErnDoc()에서 return을 통해 해당 객체로 넘어간 후, 각 객체에 해당하는 값을 다시 return 해주는 방식으로 코드가 구성되어 있다.

3. 제품군, 각 구상 팩토리에서 필요한 제품들을 모두 만들 수 있다.

   - 코드
     - 인터페이스인 **AbstractProduct에 해당하는 부분은 Course, DegreeDocument, Paper이다.** 이 부분을 통해서 <u>제품군, 각 구상 팩토리에서 필요한 제품들을 모두 만들 수 있다.</u>
     - 각 AbstractProduct에 해당하는 Product는 다음과 같다.
       - Course : MsStudentCourse, PhdStudentCourse, UndrGraduateStudentCourse
       - DegreeDocument : Dissertation, MsThesis, ProjectReport
       - Paper : ConferencePaper, JournalPaper, TechnicalReport



**팩토리 메서드(Factory Method)**

<img src="https://user-images.githubusercontent.com/42603919/93576699-20648e80-f9d6-11ea-9ffc-280e87506454.png" alt="팩토리 메서드" style="zoom:67%;" />

1. TestFactory.java
   - 코드
     - ComputerFactory.getComputer() 메소드를 통해 값을 입력 받는다.
     - 받아온 pc, server값을 출력시킨다.
2. ComputerFactory.java
   - 코드
     - getComputer 메소드를 살펴보면 static 메소드로 구현되었다는 점을 알 수 있다. getComputer 메소드를 통해 입력된 type, ram, hdd, cpu 값을 받아온다.
     - 메소드 내부 코드를 보면 받아온 값을 이용하여, type의 값이 "PC"일 경우 PC 클래스의 인스턴스를, "Server"일 경우 Server 클래스의 인스턴스를 리턴하는 것을 볼 수 있다.
     - 이렇듯 팩토리 메소드 패턴을 사용하게 된다면 인스턴스를 필요로 하는 Application에서 Computer의 서브 클래스에 대한 정보는 모른채 인스턴스를 생성할 수 있다.
3. PC, Server.java
   - 코드
     - Ram, hdd, cpu 선언한 후, getRAM(), getHDD(), getCPU() 메서드가 호출되었을 때 해당 값을 return this.xxx의 방식으로 반환할 수 있도록 설정

4. Computer.java
   - 코드
     - Computer.java는 Super Class이다.
     - getRAM(), getHDD(), getCPU() 메서드를 선언한 후, toString()을 이용하여 해당 값을 this를 이용하여 return 할 수 있도록 설계해놨다.



**빌더(Builder)**

<img src="https://user-images.githubusercontent.com/42603919/93544084-220f6180-f998-11ea-9998-66b0ff12d90d.png" alt="빌더패턴" style="zoom:67%;" />

- **참여객체**
  - Builder : 빌더 인터페이스
  - ConcreteBuilder : 빌더 인터페이스 구현체. 부품을 합성하는 방식에 따라 여러 구현체를 만든다.
  - Director : Builder를 사용해 객체를 생성한다.
  - Product : Director가 Builder로 만들어낸 결과물

1. BuilderPattern.java
   - 코드
     - PersonInfoBuilder() 객체를 생성한 후, 이 빌더 객체에 원하는 데이터를 입력한다. 이때 순서는 상관이 없다.
     - .build() 메소드를 호출하여 데이터의 순서 상관없이 객체를 만들어 내는 PersonInfoBuilder.java를 통해 최종적인 결과물을 만들어 반환한다.
     - Result.getPersonInfo()를 통해 값을 가지고와 출력할 수 있도록 설정하였다.
2. PersonInfo.java
   - 코드
     - PersonInfo 클래스는 한 사람의 정보를 담기 위한 것이다.
3. PersonInfoBuilder.java
   - 코드
     - 각각의 인자들을 선언한다.
     - setName, setAge, setFavoriteColor 등등을 빌더로 만든 후 **return** **this**;를 통해 반환한다. 이렇게 되면 **"."** 으로 체인을 이어갈 수 있다.



**프로토타입(Prototype)**

<img src="https://user-images.githubusercontent.com/42603919/93544086-2471bb80-f998-11ea-8a66-19b2efbd95d4.png" alt="원형 프로토타입" style="zoom:67%;" />

- **참여객체**
  - Prototype : 인스턴스를 복사하여 새로운 인스턴스를 만들기 위한 메소드를 결정
  - ConcretePrototype : 인스턴스를 복사해서 새로운 인스턴스를 만드는 메소드를 실제로 구현
  - Client : 인스턴스 복사 메소드를 사용해서 새로운 인스턴스를 만든다.



1. Cookie.java

   - 코드

     - 해당 코드는 Prototype에 해당하는 코드이다.

     - Clone() 메소드를 재정의하기 위해 Cloneable 인터페이스를 구현했다.

       => 즉, 복제를 구현하기 위해서 Cloneable 인터페이스를 구현

     - Cloneable 구현 시 clone 메소드를 오버라이드하여 정의해준다.

     - object를 반환하는 타입으로 clone()을 정의하고, 기능은 객체를 복제한 결과를 반환하는 구조이다.

2. CocountCookie.java

   - 코드
     - 해당 코드는 Concrete Prototype에 해당하는 코드이다.
     - Prototype 클래스를 상속받는 구조로 되어있다.
     - 다형적 생성자 기능이 필요한 경우 사용한다.

3. CookieMachine.java

   - 코드
     - 해당 코드는 Client에 해당하는 코드이다.
     - 객체를 복제하여 반환하는 코드가 구현되어 있다.
     - 복제할 객체를 설정하고 clone을 하여 반환하는 메소드가 정의되어 있다.



**싱글턴(Singleton)**

<img src="https://user-images.githubusercontent.com/42603919/93544089-276cac00-f998-11ea-9894-962fb4aa6b6c.png" alt="싱글톤 패턴" style="zoom:67%;" />





#### 구조 패턴

**Adapter**

![Adapter](https://user-images.githubusercontent.com/42603919/93727330-a7438200-fbf5-11ea-83fc-1f545cbd4636.png)

##### 구성요소

- **Target**
  - Client 가 직접적으로 사용하려고 하는 인터페이스를 정의한다. (Adaptee 가 지원하길 바라는 인터페이스를 의미한다.)
- **Adaptee**
  - Adapter 에서 사용하고자 하는 인터페이스를 정의하고 있다.
- **Adapter**
  - Target 인터페이스를 상속받아서 구현하는 클래스로 이 때 Adaptee 의 함수를 사용하게 된다.
- **Client**
  - Target 인터페이스를 사용한다.



**Bridge**

<img src="https://user-images.githubusercontent.com/42603919/93727331-a7dc1880-fbf5-11ea-9812-b6c92596bcbb.png" alt="Bridge" style="zoom: 50%;" />

##### 구성요소

- **ConcreteImplementor** 
  - Implementor 인터페이스를 구현 즉, 실제 기능을 구현한다.

- **Implementor**
  - 구현 클래스를 위한 인터페이스를 정의한다.
  - Abstraction의 기능을 구현하기 위한 인터페이스 정의한다.

- **RefinedAbstraction**
  - Abstraction에 의해 정의된 인터페이스를 확장한다.(extends)
  - 기능 계층에서 새로운 부분을 확장한 클래스이다.

- **Abstraction** 
  - 기능 계층의 최상위 클래스이며 추상 인터페이스를 정의한다. Implementor에 대한 레퍼런스를 유지한다.
  - 구현 부분에 해당하는 클래스를 인스턴스를 가지고 해당 인스턴스를 통해 구현부분의 메서드를 호출한다.



**Composite**

<img src="https://user-images.githubusercontent.com/42603919/93727333-a874af00-fbf5-11ea-98d3-03dc353830ec.png" alt="Composite" style="zoom: 67%;" />



<img src="https://user-images.githubusercontent.com/42603919/93727859-2934aa80-fbf8-11ea-80dc-99a2c8b94b5f.png" alt="스크린샷 2020-09-21 오전 10 49 36" style="zoom:67%;" />

##### 구성요소

- **Client**
  - Leaf와 Composite 클래스를 직접 참조하지 않고, 공통 인터페이스 Component를 참조하는 것을 볼 수 있다.

- **Leaf**
  - Component 인터페이스를 구현하고, 구체 클래스를 나타낸다.
  - opertion()만 할 수 있는 객체이다.

- **Composite**

  - Component 객체 자식들을 유지하고, operation() 과 같은 요청을 통해 자식들에게 전달한다.

  - 즉, "Component" 인터페이스를 구현하고, 구현되는 자식(Leaf or Composite) 들을 가지고, 이러한 자식들을 관리하기 위한 메소드(addChild, removeChild...)를 구현한다.

    또한, 일반적으로 인터페이스에 작성된 메소드는 자식에게 위임하는 처리를 한다. 

    Composite.operation() => Leaf.operation(), 자세한 이해는 아래 예제를 통해 할 수 있다.

- **Component**
  - 모든 component 들을 위한 추상화된 개념으로써, "Leaf" 와 "Composite" 클래스의 인터페이스이다.
  - Component는 Composite와 Leaf의 부모가 되고 해당 두 객체가 가질 수 있는 동작들을 가지고 있다.



**Decorator**

<img src="https://user-images.githubusercontent.com/42603919/93727334-a90d4580-fbf5-11ea-86fa-90fd8f7814fa.png" alt="Decorator" style="zoom: 50%;" />



![스크린샷 2020-09-21 오후 3 09 15](https://user-images.githubusercontent.com/42603919/93736817-7165c400-fc1c-11ea-88a0-1313b87aa24f.png)

##### 구성요소

- **Component** 
  - Concrete Component 와 Decorator 에서 공통적으로 제공될 기능이 정의된, 클라이언트에서 호출하게 되는 역할

- **Concrete Component**
  - Componenet 를 상속받아 그 기능들을 구현한 클래스

- **Decorator**
  - Component 의 인터페이스를 따르지만 Component 를 래핑해서 새롭게 기능을 제공

- **Concrete Decorator** 
  - 개별적인 기능을 추가하는 기능



**Facade**

<img src="https://user-images.githubusercontent.com/42603919/93727335-a90d4580-fbf5-11ea-850a-6c9b40f8c76f.png" alt="Facade" style="zoom:50%;" />



**Flyweight**

<img src="https://user-images.githubusercontent.com/42603919/93727336-a9a5dc00-fbf5-11ea-9cef-70f7e9cfd252.png" alt="Flyweight" style="zoom:67%;" />

##### 구성요소

- **Flyweight**
  - 공유에 사용할 클래스들의 인터페이스를 선언한다.
- **ConcreteFlyweight**
  - Flyweight의 내용을 정의한다. 실제 공유될 객체이다.
- **FlyweightFactory**
  - 해당 공장을 사용해서 Flyweight의 인스턴스를 생성 또는 공유해주는 역할을 한다.
- **Client**
  - 해당 패턴의 사용자이다.



**Proxy**

<img src="https://user-images.githubusercontent.com/42603919/93727328-a4e12800-fbf5-11ea-84fb-e45648269e0d.png" alt=" Proxy" style="zoom:67%;" />

##### 구성요소

- **Subject** 
  - Proxy를 구현하기 위해 Interface로 설계되어 있으며 RealSubject와 Proxy는 이를 구현한다.

- **RealSubject**
  - 실제 서비스를 하는 주 객체이다.

- **Proxy**
  - Client가 Subject에게 접근하면 Proxy에게 접근이 된다.
  - Proxy는 접근을 제어할 수도 있고 추가 설정을 한 후 RealSubject에게 위임하여 RealSubject의 실제 서비스를 실행시킬 수 있다.
  - Proxy Object는 메서드 수행시 실제 객체(Real Object)의 메서드에 위임한다.



#### 행동 패턴

**Observer**



**State**



**Strategy**



**Template Method**



**Command**



**Chain of Responsibility**



**Interpreter**



**Mediator**



**Memento**



**Visitor**

