package pattern.proxy.proxy;

import pattern.proxy.realsubject.RealSubject;
import pattern.proxy.subject.Subject;

/**
 * 
 * @author mz01-gyk
 * Proxy에서는 필드에 realSubject를 가지고 있다.
 * print() 메서드가 호출되면 프록시는 상황에 맞게 제어 혹은 기능을 추가할 수 있다.
 * 그 후 원하는 지점에 realSubject의 print()를 호출하여 실제 서비스를 수행한다.
 *
 */
public class Proxy implements Subject {

	Subject realSubject;

	@Override
	public void print() {
		realSubject = new RealSubject();
		System.out.println("프록시가 제어 합니다.");
		realSubject.print();
	}
}
