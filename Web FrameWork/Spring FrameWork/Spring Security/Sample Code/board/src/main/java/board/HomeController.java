package board;

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
