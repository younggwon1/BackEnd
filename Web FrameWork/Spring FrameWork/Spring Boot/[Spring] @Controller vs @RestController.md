# [Spring] @Controller vs @RestController

> Spring에서 컨트롤러를 지정해주기 위한 어노테이션은 @Controller와 @RestController가 있다. 
>
> 전통적인 Spring MVC의 컨트롤러인 @Controller와 Restuful 웹 서비스의 컨트롤러인 @RestController의 주요한 차이점은 **HTTP Response Body가 생성되는 방식**이다.



#### 들어가기 전,,, 참고 사항

[[Spring]Dispatcher-Servlet(디스패처 서블릿)이란?](https://mangkyu.tistory.com/18?category=761302 )



### @Controller(Spring MVC Controller)

#### **[ Controller - View ]**

- @Controller는 **주로 View를 반환하기 위해 사용**

  - Spring MVC Container는 Client의 요청으로부터 **View를 반환**

    <img width="542" alt="스크린샷 2021-11-18 오후 4 27 18" src="https://user-images.githubusercontent.com/73063032/142371184-d9d22b3f-a7ad-4d85-a4c5-a4cca4b7e911.png" style="zoom: 67%;" >

    1. Client는 URI 형식으로 웹 서비스에 요청을 보낸다.

    2. Mapping되는 Handler와 그 Type을 찾는 DispatcherServlet이 요청을 인터셉트한다.

    3. Controller가 요청을 처리한 후에 응답을 DispatcherServlet으로 반환하고, DispatcherServlet은 View를 사용자에게 반환한다.

  - @Controller가 View를 반환하기 위해서는 ViewResolver가 사용되며, ViewResolver 설정에 맞게 View를 찾아 렌더링한다.



#### **[ Controller - Data ]**

- Spring MVC의 컨트롤러에서도 Data를 반환해야 하는 경우도 있다. Spring MVC의 @Controller에서는 데이터를 반환하기 위해 **@ResponseBody** 어노테이션을 활용해주어야 한다. 이를 통해 **@Controller도 Json 형태로 데이터를 반환**할 수 있다.

  <img width="548" alt="스크린샷 2021-11-18 오후 4 34 08" src="https://user-images.githubusercontent.com/73063032/142371973-7a47aa80-c698-407b-91ed-4fb58383b053.png" style="zoom:67%;" >

  1. Client는 URI 형식으로 웹 서비스에 요청을 보낸다.

  2. Mapping되는 Handler와 그 Type을 찾는 DispatcherServlet이 요청을 인터셉트한다.

  3. @ResponseBody를 사용하여 Client에게 Json 형태로 데이터를 반환한다.



### @RestController(Spring Restful Controller)

- @RestController는 Spring MVC @Controller에 @ResponseBody가 추가된 것이다. 

- 당연하게도 @RestController의 주용도는 JSON/XML 형태로 객체 데이터를 반환하는 것이다.

- **@RestController = @Controller + @ResponseBody**

  <img width="537" alt="스크린샷 2021-11-18 오후 4 37 14" src="https://user-images.githubusercontent.com/73063032/142372367-b547a4f9-d90d-4a62-b647-817aeb485e50.png" style="zoom:67%;" >

  1. Client는 URI 형식으로 웹 서비스에 요청을 보낸다.

  2. Mapping되는 Handler와 그 Type을 찾는 DispatcherServlet이 요청을 인터셉트한다.

  3. RestController는 해당 요청을 처리하고 데이터를 반환한다.



#### 실행 흐름

##### @Controller의 실행 흐름

Client -> Request -> Dispatcher Servlet -> Handler Mapping -> **Controller** -> View -> Dispatcher Servlet -> Response -> Client



##### @ResponseBody의 실행 흐름

Client -> Request -> Dispatcher Servlet -> Handler Mapping -> **Controller (ResponseBody)** -> Response -> Client



##### @RestController의 실행 흐름

Client -> HTTP Request -> Dispatcher Servlet -> Handler Mapping -> **RestController (자동 ResponseBody 추가)** -> HTTP Response -> Client



#### 차이점

> 근본적인 차이점은 **<u>@Controller</u>의 역할은 Model 객체를 만들어 데이터를 담고 View를 찾는 것**이지만, 
>
> **<u>@RestController</u>는 단순히 객체만을 반환하고 객체 데이터는 JSON 또는 XML 형식으로 HTTP 응답에 담아서 전송**한다. 
>
> 물론 @Controller와 @ResponseBody를 사용하여 만들 수 있지만 이러한 방식은 RESTful 웹서비스의 기본 동작이기 때문에 
>
> Spring은 @Controller와 @ResponseBody의 동작을 조합한 @RestController을 도입했다.
>
> 따라서 HTTP Response Body에 데이터를 담는 것은 RESTful 웹 서비스에 대한 응답에 매우 유용하다. 
>
> 왜냐하면 뷰를 반환하는 대신 데이터를 반환하기 때문이다.



````java
@Controller
@ResponseBody
public class MVCController{
	logic...
}

---

@RestController
public class ReftFulController{
	logic...
}
````





<img width="835" alt="스크린샷 2021-11-18 오후 4 44 22" src="https://user-images.githubusercontent.com/73063032/142373245-9013bf73-67c8-4640-8f33-d4a96646f016.png" style="zoom:67%;" >



참고

[@Controller vs @RestController](https://mangkyu.tistory.com/49 )

[@Controller와 @RestController의 차이점](https://dncjf64.tistory.com/288)

