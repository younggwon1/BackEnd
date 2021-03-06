# Spring Security

다음 URL의 순서대로 참고하면 좋습니다.



#### 1. [Spring Security?](https://bravenamme.github.io/2019/08/01/spring-security-start/)

**Gradle + Spring Boot (build.gradle)**

```groovy
dependencies {
  compile "org.springframework.boot:spring-boot-starter-security"
}
```

**Gradle (build.gradle)**

```groovy
dependencies {
  compile 'org.springframework.security:spring-security-web:5.1.5.RELEASE'
  compile 'org.springframework.security:spring-security-config:5.1.5.RELEASE'
}
```



#### 2. [Spring Security Default Username, Password, Role](https://www.appsdeveloperblog.com/spring-security-default-username-password-role/)

````yaml
spring:
  security:
    user:
      name: admin
      password: admin
````



#### 3. [[Spring] Spring Security와 Swagger 같이 사용하는 법](https://devlog-wjdrbs96.tistory.com/349)

````java
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/v1/**" , "/v2/**").permitAll()
				.anyRequest().authenticated()
				.and()
					.csrf().disable()
				.formLogin()
					.and()
				.httpBasic();
	}
}
````



#### 4. [Spring Boot Session Security](https://www.skyer9.pe.kr/wordpress/?p=2444)

> 로그인 세션 유지 기간 설정

**application.yaml**

````yaml
server:
  servlet:
    session:
      timeout: 43200m      # 60m * 24h * 30d
      cookie:
        max-age: 43200m    # 60m * 24h * 30d
        name: SID
        http-only: true
        secure: true
````



#### 5. Controller

````java
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController implements WebMvcConfigurer{

    @RequestMapping ("/")
    public String home(HttpServletRequest request) {
    	
    	String url = request.getRequestURL().toString();
    	System.out.println(request.getRequestURL());
    	if(url.contains("localhost:8087")) {
    		return "redirect:/blockUrl/swaggerx-ui.html";
    	}
    	
    	// 외부 dependency를 호출하는 방법 고안,,,
    	return "swagger-ui.html";
    }  
}
````



#### 그외 각종 설정들에 대한 자료

[[Spring Boot] security를 사용한 접근제어](https://sarc.io/index.php/java/1857-spring-boot-security)

[[Spring] Spring Security - 낮코밤코](https://owin2828.github.io/devlog/2019/12/30/spring-18.html)

**- .requiresSecure()을 추가하면 선택한 URL에 HTTPS를 적용할 수 있다.**
**- .requiresInsecure()을 추가하면 항상 HTTP로 적용이 된다.**

````
http.requiresChannel().antMatchers("/").requiresSecure();

혹은

http.authorizeRequests()
    .antMatchers("/path/**").access("hasIpAddress('123.123.123.0/24')
    .and()
    .requiresChannel().antMatchers("/path/**").requiresSecure();
````

