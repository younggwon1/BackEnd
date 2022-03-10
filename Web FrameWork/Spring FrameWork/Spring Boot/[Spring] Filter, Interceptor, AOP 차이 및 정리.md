# [Spring\] Filter, Interceptor, AOP 차이 및 정리

> **`공통 프로세스에 대한 고민`**
>
> 자바 웹 개발을 하다보면, **공통적으로 처리**해야 할 업무들이 많다.
>
> 예를 들어 로그인 관련(세션체크)처리, 권한체크, XSS(Cross site script)방어, pc와 모바일웹의 분기처리, 로그, 페이지 인코딩 변환 등이 있다. 
>
> Spring은 이러한 공통적으로 여러 작업을 처리하는 중복된 코드를 제거할 수 있도록 많은 기능들을 지원하고 있다.
>
> Filter, Interceptor, AOP는 공통 처리를 위해 활용할 수 있는 기능이다.



<img src="https://user-images.githubusercontent.com/73063032/156499553-4dcb0269-f92c-4169-9157-0c87aa9b6640.png" alt="스크린샷 2022-03-03 오후 2 01 45" style="zoom: 50%;" />



### Filter

Filter는 J2EE 표준 스펙 기능으로 **Dispatcher Servlet에 요청이 전달되기 전/후에 url 패턴에 맞는 모든 요청에 대해 부가작업을 처리할 수 있는 기능을 제공**한다.

Dispatcher Servlet은 스프링의 가장 앞단에 존재하는 프론트 컨트롤러이므로, Filter는 스프링 범위 밖에서 처리가 된다.

보통 web.xml에 등록하고, 일반적으로 인코딩 변환 처리, XSS방어 등의 요청에 대한 처리로 사용된다.

즉, Spring Container가 아닌 Tomcat과 같은 Web Container에 의해 관리가 되는 것이고(스프링 빈으로 등록은 된다), Dispatcher Servlet 전/후에 처리가 된다.

- 일부에서 잘못된 정보로 필터(Filter)가 스프링 빈으로 등록되지 못하며, 빈을 주입 받을 수도 없다고 하는데, 이는 잘못된 설명이다.
- **현재 Filter는 Spring Bean으로 등록이 가능하며, 다른 곳에 주입되거나 다른 Bean을 주입받을 수도 있다.** 

<img width="625" alt="스크린샷 2022-03-03 오전 11 02 41" src="https://user-images.githubusercontent.com/73063032/156482123-4065580e-f55e-4bc0-b1e1-852ebdf241cf.png" style="zoom:67%;" >

**[Filter의 메소드]**

**Filter를 추가하기 위해서는 javax.servlet의 <u>Filter 인터페이스를 구현(implements)</u>해야 한다.**

이를 위해 3가지 메소드를 사용한다.

- **init 메소드**
  - init 메소드는 필터 객체를 초기화하고 서비스에 추가하기 위한 메소드이다. 
  - 웹 컨테이너가 1회 init 메소드를 호출하여 필터 객체를 초기화하면 이후의 요청들은 doFilter를 통해 처리된다.
- **doFilter 메소드**
  - doFilter 메소드는 url-pattern에 맞는 모든 HTTP 요청이 Dispatcher Servlet으로 전달되기 전에 Web Container에 의해 실행되는 메소드이다. 
  - doFilter의 파라미터로는 FilterChain이 있는데, FilterChain의 doFilter 통해 다음 대상으로 요청을 전달하게 된다. chain.doFilter() 전/후에 우리가 필요한 처리 과정을 넣어줌으로써 원하는 처리를 진행할 수 있다.
- **destroy 메소드**
  - destroy 메소드는 필터 객체를 서비스에서 제거하고 사용하는 자원을 반환하기 위한 메소드이다. 
  - 이는 웹 컨테이너에 의해 1번 호출되며 이후에는 이제 doFilter에 의해 처리되지 않는다.



**[Filter의 용도 및 예시]**

- 공통된 보안 및 인증/인가 관련 작업
- 모든 요청에 대한 로깅 또는 감사
- 이미지/데이터 압축 및 문자열 인코딩
- Spring과 분리되어야 하는 기능

**Filter에서는 기본적으로 <u>스프링과 무관하게 전역적</u>으로 처리해야 하는 작업들을 처리할 수 있다.**

대표적인 예시로 보안과 관련된 공통 작업이 있다. 필터는 인터셉터보다 앞단에서 동작하기 때문에 전역적으로 해야하는 보안 검사(XSS 방어 등)를 하여 올바른 요청이 아닐 경우 차단을 할 수 있다. 그러면 Spring Container까지 요청이 전달되지 못하고 차단되므로 안정성을 더욱 높일 수 있다.

또한 Filter는 이미지나 데이터의 압축이나 문자열 인코딩과 같이 웹 애플리케이션에 전반적으로 사용되는 기능을 구현하기에 적당하다. 

Filter는 다음 체인으로 넘기는 ServletRequest/ServletResponse 객체를 조작할 수 있다는 점에서 Interceptor보다 훨씬 강력한 기술이다.





### Interceptor

**Spring이 제공하는 기술로써, Dispatcher Servlet이 Controller를 호출하기 전과 후에 요청과 응답을 참조하거나 가공할 수 있는 기능을 제공한다.** 

즉, Web Container에서 동작하는 Filter와 달리 Interceptor는 Spring Container에서 동작을 한다.

Dispatcher Servlet은 핸들러 매핑을 통해 적절한 컨트롤러를 찾도록 요청하는데, 그 결과로 실행 체인(HandlerExecutionChain)을 돌려준다. 그래서 이 실행 체인은 1개 이상의 Interceptor가 등록되어 있다면 순차적으로 Interceptor들을 거쳐 Controller가 실행되도록 하고, Interceptor가 없다면 바로 Controller를 실행한다.

<img width="788" alt="스크린샷 2022-03-03 오전 10 56 44" src="https://user-images.githubusercontent.com/73063032/156481597-0d6ec514-225b-4872-be1f-6ceba0e19c93.png" style="zoom:67%;" >



**[Interceptor의 메소드]**

**Interceptor를 추가하기 위해서는 org.springframework.web.servlet의 <u>HandlerInterceptor 인터페이스를 구현(implements)</u> 해야 한다.** 

이를 위해 3가지 메소드를 사용한다.

- **preHandle 메소드**
  - preHandle 메소드는 Controller가 호출되기 전에 실행된다. 그렇기 때문에 Controller 이전에 처리해야 하는 전처리 작업이나 요청 정보를 가공하거나 추가하는 경우에 사용할 수 있다.
  - preHandle의 3번째 파라미터인 handler 파라미터는 핸들러 매핑이 찾아준 Controller 빈에 매핑되는 HandlerMethod라는 새로운 타입의 객체로써, @RequestMapping이 붙은 메소드의 정보를 추상화한 객체이다.
  - 또한 preHandle의 반환 타입은 boolean인데 반환값이 true이면 다음 단계로 진행이 되지만, false라면 작업을 중단하여 이후의 작업(다음 인터셉터 또는 컨트롤러)은 진행되지 않는다.
- **postHandle 메소드**
  - postHandle 메소드는 컨트롤러를 호출된 후에 실행된다. 그렇기 때문에 컨트롤러 이후에 처리해야 하는 후처리 작업이 있을 때 사용할 수 있다. 
  - 이 메소드에는 컨트롤러가 반환하는 ModelAndView 타입의 정보가 제공되는데, 최근에는 Json 형태로 데이터를 제공하는 RestAPI 기반의 컨트롤러(@RestController)를 만들면서 자주 사용되지는 않는다.
- **afterCompletion 메소드**
  - afterCompletion 메소드는 이름 그대로 모든 뷰에서 최종 결과를 생성하는 일을 포함해 모든 작업이 완료된 후에 실행된다. 
  - 요청 처리 중에 사용한 리소스를 반환할 때 사용하기에 적합하다.



**[Interceptor의 용도 및 예시]**

- 세부적인 보안 및 인증/인가 공통 작업
- API 호출에 대한 로깅 또는 감사
- Controller로 넘겨주는 정보(데이터)의 가공

**Interceptor에서는 <u>클라이언트의 요청과 관련되어 전역적</u>으로 처리해야 하는 작업들을 처리할 수 있다.**

대표적으로 세부적으로 적용해야 하는 인증이나 인가와 같이 클라이언트 요청과 관련된 작업 등이 있다. 

예를 들어 특정 그룹의 사용자는 어떤 기능을 사용하지 못하는 경우가 있는데, 이러한 작업들은 Controller로 넘어가기 전에 검사해야 하므로 Interceptor가 처리하기에 적합하다.

또한 Interceptor는 Filter와 다르게 HttpServletRequest나 HttpServletResponse 등과 같은 객체를 제공받으므로 객체 자체를 조작할 수는 없다. 대신 해당 객체가 내부적으로 갖는 값은 조작할 수 있으므로 Controller로 넘겨주기 위한 정보를 가공하기에 용이하다. 

예를 들어 JWT 토큰 정보를 파싱해서 Controller에게 사용자의 정보를 제공하도록 가공할 수 있는 것이다.

그 외에도 우리는 다양한 목적으로 API 호출에 대한 정보들을 기록해야 할 수 있다. 이러한 경우에 HttpServletRequest나 HttpServletResponse를 제공해주는 Interceptor는 클라이언트의 IP나 요청 정보들을 포함해 기록하기에 용이하다.





### AOP

**Aspect Oriented Programming, 관점 지향 프로그래밍**

AOP의 핵심 기능은 `코드를 수정하지 않으면서 공통 기능의 구현을 추가하는 것`이라고 강조하고 있다.

**비즈니스 로직을 수행하는데 중복되는 코드를 줄이기 위한 프로그래밍 방법이다.** 

비즈니스 로직의 특정 시점을 바라보고 해당 시점이 수행되는 순간을 가로채어 전, 후 기능을 처리한다. 

<u>주로 '로깅', '트랜잭션', '에러 처리'등 비즈니스단의 메서드에서 조금 더 세밀하게 조정하고 싶을 때 사용한다.</u>

**어떤 로직을 기준으로 핵심적인 관점, 부가적인 관점으로 나누어서 보고 그 관점을 기준으로 각각 모듈화하는 것이다**. 

모듈화란 어떤 공통된 로직이나 기능을 하나의 단위로 묶는 것을 말한다. 

- 핵심적인 관점
  - 핵심 비즈니스 로직
- 부가적인 관점
  - 핵심 로직을 실행하기 위해서 행해지는 데이터베이스 연결, 로깅, 파일 입출력 등

**AOP**에서 각 관점을 기준으로 로직을 모듈화한다는 것은 코드들을 부분적으로 나누어서 모듈화하겠다는 의미다. 이때, 소스 코드상에서 다른 부분에 계속 반복해서 쓰는 코드들을 발견할 수 있는 데 이것을 **흩어진 관심사 (Crosscutting Concerns)**라 부른다. 



<img width="485" alt="스크린샷 2022-03-03 오후 2 21 37" src="https://user-images.githubusercontent.com/73063032/156501504-48714d85-885f-4af4-9074-2d1ac4c5c59a.png" style="zoom:50%;" >

위와 같이 흩어진 관심사를 **Aspect로 모듈화하고 핵심적인 비즈니스 로직에서 분리하여 재사용하겠다는 것이 AOP의 취지**이다.





**AOP 주요 개념**

- **Aspect**
  - 흩어진 관심사를 모듈화 한 것이다. (여러 핵심 기능에 적용될 관심사 모듈)
  - 구체적인 기능을 구현한 Advice와 Advice가 어디에서 적용될지를 결정하는 JointPoint을 포함한다.
    - **Advice + PointCut = Aspect**
  - 주로 부가기능을 모듈화한다.
- **Target**
  - 핵심 기능을 담고 있는 모듈
  - 어떠한 관심사들과도 관계를 맺지 않는다.
  - Aspect를 적용하는 곳이다. (클래스, 메서드 .. )
- **Advice**
  - Target에 제공할 실질적인 부가 기능을 담은 구현체이다.
  - 실질적으로 어떤 일을 해야할 지에 대한 것이다. 
  - Aspect가 무엇을 언제 적용할지를 정의한 것이다.
- **JointPoint**
  - Advice가 적용될 위치, 끼어들 수 있는 지점을 나타낸다. 
  - Target 객체가 구현한 인터페이스의 모든 메서드는 JointPoint가 된다. 
  - 메서드 진입 지점, 생성자 호출 시점, 필드에서 값을 꺼내올 때 등 다양한 시점에 적용 가능하다.
- **PointCut**
  - 공통 기능이 적용될 대상을 결정한다.
  - Advice를 적용할 Target의 메서드를 선별하는 정규 표현식이다.
  - JointPoint의 상세한 스펙을 정의한 것이다. 
  - 'A란 메서드의 진입 시점에 호출할 것'과 같이 더욱 구체적으로 Advice가 실행될 지점을 정할 수 있다.
- **Weaving**
  - PointCut에 의해서 결정된 Target의 JointPoint에 부가 기능(Advice)을 삽입하는 과정이다.
  - AOP가 핵심 기능(Target)의 코드에 영향을 주지 않으면서 필요한 부가 기능(Advice)을 추가할 수 있도록 해주는 핵심적인 처리 과정이다.



**Spring AOP 특징**

**1. Spring은 프록시 기반 AOP를 지원한다.**

- Spring은 타겟(target) 객체에 대한 프록시를 만들어 제공한다.
- 타겟을 감싸는 프록시는 실행시간(Runtime)에 생성된다.
- 프록시는 어드바이스를 타겟 객체에 적용하면서 생성되는 객체이다.



**2. 프록시(Proxy)가 호출을 가로챈다(Intercept)**

- 프록시는 타겟 객체에 대한 호출을 가로챈 다음 어드바이스의 부가기능 로직을 수행하고 난 후에 타겟의

핵심기능 로직을 호출한다.(전처리 어드바이스)

- 또는 타겟의 핵심기능 로직 메서드를 호출한 후에 부가기능(어드바이스)을 수행하는 경우도 있다.(후처리 어드바이스)



**3. Spring AOP는 메서드 조인 포인트만 지원한다.**

- Spring은 동적 프록시를 기반으로 AOP를 구현하므로 메서드 조인 포인트만 지원한다.
- 핵심기능(타겟)의 메서드가 호출되는 런타임 시점에만 부가기능(어드바이스)을 적용할 수 있다.
- 반면에 AspectJ 같은 고급 AOP 프레임워크를 사용하면 객체의 생성, 필드값의 조회와 조작, static 메서드 호출 및 초기화 등의 다양한 작업에 부가기능을 적용 할 수 있다.



**Aspect** 실행 시점을 지정할 수 있는 **어노테이션**

- **@Before (이전)**
  - Advice 타겟 메소드가 호출되기 전에 Advice 기능을 수행
- **@After (이후)**
  - 타겟 메소드의 결과에 관계없이(즉 성공, 예외 관계없이) 타겟 메소드가 완료 되면 어드바이스 기능을 수행
- **@AfterReturning (정상적 반환 이후)**
  - 타겟 메소드가 성공적으로 결과값을 반환 후에 어드바이스 기능을 수행
- **@AfterThrowing (예외 발생 이후)**
  - 타겟 메소드가 수행 중 예외를 던지게 되면 어드바이스 기능을 수행
- **@Around (메소드 실행 전후)**
  - 어드바이스가 타겟 메소드를 감싸서 타겟 메소드 호출전과 후에 어드바이스 기능을 수행



#### AOP 적용 방법

1. Proxy를 활용한 리팩토링
2. Spring **@AOP**를 사용

[AOP 입문자를 위한 개념 이해하기](https://tecoble.techcourse.co.kr/post/2021-06-25-aop-transaction/)

[[Spring] 스프링 AOP (Spring AOP) 총정리 : 개념, 프록시 기반 AOP, @AOP](https://engkimbs.tistory.com/746)

[[Spring] AOP(Aspect Oriented Programming)란 무엇일까?](https://devlog-wjdrbs96.tistory.com/398)

[[Spring] Spring의 AOP 프록시 구현 방법(JDK Dynamic Proxy, CGLib Proxy)과 @EnableAspectJAutoProxy의 proxyTargetClass - (3/3)](https://mangkyu.tistory.com/175)













**참고**

[필터(Filter) vs 인터셉터(Interceptor) 차이 및 용도 - (1)](https://mangkyu.tistory.com/173)

[[Spring] 서블릿 필터(Servlet Filter)가 스프링 빈으로 등록 가능하며 빈 주입이 가능한 이유(DelegatingFilterProxy의 등장) - (2)](https://mangkyu.tistory.com/221)

[[Spring] Filter, Interceptor, AOP 차이 및 정리](https://goddaehee.tistory.com/154)

[Spring Filter, Interceptor 그리고 AOP](https://junhyunny.github.io/spring-boot/filter-interceptor-and-aop/)

[[Spring] 스프링 AOP (Spring AOP) 총정리 : 개념, 프록시 기반 AOP, @AOP](https://engkimbs.tistory.com/746)

[[책] 스프링 철저 입문 - AOP](https://baek-kim-dev.site/56?category=903513)

[Spring AOP, Aspect 개념 특징, AOP 용어 정리](https://shlee0882.tistory.com/206)