package pattern.flyweight;

import pattern.flyweight.concreteflyweight.Circle;
import pattern.flyweight.flyweightfactory.ShapeFactory;

/**
 * 
 * @author mz01-gyk
 * 로직에 의해 같은 색상의 원은 1개만 생성되며
 * 생성된 객체를 공유하는 것을 확인할 수 있다.
 */
public class Main {

	public static void main(String[] args) {
		String[] colors = {"red", "green", "blue", "yellow"};
		
		for (int i=0; i<10; i++) {
			Circle circle = (Circle)ShapeFactory.getCircle(colors[(int)(Math.random() * 4)]);
			circle.setX((int)(Math.random() * 100));
			circle.setY((int)(Math.random() * 4));
			circle.setRadius((int)(Math.random() * 10));
			circle.draw();
		}
	}

}
