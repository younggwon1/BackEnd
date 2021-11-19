# [Spring] Lombok 관련 어노테이션

> 종류
>
> @Setter, @Getter, @Data, @ToString, @EqualsAndHashCode , @NoArgsConstructor, @RequiredArgsConstructor, @AllArgsConstructor

[종류](http://ojc.asia/bbs/board.php?bo_table=LecEnterprise&wr_id=115)

[[자바] 자주 사용되는 Lombok 어노테이션](https://www.daleseo.com/lombok-popular-annotations/)

### 1. 접근자/설정자 자동 생성

#### @Getter와 @Setter

##### 1. @Getter

- Getter 메소드를 생성해 준다.
- 즉, 변수 값을 가져오는 메소드

##### 2. @Setter 

- Setter 메소드를 생성해 준다.
- 변수 값을 설정하는 메소드



`xxx`라는 필드에 선언하면 자동으로 `getXxx()`(boolean 타입인 경우, `isXxx()`)와 `setXxx()` 메소드를 생성해준다.

````java
@Getter 
@Setter
private String name;
````

위와 같이 특정 필드에 어노테이션을 붙여주면, 다음과 같이 자동으로 생성된 접근자와 설정자 메소드를 사용할 수 있어서 매우 편리하다.

````java
user.setName("홍길동");
String userName = user.getName();
````



또한, 필드 레벨이 아닌 **클래스 레벨**에 `@Getter` 또는 `@Setter`를 선언해줄 경우, 모든 필드에 접근자와 설정자가 자동으로 생성된다.

````java
@Getter 
@Setter
public class Employment {
	private String name;
	private int age;
	private String grade;
	...
    
    
  user.setName("홍길동");
  String userName = user.getName();
  
  user.setAge(25);
  int userAge = user.getAge();
  
  user.setGrade("College");
  String userGrade = user.getGrade();
}
````





### 2. ToString 메소드 자동 생성

#### @ToString

- `toString()` 메소드를 작성하는 것을 Lombok을 사용하면 `@ToString` 어노테이션만 클래스에 붙여주면 자동으로 생성해준다.

  - `toString()` 메소드 : `toString`*메서드는 **객체가 가지고 있는 정보나 값들을 문자열**로 만들어 반환하는 메소드이다.*

- 예제와 같이 `exclude` 속성을 사용하면, 특정 필드를 `toString()` 결과에서 제외시킬 수도 있다.

  ````java
  @Getter 
  @Setter
  @ToString(exclude = "password")
  public class User {
    private Long id;
    private String username;
    private String password;
    private int[] scores;
    
  	user.setId(1L);
  	user.setUsername("dale");
  	user.setUsername("1234");
  	user.setScores(new int[]{80, 70, 100});
  	System.out.println(user);
  }
  
  => User(id=1, username=1234, scores=[80, 70, 100])





### 3. equals, hashCode 자동 생성

#### @EqualsAndHashCode

[Java equals()와 hashCode()에 대해](https://nesoy.github.io/articles/2018-06/Java-equals-hashcode)

[[java] hashcode()와 equals() 메서드는 언제 사용하고 왜 사용할까?](https://jisooo.tistory.com/entry/java-hashcode%EC%99%80-equals-%EB%A9%94%EC%84%9C%EB%93%9C%EB%8A%94-%EC%96%B8%EC%A0%9C-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B3%A0-%EC%99%9C-%EC%82%AC%EC%9A%A9%ED%95%A0%EA%B9%8C)

- equlas와 hashcode 메소드를 만들어 준다.

  - **equlas()**
    - equals() 메소드와 비교연산자인 == 
      - == 비교를 위한 연산자
        - **주소의 값(자료의 위치의 값)을 비교한다.(Call By Reference)**
      - equals() 메소드
        - **equals() 메소드는 <u>객체끼리 내용</u>을 비교한다.(Call By value)**
        - 두 객체의 `내용이 같은지` 확인
  - **hashcode()**
    - hashcode는 객체의 주소 값을 변환하여 생성한 객체의 고유한 정수값이다. 따라서 **두 객체가 <u>동일한 객체</u>인지 판단**할 수 있다.
    - 두 객체가 `같은 객체인지` 확인

- `callSuper` 속성을 통해 `equals`와 `hashCode` 메소드 자동 생성 시 부모 클래스의 필드까지 감안할지 안 할지에 대해서 설정할 수 있다.

  즉, `callSuper = true`로 설정하면 부모 클래스 필드 값들도 동일한지 체크하며, `callSuper = false`로 설정(기본값)하면 자신 클래스의 필드 값들만 고려한다.





### 4. @Data

##### 1. @Data

- 클래스안의 모든 private 필드에 대해 @Getter와 @Setter를 적용하여 Setter/Getter를 만들어주고 클래스내에 @ToString 과@EqualsAndHashCode를 적용시켜 메소드를 오버라이드 해주며 @RequiredArgsConstructor를 지정해 준다.
- 클래스 레벨에서 `@Data` 어노테이션을 붙여주면, 모든 필드를 대상으로 접근자와 설정자가 자동으로 생성되고, `final` 또는 `@NonNull` 필드 값을 파라미터로 받는 생성자가 만들어지며, `toStirng`, `equals`, `hashCode` 메소드가 자동으로 만들어진다.

