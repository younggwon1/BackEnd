package pattern.prototype2;

/**
 * 
 * @author mz01-gyk
 * Client 클래스 구현 부분이다.
 * 객체를 복제하여 반환하는 코드가 구현되어있다.
 * 복제할 객체를 설정하고 clone을 하여 반환하는 메소드가 정의되어 있다.
 *
 * Client
 * 
 * 
 */
public class CookieMachine {
	private Cookie cookie;
	
	public CookieMachine(Cookie cookie) {
		this.cookie = cookie;
	}
	
	public Cookie makeCookie() {
		return (Cookie)cookie.clone(); //복제된 객체 반환 
	}
}
