package pattern.decorator.concretecomponent;

import pattern.decorator.component.Beverage;
import pattern.decorator.decorator.CondimentDecorator;

/**
 * 
 * @author mz01-gyk
 * ConcreteComponent
 * 첨가물 클래스로, 생성자에서 넘겨받은 Beverage의 인스턴스를 가지고, 현재 인스턴스에 구현 되어 있는 객체 (즉 음료 메뉴)의 필드와 메소드에 접근 합니다.
 */
public class Shot extends CondimentDecorator {

	Beverage beverage;

	public Shot(Beverage beverage) {
		super();
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + ", 샷";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return beverage.cost() + 400;
	}

}
