# [Spring] RestTemplate

### **RestTemplate이란?**

RestTemplate은 Spring 3.0 부터 지원하는 템플릿으로 Spring에서 HTTP 통신을 RESTful 형식에 맞게 손쉬운 사용을 제공해주는 템플릿이다. Rest API 서비스를 요청후 응답 받을 수 있도록 설계되었으며 HTTP 프로토콜의 메소드(ex. GET, POST, DELETE, PUT)들에 적합한 여러 메소드들을 제공한다. Java에서 사용되는 다른 템플릿(ex. JdbcTemplate)들 처럼 단순 메소드 호출 만으로 복잡한 작업을 쉽게 처리할 수 있는 것이 특징이다.

 

### **RestTemplate의 특징**

- Spring 3.0 부터 지원하는 Spring의 HTTP 통신 템플릿
- HTTP 요청 후 JSON, XML, String 과 같은 응답을 받을 수 있는 템플릿
- Blocking I/O 기반의 동기방식을 사용하는 템플릿
- RESTful 형식에 맞추어진 템플릿
- Header, Content-Tpye등을 설정하여 외부 API 호출
- Server to Server 통신에 사용



<img width="847" alt="스크린샷 2021-11-22 오후 1 46 58" src="https://user-images.githubusercontent.com/73063032/142802629-7d299240-838f-46aa-b3a6-cec6ca17ae84.png" style="zoom:67%;" >



1. 애플리케이션이 RestTemplate을 생성하고 URI, HTTP 메소드 등을 헤더에 담아 요청
2. RestTemplate은 HttpMessageConverter를 사용하여 RequestEntity를 요청메세지로 변환
3. RestTemplate은 ClitentHttpRequestFactory로 부터 ClientHttpRequest를 가져온후 요청을 보냄
4. ClientHttpRequest는 요청메세지를 만들어 HTTP 프로토콜을 통해 서버와 통신
5. RestTemplate은 ReponseErrorHandler로 오류를 확인
6. ResponseErrorHandler는 오류가 있다면 ClientHttpResponse에서 응답 데이터를 가져와서 처리
7. RestTemplate은 HttpMessageConverter를 이용해서 응답메세지를 Java Object(Response Type)로 변환
8. 애플리케이션에 반환



### **RestTemplate의 메소드**

| **메소드**      | **HTTP** | **설명**                                                |
| --------------- | -------- | ------------------------------------------------------- |
| getForObject    | GET      | HTTP GET 요청 후 결과는 객체로 반환                     |
| getForEntity    | GET      | HTTP GET 요청 후 결과는 ResponseEntity로 반환           |
| postForLocation | POST     | HTTP POST 요청 후 결과는 헤더에 저장된 URL을 반환       |
| postForObject   | POST     | HTTP POST 요청 후 결과는 객체로 반환                    |
| postForEntity   | POST     | HTTP POST 요청 후 결과는 ResponseEntity로 반환          |
| delete          | DELETE   | HTTP DELETE 요청                                        |
| headForHeaders  | HEADER   | HTTP HEAD 요청 후 헤더정보를 반환                       |
| put             | PUT      | HTTP PUT 요청                                           |
| patchForObject  | PATCH    | HTTP PATCH 요청 후 결과는 객체로 반환                   |
| optionsForAllow | OPTIONS  | 지원하는 HTTP 메소드를 조회                             |
| exchange        | Any      | 원하는 HTTP 메소드 요청 후 결과는 ResponseEntity로 반환 |
| execute         | Any      | Request/Response의 콜백을 수정                          |



### 설정

[Springboot Resttemplate으로 api호출하기 (ex,영진위 데이터 호출 resttemplate.exchange 활용)](https://vmpo.tistory.com/27)

**build.gradle**

````groovy
dependencies {

    implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-web-services'
    implementation('org.apache.httpcomponents:httpclient:4.5')
 
    compile group: 'com.fasterxml.jackson.core', name: 'jackson-core', version: '2.9.3'
    compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.9.3'
    compile group: 'com.google.code.gson', name: 'gson', version: '2.8.5'
    compile group: 'com.googlecode.json-simple', name: 'json-simple', version: '1.1.1'
}
````



**선언**

````java
ResponseEntity<원하는 클래스 타입> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, 원하는클래스타입.class);
````



---



#### [Sending GET request with Authentication headers using restTemplate](https://stackoverflow.com/questions/21101250/sending-get-request-with-authentication-headers-using-resttemplate)

>  => **RestTemplate을 사용할 때 Token 정보를 추가하고 싶을 때 참고할 코드**

````java
private HttpHeaders createHttpHeaders(String user, String password)
{
    String notEncoded = user + ":" + password;
    String encodedAuth = "Basic " + Base64.getEncoder().encodeToString(notEncoded.getBytes());
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.add("Authorization", encodedAuth);
    return headers;
}

private void doYourThing() 
{
    String theUrl = "http://blah.blah.com:8080/rest/api/blah";
    RestTemplate restTemplate = new RestTemplate();
    try {
        HttpHeaders headers = createHttpHeaders("fred","1234");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<String> response = restTemplate.exchange(theUrl, HttpMethod.GET, entity, String.class);
        System.out.println("Result - status ("+ response.getStatusCode() + ") has body: " + response.hasBody());
    }
    catch (Exception eek) {
        System.out.println("** Exception: "+ eek.getMessage());
    }
}
````



>  => restTemplate 설정 메서드 및 HttpHeader에 username , Token 값 생성 관련 코드

````java
package com.ccp.api.sttl.batchmonitor.service;
 
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
 
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
 
import com.ccp.api.sttl.batchmonitor.model.BatchJobRes;
 
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@Service
@RequiredArgsConstructor
public class BatchMonitorService {
          
           // Jenkins Token 정보
           private final String HEADER_BASIC = "basic ";
           private final String username = "";
           private final String accessToken = "";
          
           private final String memberBatchUrl = "";
           private final String orderBatchUrl = "";
          
           // restTemplate 설정 메서드
           public RestTemplate restTemplateConfig() {
                     HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
                     factory.setConnectTimeout(5000); // 타임아웃 설정 5초
                     factory.setReadTimeout(5000); // 타임아웃 설정 5초
                    
                     // HttpClient 관련 설정
                     HttpClient httpClient = HttpClientBuilder.create()
                                                                                                .setMaxConnTotal(50) // 최대 커넥션 수
                                                                                                .setMaxConnPerRoute(20) // 각 호스트 당 커넥션 풀에 생성가능한 커넥션 수
                                                                                                .build();
                    
                     factory.setHttpClient(httpClient);
                     RestTemplate restTemplate = new RestTemplate(factory);
                     return restTemplate;
           }
          
           // HttpHeader에 username , Token 값 생성
           public HttpHeaders createHttpHeaders(String username , String accessToken) {
                     String authHeaderValue = HEADER_BASIC + Base64.getEncoder().encodeToString((username + ":" + accessToken).getBytes(StandardCharsets.UTF_8));
                     HttpHeaders header = new HttpHeaders();
                     header.setContentType(new MediaType("application" , "json" , Charset.forName("UTF-8")));
                     header.set("Authorization", authHeaderValue);
                     return header;
           }
          
           // 1. 각각에 해당하는 배치 job 목록 List 받기
           public ResponseEntity<BatchJobRes> getBatchJobList() {
                    
                     // restTemplate 설정 메서드 호출
                     RestTemplate restTemplate = restTemplateConfig();
                     // HttpHeader 메서드 호출
                     HttpHeaders header = createHttpHeaders(username , accessToken);
                               
                     HttpEntity<BatchJobRes> entity = new HttpEntity<BatchJobRes>(header);
                     ResponseEntity<BatchJobRes> responseEntity = restTemplate.exchange(memberBatchUrl,
                                           HttpMethod.GET,
                                           entity,
                                           new ParameterizedTypeReference<BatchJobRes>() {});
                               
                     System.out.println("responseEntity.getBody()" + responseEntity.getBody());
                     System.out.println("responseEntity.getStatusCodeValue()" + responseEntity.getStatusCodeValue());
                     System.out.println("responseEntity.getStatusCode()" + responseEntity.getStatusCode());
                     System.out.println("responseEntity.getHeaders()" + responseEntity.getHeaders());
                    
                     return responseEntity;
           }
}
````





---

### 📢 REST 서비스의 호출 방법

- RestTemplate
  - Spring 3부터 지원, REST API 호출이후 응답을 받을 때까지 기다리는 동기 방식
- AsyncRestTemplate
  - Spring 4에 추가된 비동기 RestTemplate이다.
- WebClient
  - Spring 5에 추가된 논블럭, 리엑티브 웹 클라이언트로 동기, 비동기 방식을 지원한다.

---







참고

[Docs Class RestTemplate](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html)

[[WEB] RestTemplate을 이용하여 API 호출하기](https://minkwon4.tistory.com/178)

[RestTemaplte 사용방법](https://recordsoflife.tistory.com/32)



