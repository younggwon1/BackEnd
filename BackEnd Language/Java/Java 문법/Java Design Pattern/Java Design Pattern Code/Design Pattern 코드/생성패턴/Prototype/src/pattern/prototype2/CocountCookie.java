package pattern.prototype2;

/**
 * 
 * @author mz01-gyk
 * ConcretePrototype 클래스 구현 부분이다. Prototype 클래스를 상속받는 구조로 되어있다.
 * 다형적 생성자 기능이 필요한 경우 사용한다.
 * 
 * Concrete Prototype
 *
 */
public class CocountCookie extends Cookie{
	public CocountCookie() {
		System.out.println("Concrete Prototype call");
	}
}
