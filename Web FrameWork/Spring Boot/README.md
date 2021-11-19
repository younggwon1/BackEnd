# Spring Boot

| 어노테이션                   | 설명                                                         |
| ---------------------------- | ------------------------------------------------------------ |
| @SuppressWarnings            | 컴파일러가 일반적으로 경고하는 내용 중 이 내용은 제외시킬 때 사용 |
| @Entity                      | 퍼시스턴스화 될 클래스를 선언                                |
| @Table                       | DB에 있는 테이블과 맵핑 시킨다.                              |
| @Data                        | 각 필드의 setter, getter가 자동 생성                         |
| @EqualsAndHashCode           | Equals 와 hashCode 함수를 만들어 줌                          |
| @JsonIgnoreProperties        | 클래스 내에 없는 필드가 json에 존재할 때 에러 방지 설정      |
| @GeneratedValue              | primary 컬럼에 고유값을 자동으로 생성 부여                   |
| @Id                          | 이 클래스의 어느 속성이 유일한 식별자 인지를 가리킴          |
| @Enumerated                  | Java Enum class를 표현                                       |
| @Column                      | 컬럼 길이, 널 값, 제약과 같은 세부사항을 지정할 수 있게 함   |
| @Repository                  | 해당 클래스에서 발생하는 DB 관련 예외를 spring의 DAOException으로 전환 |
| @Service                     | 비즈니스 로직이 들어가는 Service로 등록이 됨                 |
| @Autowired                   | Spring의 의존관계(DI)를 자동으로 설정, 타입(by type)으로 연결 |
| @Qualifier                   | 동일한 타입의 빈 객체들 중에서 특정 빈을 사용하도록 설정     |
| @PostConstruct               | 의존하는 객체를 설정한 이후에 초기화 작업을 수행할 메서드에 수행 |
| @PreDestory                  | 컨테이너에서 객체를 제거하기 전에 호출 될 메서드에 적용      |
| @Target                      | 어디에 어노테이션을 넣을 수 있는지를 서술                    |
| @Retention                   | 지속성을 설정, 어떻게 저장할 것인지                          |
| @Documented                  | 어노테이션이 기본으로 javadoc 및 유사한 툴에 의해 문서화 되는 것을 나타냄 |
| @AllArgsConstructor          | 모든 인자의 생성자를 자동으로 생성                           |
| @NoArgsConstructor           | 인자가 없는 생성자를 생성                                    |
| @MappedSuperclass            | 해당 어노테이션이 정의된 class를 상속받은 entity에는 해당 컬럼이 자동으로 생성/매핑 |
| @JsonSerialize               | Annotation use for configuring serialization aspects, by attaching to "getter" methods or fields, or to value classes |
| @Value                       | 프로퍼티값을 파라미터에 적용                                 |
| @Configuration               | 스프링 IoC 컨테이너가 해당 클래스를 빈 정의의 소스로 사용    |
| @EnableAsync                 | 스프링 XML 설정의 <task:annotation-driven>을 대신해서 자바에 설정 |
| @EnableScheduling            | 스프링 스케줄 task 실행을 할 수 있게 함                      |
| @EnableTransactionManagement | 스프링 XML 설정의 <tx:annotation-driven/>을 대신해서 자바에 설정 |
| @PropertySource              | Property 파일을 Environment로 로딩                           |
| @EnableJpaRepositories       | JPA repositories를 할 수 있게 함                             |
| @EnableAspectJAutoProxy      | 스프링 XML 설정의 <aop:aspectj-autoproxy/>을 대신해서 자바에 설정 |
| @ComponentScan               | 스프링 XML 설정의 <context:component-scan>을 대신해서 자바에 설정 |
| @Resource                    | 어플리케이션에서 필요로 하는 자원을 자동 연결할 때 사용, 이름(by name)으로 연결 |
| @Bean                        | 스프링 XML 설정의 <bean />과 동일한 기능을 제공              |
| @EnableTransactionManagement | 스프링의 annotaion-driven 트랜잭션 관리기능을 할 수 있게 함  |
| @MapperScan                  | Mybatis의 mapper 등록을 자바에 설정                          |
| @ControllerAdvice            | 예외 발생시 작업을 처리할 수 있게 함, 스프링 프레임워크 3.2에서 추가 |
| @Controller                  | Spring MVC의 Controller 클래스 선언을 단순화 시켜줌          |
| @RequestMapping              | Url을 class 또는 method와 맵핑 시켜주는 역할                 |
| @ResponseBody                | HTTP body 부분만 전달 XML, JSON으로 출력 할 때 사용          |
| @Api                         | Api가 어떤 역할을 하는 지 표시                               |
| @ApiOperation                | Api의 기능을 표시                                            |
| @ApiParam                    | Api에서 사용할 파라미터를 표시                               |
| @Aspect                      | Spring은 자동적으로 @Aspect 어노테이션을 포함한 클래스를 검색하여 Spring AOP 설정에 반영 |
| @Pointcut                    | pointcut은 결합점(Join points)을 지정하여 충고(Advice)가 언제 실행될지를 지정하는데 사용 @Pointcut 어노테이션을 사용 |
| @Before                      | 메소드가 수행 전에 수행 된다.Before advice는 @Before 어노테이션을 사용 |
| @After                       | 메소드 수행 후 무조건 수행된다. After (finally) advice는 @After 어노테이션을 사용 |
| @AfterThrowing               | 메소드가 수행 중 예외사항을 반환하고 종료하는 경우 수행된다. After throwing advice는 @AfterThrowing 어노테이션을 사용 |
| @RestController              | @Controller + @ResponseBody *http://spring.io/guides/gs/rest-service/ |
| @JsonInclude                 | @JsonInclude(JsonInclude.Include.NON_EMPTY) 필드가 empty이거나 null 일 때 json으로 변환되지 않도록 함 *http://fasterxml.github.io/jackson-annotations/javadoc/2.0.5/com/fasterxml/jackson/annotation/JsonInclude.Include.html |
| @Transactional               | DB 트랜잭션관리를 위해 사용 @Transactional 을 붙였는 데 사용하지 못하는 경우,1. innoDB 가 아닌 경우,2. interface 가 없는 경우,3. method 에 사용하였는 데, 해당 method를 같은 class 내부에서 호출하는 경우,2, 3번 -> @Transactional을 사용하면 해당 class를 spring에서 다시 proxy 형태로 실행/관리 하기 때문. |

