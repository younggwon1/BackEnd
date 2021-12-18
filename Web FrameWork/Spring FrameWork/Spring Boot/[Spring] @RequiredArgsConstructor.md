# [Spring] @RequiredArgsConstructor





`@NoArgsConstructor` 어노테이션은 파라미터가 없는 기본 생성자를 생성해준다. 



`@AllArgsConstructor` 어노테이션은 모든 필드 값을 파라미터로 받는 생성자를 만들어준다.



`@RequiredArgsConstructor` 어노테이션은 `final`이나 `@NonNull`인 필드 값만 파라미터로 받는 생성자를 만들어준다.

- 어떠한 빈에 생성자가 오직 하나만 있고 생성자의 파라미터 타입이 빈으로 등록가능한것이면 이 빈은 @Autowired없이도 의존성주입이 가능 
  - 즉, 생성자 안만들고 생성자주입이 가능하다!!







참고

[[Spring] @RequiredArgsConstructor 어노테이션을 사용한 "생성자 주입"](https://velog.io/@developerjun0615/Spring-RequiredArgsConstructor-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%9C-%EC%83%9D%EC%84%B1%EC%9E%90-%EC%A3%BC%EC%9E%85)