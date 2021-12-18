# [Spring] @RequestMapping

> http request로 들어오는 url을 특정 controller 클래스나 메소드로 연결시키는 역할을 한다.

- URL 을 컨트롤러의 메서드와 매핑할 때 사용하는 어노테이션
- 요청 주소(url) 설정, 요청 방식(GET, POST, DELETE, PATCH) 설정
- 요청방식들을 동시에 설정 가능
  - @RequestMapping(value = "/test7", method = {RequestMethod.**GET**, RequestMethod.**POST**})



#### 컨트롤러에 @RequestMapping 어노테이션을 통해 URL을 매핑 해 주는데, 다음과 같이 구분할 수 있다.

1) **메서드** 수준의 @RequestMapping

   ````java
   @Controller 
   public class TestController {
     
   	@RequestMapping("/testcode/test") 
     public String getTestCode(Model model) { 
        return "testCodeList"; 
     }
     
   }

2) **클래스** 수준의 @RequestMapping

   ````java
   @Controller 
   @RequestMapping("/testcode/test") 
   public class TestController {
     
   	@RequestMapping("/method") 
     public String getTestCode(Model model) { 
        return "testCodeList"; 
     }
     
   }

3) **HTTP Request Method**만 사용하는 @RequestMapping

   ````java
   @Controller 
   @RequestMapping("/testcode/test") 
   public class TestController {
     
     // RequestMethod.GET , RequestMethod.POST , RequestMethod.PUT , RequestMethod.DELETE
   	@RequestMapping (method = RequestMethod.GET)
     public String getTestCode(Model model) { 
        return "testCodeList"; 
     }
     
   }



참고

[Spring MVC 예제 - @RequestMapping 어노테이션 예제](https://woolbro.tistory.com/43 )

[[스프링/Spring] 요청방식 (@RequestMapping / @GetMapping / @PostMapping)](https://eunoia3jy.tistory.com/58)

