package pattern.decorator.decorator;

import pattern.decorator.component.Beverage;

/**
 * 
 * @author mz01-gyk
 * Decorator
 * 첨가물들은 CordimentDecorator라는 클래스를 상속받는다. 이 클래스는 Beverage 클래스를 확장한 것으로, 
 * 첨가물들에게 getDescription 메소드를 새롭게 정의하도록 만든다. 
 * 왜 이렇게 하냐면, Beverage를 상속받는 커피의 이름에 첨가물의 이름을 더 하기 위해 이렇게 한다.
 * 모든 첨가물들이 상속받아야하는 클래스이다.
 * 
 */
public abstract class CondimentDecorator extends Beverage {

	public abstract String getDescription();

}
