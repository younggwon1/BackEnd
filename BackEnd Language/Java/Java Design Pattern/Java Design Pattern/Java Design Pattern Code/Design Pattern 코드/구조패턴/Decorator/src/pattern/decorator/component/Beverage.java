package pattern.decorator.component;

/**
 * 
 * @author mz01-gyk
 * Component
 * 가장 상위의 슈퍼 클래스인 beverage 클래스이다. 
 * 음료의 공통적인 성질을 따로 뺀 것으로 카페에서 판매하는 모든 음료는 이 클래스를 상속받아야한다.
 * 
 */
public abstract class Beverage {

	protected String description = "no title"; // 음료 이름

	public abstract int cost();

	public String getDescription() {
		return description;
	}

}
