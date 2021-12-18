package pattern.proxy;

import pattern.proxy.proxy.Proxy;
import pattern.proxy.subject.Subject;

/**
 * 
 * @author mz01-gyk
 * 클라이언트에서는 프록시로 접근하므로 접근이 제한된 것을 알 수 있다.
 * 
 */
public class Main {
	public static void main(String[] args) {
		Subject proxy = new Proxy();
		proxy.print();
	}
}
