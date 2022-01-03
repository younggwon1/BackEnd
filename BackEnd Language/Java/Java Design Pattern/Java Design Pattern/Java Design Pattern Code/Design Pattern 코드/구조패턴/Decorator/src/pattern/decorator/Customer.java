package pattern.decorator;

import pattern.decorator.component.Beverage;
import pattern.decorator.concretecomponent.Americano;
import pattern.decorator.concretecomponent.Shot;

public class Customer {

	public static void main(String[] args) {

		Beverage beverage = new Americano();
		beverage = new Shot(beverage); // beverage 필드에 Amerciano 인스턴스 저장
		beverage = new Shot(beverage); // beverage 필드에 Shot 인스턴스 저장

		System.out.println("메뉴 : " + beverage.getDescription());
		System.out.println("가격 : " + beverage.cost());

	}
}
