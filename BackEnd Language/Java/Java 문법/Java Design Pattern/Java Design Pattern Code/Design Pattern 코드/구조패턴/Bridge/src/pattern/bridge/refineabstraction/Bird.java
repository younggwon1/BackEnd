package pattern.bridge.refineabstraction;

import pattern.bridge.abstraction.Animal;
import pattern.bridge.implementor.Hunting_Handler;

/**
 * 
 * @author mz01-gyk
 * Animal를 확장한 클래스입니다. 
 * 패턴을 보여주기 위해 억지적인 면은 있지만 실제로 확장의 의미로 Tiger 와 Bird만의 추가적인 기능을 가질 수도 있습니다.
 *
 */
public class Bird extends Animal {
	public Bird(Hunting_Handler hunting) {
		super(hunting);
	}

	public void hunt() {
		System.out.println("새의 사냥방식");
		Find_Quarry();
		Detected_Quarry();
		attack();
	}
}
