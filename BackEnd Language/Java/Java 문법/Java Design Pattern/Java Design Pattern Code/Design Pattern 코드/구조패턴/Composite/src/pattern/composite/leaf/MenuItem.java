package pattern.composite.leaf;

import pattern.composite.component.MenuComponent;

/**
 * 
 * @author mz01-gyk
 * ​MenuItem이 Leaf이다.
 * 기존 타입의 데이터로 name, description, price만 존재한다.
 * MenuItem은 오직 출력만 하는 기능을 제공할 뿐 이외의 기능은 없다.
 *
 */
public class MenuItem extends MenuComponent {
	private String name;
	private String description;
	private double price;

	public MenuItem(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void print() {
		System.out.print(getName());
		System.out.println(" ," + getPrice());
		System.out.println(" -- " + getDescription());
	}
}
