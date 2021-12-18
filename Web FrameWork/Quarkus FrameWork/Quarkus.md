# Quarkus



1. GraalVM이란?
2. Quarkus란?
3. Quarkus vs Spring Boot
4. 샘플 코드 파일럿 테스트



### 1. GraalVM이란?

GraalVM은 JavaScript, Python, Ruby, R, Java, Scala, Clojure, Kotlin과 같은 JVM 기반 언어와 C 및 C ++와 같은 LLVM 기반 언어로 작성된 애플리케이션을 실행하기위한 범용 가상 머신 (Java로 구현 된 HotSpot / OpenJDK를 기반으로하는 Java VM 및 JDK)



#### GraalVM Architecture

| 기존 HotSpot VM                                              | Graal VM                                                     |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| <img width="465" alt="스크린샷 2021-05-27 오전 11 20 23" src="https://user-images.githubusercontent.com/73063032/119755816-99a96f00-bedd-11eb-8eae-7b7e6576a058.png"> | <img width="438" alt="스크린샷 2021-05-27 오전 11 20 46" src="https://user-images.githubusercontent.com/73063032/119755822-9b733280-bedd-11eb-80d2-32d0bf3b7341.png"> |

**GraalVM**은 <u>C2 컴파일러와 HotspotVM 과 통신하는 컴파일러 인터페이스 부분을 java로 작성</u>했다. 여기서 C2 컴파일러를 Graal 이라고 말한다.

**Graal** : GraalVM의 새로운 JIT(just-in-time) Compiler

---

**참고**

2개의 JIT compiler를 포함

– C1: client compiler
 • C1 디자인: 빠른 시작
 • 코드 최적화의 비중 낮춤

– C2: server compiler
 • C2디자인:약간느린시작
 • 코드 최적화의 비중 낮춤

---



| <img src="https://user-images.githubusercontent.com/73063032/119754712-d2e0df80-bedb-11eb-9356-8ccaf6068d05.png" alt="스크린샷 2021-05-27 오전 11 08 03" style="zoom:33%;" /> | <img width="521" alt="스크린샷 2021-05-27 오전 11 25 50" src="https://user-images.githubusercontent.com/73063032/119756300-500d5400-bede-11eb-9d85-d62190a7f406.png"> |
| ------------------------------------------------------------ | ------------------------------------------------------------ |



1. HotSpot VM : Hot한 Spot을 찾아서 해당 부분에서는 JIT 컴파일러를 사용하는 방법
2. JVM Compiler Interface(JVMCI) : Java로 작성된 컴파일러를 JVM에서 동적 컴파일러로 사용할 수 있도록 Java 기반 JVM 컴파일러(HotspotVM 과 통신하는 컴파일러)
3. Graal Compiler : JVMCI를 기반으로 하며 추가 최적화를 통해 더 나은 JIT 컴파일러 구현을 제공
4. Truffle Framework : 언어 인터프리터 프레임 워크
5. Sulong : Graal VM에 빌드 된 고성능 LLVM 비트 코드 런타임, Sulong은 Truffle과 Graal을 동적 컴파일러로 사용



#### GraalVM을 사용하는 이유

1. 고성능 현대 자바
2. 설치 공간이 적고 빠른 시작 Java
3. JavaScript, Java, Ruby 및 R 결합
4. JVM에서 네이티브 언어 실행
5. 모든 언어에서 작동하는 도구
6. JVM 기반 애플리케이션 확장
7. 기본 애플리케이션 확장
8. 네이티브 라이브러리로서의 자바 코드
9. 데이터베이스의 다국어
10. 자신 만의 언어 만들기



#### GraalVM의 목표

1. 더 빠르고 유지하기 쉬운 컴파일러 작성
2. JVM에서 실행되는 언어의 성능 향상
3. 애플리케이션 시작 시간 단축
4. Java 에코 시스템에 polyglot 지원 통합



#### GraalVM의 구성 요소

1. 고성능 최적화 Just-In-TIme 컴파일러
2. 네이티브 실행 파일을 빌드하기 위한 Ahead-of-Time 컴파일러 (독립형 기계어 코드를 직접 생성)
3. polyglot 지원





### 2. Quarkus란?

Java를 <u>Docker 컨테이너</u>와 <u>Kubernetes 환경</u>에 최적화시키는 것을 목적으로 Red Hat이 GraalVM 기술의 등장에 맞춰 개발한 JAVA 프레임워크이다.

**특징**

1. serverless, 클라우드, 쿠버네티스 환경에 효과적
2. 종속성 주입은 CDI(Contexts and Dependency Injection)를 기반

3. GraalVM(Java 및 JavaScript를 포함한 여러 언어로 작성한 애플리케이션을 실행하기 위한 범용 가상 머신)에 정확한 정보를 제공하여 애플리케이션의 네이티브 컴파일을 지원



**사용해야하는 이유**

1. 클라우드, 컨테이너 및 서버리스 환경에서 사용
   - 메모리 사용량이 적고 최초 응답 시간이 빠른 Quarkus는 클라우드, 컨테이너, 서버리스 환경에 이상적
2. 생산성 향상
   - Quarkus는 반복적 작업을 자동화하는 기능이 내장되어 있어서 개발자들의 작업 완료 속도가 향상
3. 개발 모델 선택의 자율성
   - Quarkus는 명령형 및 반응형 모델을 자연스럽게 통합
4. Java 최적화
   - Quarkus는 Java를 최적화하고 메모리 사용량 최적화와 빠른 최초 응답 시간으로 컨테이너, 클라우드, 서버리스 환경의 효율성을 향상



### 3. Quarkus vs Spring Boot 

#### 특히, **Quarkus** 는 <u>컨테이너 중심</u>으로 설계. 

이는 Quarkus가 <u>낮은 메모리 사용량</u>과 <u>빠른 시작 시간</u>에 최적화

결국, Quarkus가 구축한 애플리케이션은 기존 Java에 비해 <u>메모리 사용량이 1/10</u>인데다가 시작 시간이 더 빨라서(최대 300배 빠름) **클라우드 리소스 비용이 대폭 감소**

- Graal/SubstrateVM에 대한 최고 수준의 지원

  - 애플리케이션이 기본 이미지로 컴파일되면 훨씬 빨리 시작되고 표준 JVM보다 훨씬 작은 힙을 사용하여 실행할 수 있다.
  - -H:+ReportUnsupportedElementsAtRuntime 플래그 없이 실행할 수 있다 .

- 빌드 타임 메타데이터 처리

  - 빌드시 가능한 한 많은 처리가 이루어 지므로 런타임에 실제로 필요한 클래스만 애플리케이션에 포함된다.
  - Quarkus 를 사용하면 프로덕션 JVM 에 로드되지 않는다. 모든 메타 데이터 처리가 이미 완료되어 있기 때문에 결론적으로는 메모리 사용량이 줄어들고 시작 시간도 빨라진다.

- 리플렉션 사용 감소

  - > 리플렉션은 구체적인 클래스 타입을 알지 못하더라도, 그 클래스의 메소드, 타입, 변수들을 접근할 수 있도록해주는 Java API

- 기본 이미지(Native Image) 사전 부팅

  - Native Image로 실행하는 경우 Native Image 빌드를 진행하면서 가능한 한 많은 프레임워크를 사전 부팅한다. 즉, 생성 된 Native Image가 이미 대부분의 시작 코드를 실행하고, 그 결과를 실행 파일로 직렬화하므로 더 빠른 시작이 가능하다.
    - 실행 파일(Native Image)에는 다음이 포함
      - 애플리케이션 클래스
      - 실행에 필요한 다른 클래스
      - JDK 런타임 라이브러리
      - JDK와 정적으로 링크된 native code
      - Substrate VM (Java VM이 담당하던, 메모리 관리 및 스레드 스케줄링을 담당)





### 4. 샘플 코드 파일럿 테스트

https://github.com/graemerocher/framework-comparison-2020

|                          | Quarkus                                                      |
| ------------------------ | ------------------------------------------------------------ |
| **./mvnw clean compile** | <img width="685" alt="스크린샷 2021-05-27 오후 3 44 02" src="https://user-images.githubusercontent.com/73063032/119778516-97a5d700-bf02-11eb-8db5-5242bac5ee90.png"> |
| **./mvnw test**          | <img width="580" alt="스크린샷 2021-05-27 오후 3 49 00" src="https://user-images.githubusercontent.com/73063032/119778986-1d298700-bf03-11eb-924f-4485b98f97c3.png"> |
| **./mvnw package**       | <img width="846" alt="스크린샷 2021-05-27 오후 3 55 51" src="https://user-images.githubusercontent.com/73063032/119779839-16e7da80-bf04-11eb-813d-53c1fa86eecd.png"> |
| **java -jar ...**        | <img width="1199" alt="스크린샷 2021-05-27 오후 3 33 58" src="https://user-images.githubusercontent.com/73063032/119777332-f79b7e00-bf00-11eb-8e08-8002dc10658c.png"> |
| **Ab test**              | Concurrency Level:      20<br/>Time taken for tests:   1.144 seconds<br/>Complete requests:      10000<br/>Failed requests:        0<br/>Keep-Alive requests:    10000<br/>Total transferred:      1130000 bytes<br/>HTML transferred:       100000 bytes<br/>Requests per second:    8743.38 [#/sec] (mean)<br/>Time per request:       2.287 [ms] (mean)<br/>Time per request:       0.114 [ms] (mean, across all concurrent requests)<br/>Transfer rate:          964.85 [Kbytes/sec] received<br/> |





|                          | Spring Boot                                                  |
| ------------------------ | :----------------------------------------------------------- |
| **./mvnw clean compile** | <img width="814" alt="스크린샷 2021-05-27 오후 3 44 48" src="https://user-images.githubusercontent.com/73063032/119778512-9674aa00-bf02-11eb-85ac-9db61ba49e6c.png"> |
| **./mvnw test**          | <img width="598" alt="스크린샷 2021-05-27 오후 3 49 13" src="https://user-images.githubusercontent.com/73063032/119778976-1ac72d00-bf03-11eb-9b52-ddd69cdd4e28.png"> |
| **./mvnw package**       | <img width="883" alt="스크린샷 2021-05-27 오후 3 56 06" src="https://user-images.githubusercontent.com/73063032/119779826-151e1700-bf04-11eb-9bc1-1a247e7c3f9d.png"> |
| **java -jar ...**        | <img width="1382" alt="스크린샷 2021-05-27 오후 3 34 31" src="https://user-images.githubusercontent.com/73063032/119777389-0bdf7b00-bf01-11eb-948c-9d8b6c2d2958.png"> |
| **Ab test**              | Concurrency Level:      20<br/>Time taken for tests:   3.781 seconds<br/>Complete requests:      10000<br/>Failed requests:        0<br/>Keep-Alive requests:    0<br/>Total transferred:      890000 bytes<br/>HTML transferred:       100000 bytes<br/>Requests per second:    2644.67 [#/sec] (mean)<br/>Time per request:       7.562 [ms] (mean)<br/>Time per request:       0.378 [ms] (mean, across all concurrent requests)<br/>Transfer rate:          229.86 [Kbytes/sec] received |



#### 성능 비교

| compile                   | Quarkus (2.564s) |  <   | Spring Boot (1.859s)  |
| ------------------------- | ---------------- | :--: | --------------------- |
| **./mvnw test**           | Quarkus (6.457s) |  >   | Spring Boot (8.930s)  |
| **./mvnw package**        | Quarkus (9.261s) |  >   | Spring Boot (10.163s) |
| **Start Time Production** | Quarkus (0.918s) |  >   | Spring Boot (1.672s)  |





---

#### 참고사항

#### 기존 애플리케이션 스택의 성능 비교

| Rest_Memomry_Compare                                         | Rest_CRUD_Memomry_Compare                                    |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| ![Rest_Memomry_Compare](https://user-images.githubusercontent.com/73063032/119627446-2ce39580-be47-11eb-8374-43022ffad6c3.png) | ![Rest_CRUD_Memomry_Compare](https://user-images.githubusercontent.com/73063032/119627455-2f45ef80-be47-11eb-99eb-74c1194ec6bc.png) |
| REST 애플리케이션 환경에서 기존 애플리케이션 대비하여 메모리를 10 배 이하로 사용하는 것을 확인할 수 있다. | REST + CRUD 애플리케이션 일 경우에 기존 애플리케이션 대비 메모리를 6 배 이하로 점유하는 것을 확인할 수 있다. |



| Rest_Boot_ResponseTime_Compare                               | Rest_CRUD_Boot_ResponseTime_Compare                          |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| ![Rest_Boot_ResponseTime_Compare](https://user-images.githubusercontent.com/73063032/119627464-310fb300-be47-11eb-833b-2292747bc084.png) | ![Rest_CRUD_Boot_ResponseTime_Compare](https://user-images.githubusercontent.com/73063032/119627463-2fde8600-be47-11eb-9a6e-557150dca036.png) |
| REST 애플리케이션 일 경우 기존 애플리케이션 대비 시작 시간과 최초 응답 시간이 30 배 빠른 것을 확인할 수 있다. | REST + CRUD 애플리케이션 일 경우 기존 애플리케이션 대비 시작 시간과 최초 응답 시간이 17 배 빠른 것을 확인 할 수 있다. |

---



=> [GraalVM native image](https://github.com/spring-projects/spring-framework/wiki/GraalVM-native-image-support) 기능은 아직 실험적인 기능으로 운영 레벨에서 사용할 일이 없다. [스프링](https://github.com/spring-projects/spring-framework/wiki/GraalVM-native-image-support)에서도 Spring Framework 5.x 지원해줄 것 같다.







참고

http://www.opennaru.com/open-source/quarkus-performance/

https://quarkus.io/get-started/

https://barunmo.blogspot.com/

https://blogs.oracle.com/javakr/native-image-start

https://giljae.medium.com/graalvm-%EC%86%8C%EA%B0%9C-84ac547f8df2

https://ohjongsung.io/2019/12/08/graalvm-graal

https://www.redhat.com/cms/managed-files/cl-4-reasons-try-quarkus-checklist-f19180cs-201909-kr_v2.pdf

https://github.com/graemerocher/framework-comparison-2020

https://github.com/ualter/quarkus

https://www.youtube.com/watch?v=rJFgdFIs_k8