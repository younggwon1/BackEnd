package pattern.bridge;

import pattern.bridge.abstraction.Animal;
import pattern.bridge.concreteimplementor.Hunting_Method1;
import pattern.bridge.concreteimplementor.Hunting_Method2;
import pattern.bridge.refineabstraction.Bird;
import pattern.bridge.refineabstraction.Tiger;

/**
 * 
 * @author mz01-gyk
 * 실제 메인에서 동물 클래스를 생성하고 각각 다른 사냥 방식을 채택하는 모습이다.
 * 
 */
public class Main {

	public static void main(String argsp[]) {
		Animal tiger = new Tiger(new Hunting_Method2());
		Animal bird = new Bird(new Hunting_Method1());

		tiger.hunt();
		System.out.println("--------------");
		bird.hunt();
	}
}
