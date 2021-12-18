package pattern.bridge.abstraction;

import pattern.bridge.implementor.Hunting_Handler;

/**
 * 
 * @author mz01-gyk
 * 기능 부분에 해당되는 최상위 클래다. 
 * Hunting_Handler의 인스턴스를 가지고 각각의 Hunting_Handler를 상속받아 구현하고 있는 메서드들을 호출하고 있다.
 *
 */
public class Animal {

	private Hunting_Handler hunting;

	public Animal(Hunting_Handler hunting) {
		this.hunting = hunting;
	}

	public void Find_Quarry() {
		hunting.Find_Quarry();
	}

	public void Detected_Quarry() {
		hunting.Detected_Quarry();
	}

	public void attack() {
		hunting.attack();
	}

	public void hunt() {
		Find_Quarry();
		Detected_Quarry();
		attack();
	}
}
