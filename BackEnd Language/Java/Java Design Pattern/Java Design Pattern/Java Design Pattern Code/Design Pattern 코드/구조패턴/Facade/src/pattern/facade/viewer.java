package pattern.facade;

import pattern.facade.facade.Facade;

/**
 * 
 * @author mz01-gyk
 * 사용자 입장에서는 이제 서브 클래스에 대해서 알 필요가 없다. 
 * 단지 Facde 객체의 view_Movie() 메서드를 호출하면서 서브 클래스들의 복잡한 기능을 수행할 수 있기 떄문다. 
 * 
 */
public class viewer {

	public static void main(String[] args) {

		Facade facade = new Facade("콜라", "어벤져스");
		facade.view_Movie();

	}

}