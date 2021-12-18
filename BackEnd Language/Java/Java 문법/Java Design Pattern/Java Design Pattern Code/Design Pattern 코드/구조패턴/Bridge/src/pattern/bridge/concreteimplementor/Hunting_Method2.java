package pattern.bridge.concreteimplementor;

import pattern.bridge.implementor.Hunting_Handler;

/**
 * 
 * @author mz01-gyk
 * Hunting_Handler 인터페이스를 상속받아 실제 기능에 해당하는 부분을 구현합니다.
 *
 */
public class Hunting_Method2 implements Hunting_Handler {
	public void Find_Quarry() {
		System.out.println("지상에서 찾는다");
	}

	public void Detected_Quarry() {
		System.out.println("노루 발견");
	}

	public void attack() {
		System.out.println("물어뜯는다.");
	}
}
