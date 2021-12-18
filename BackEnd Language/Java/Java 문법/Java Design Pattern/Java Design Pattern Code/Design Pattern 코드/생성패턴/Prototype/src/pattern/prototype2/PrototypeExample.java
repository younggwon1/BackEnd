package pattern.prototype2;

/**
 * 
 * @author mz01-gyk
 * 원하고자하는 객체를 생성한다. 반복문을 이용해서 100개의 객체를 복제하여 생성한다.
 * 만약 clone()을 사용하지 않았다면 100번의 new 연산이 필요하므로 비효율적인 설계가 된다.
 * 복제할 객체를 생성하고 (prot) 반복문을 돌면서 복제 후 각 경우에 맞게 오퍼레이션을 수행한다.
 *
 *
 * Main
 * 
 */
public class PrototypeExample {

	public static void main(String[] args) {
		Cookie tempCookie = null;
		Cookie prot = new CocountCookie();
		
		CookieMachine cm = new CookieMachine(prot);
		
		//동일한 객체를 new 연산을 이용해서 생성하는 것이 아닌 복제방식을 이용하여 저비용으로 관리 가능
		for(int i=0; i<100; i++) {
			tempCookie = cm.makeCookie();
			tempCookie.setName("seochangwook" + 1);
			System.out.println("["+i+"] : " + tempCookie.toString() + ", hashcode : " + tempCookie.hashCode());
		}

	}

}
