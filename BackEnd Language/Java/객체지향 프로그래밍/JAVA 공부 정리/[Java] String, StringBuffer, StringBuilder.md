# [Java] String, StringBuffer, StringBuilder

Java에서 문자열을 다루를 대표적인 클래스로 **String ,** **StringBuffer**, **StringBuilder**가 있다. 

연산이 많지 않을때는 어떤 클래스를 사용하더라도 이슈 발생 가능성은 거의 없다. 

하지만 **연산횟수가 많아지거나 멀티 스레드, Race condition** 등의 상황이 자주 발생 한다면 **각 클래스의 특징을 이해하고 상**

**황에 맞는 적절한 클래스를 사용**해줘야 한다.





### String

- **String**은 **불변(Immutable)의 속성**을 갖는다.

- **멀티 스레드 환경에서의 안정성(thread-safe)**

  ````java
  String str = "Hi"; // String str = new String("Hi");
  str = str + " Korea";
  System.out.println(str);
  
  => Hi Korea
  ````

- String을 연결하면 기존의 String에 연결되는 것이 아니라, String 클래스의 참조변수 str이 "Hi Korea" 라는 값을 가지고 있는 **새로운 메모리 영역을 가리키게 변경**되고 **처음 선언했던 "Hi"로 값이 할당되어 있던 메모리 영역은 Garbage로 남아있다가 GC(garbage collection)에 의해 사라지게 되는 것**이다. 

- String 클래스는 불변하기 때문에 문자열을 수정하는 시점에 새로운 **String 인스턴스가 생성된 것**이다.

<img width="902" alt="스크린샷 2022-03-18 오후 2 17 06" src="https://user-images.githubusercontent.com/73063032/158941941-c3888759-4dcb-41be-9c61-2e2141ea4d22.png" style="zoom:50%;" >

- String은 불변성을 가지기 때문에 **변하지 않는 문자열을 자주 읽어들이는 경우 String을 사용**해주면 좋다. 

- 그러나 **<u>문자열 추가,수정,삭제 등의 연산이 빈번하게 발생</u>**하는 알고리즘에 String 클래스를 사용하면 **힙 메모리(Heap)에 많은 임시 가비지(Garbage)가 생성**되어 힙 메모리가 부족으로 어플리케이션 성능에 치명적인 영향을 끼치게 된다.

- 따라서 이를 해결하기 위해 Java에서는 **<u>가변(mutable)성</u>**을 가지는 **StringBuffer** / **StringBuilder** 클래스를 도입했다.

- String 과는 반대로 StringBuffer/StringBuilder는 가변성 가지기 때문에 .append() .delete() 등의 API를 이용하여 **동일 객체 내에서 문자열을 변경**하는 것이 가능하다. 

  ````java
  StringBuffer sb= new StringBuffer("Hi"); 
  sb.append(" Korea");
  
  => Hi Korea

<img width="722" alt="스크린샷 2022-03-18 오후 2 30 56" src="https://user-images.githubusercontent.com/73063032/158943252-b8d527b7-ca22-424d-8227-a306ca810c1a.png" style="zoom:50%;" >



 

### StringBuffer

- **StringBuffer**는 동기화 키워드(synchronized keyword)를 지원하여 **멀티 스레드 환경에서 안전하다.**(thread-safe)
  - 멀티 스레드 상태에서 동기화를 지원



### StringBuilder

- **StringBuilder**는 **동기화를 지원하지 않기**때문에 멀티 스레드 환경에서 사용하는 것은 적합하지 않지만 동기화를 고려하지 않는 만큼 **단일 스레드에서의 성능은 StringBuffer 보다 뛰어나다**.





<img width="622" alt="스크린샷 2022-03-18 오후 2 29 45" src="https://user-images.githubusercontent.com/73063032/158943130-894efd7a-7383-4d0f-9fa8-c11d5dfc92a4.png">



## 정리

**String 클래스**는 **불변 객체**이기 때문에 문자열 연산이 많은 프로그래밍이 필요할 때 계속해서 인스턴스를 생성하므로 성능이 떨어지지만 조회가 많은 환경, 멀티쓰레드 환경에서 성능적으로 유리하다.

**StringBuffer 클래스와 StringBuilder 클래스**는 문자열 연산이 자주 발생할 때 문자열이 변경 가능한 객체이기 때문에 성능적으로 유리하다.

StringBuffer와 StringBuilder의 **차이점은 동기화 지원의 유무**이고 동기화를 고려하지 않는 환경에서 StringBuilder가 성능이 더 좋고, 동기화가 필요한 멀티쓰레드 환경에서는 StringBuffer를 사용하는 것이 유리하다.





**참고**

[[Java] String, StringBuffer, StringBuilder 차이 및 장단점](https://ifuwanna.tistory.com/221)

[[Java] String, StringBuffer, StringBuilder의 차이점과 사용이유](https://coding-factory.tistory.com/546)

[JAVA String, StringBuffer, StringBuilder 차이점](https://jeong-pro.tistory.com/85)

