package pattern.composite.composite;


import java.util.ArrayList;
import java.util.List;

import pattern.composite.component.MenuComponent;

/**
 * 
 * @author mz01-gyk
 * Menu가 Composite가 된다.
 * MenuComponent를 List형태로 가지고 있고 menuComponents를 통해 행동을 정의하고 저장할 수 있다.
 * Menu, MenuItem 모두 menuComponents에 추가될 수 있다.
 * 
 */
public class Menu extends MenuComponent {
	private List<MenuComponent> menuComponents;
	private String name;

	public Menu(String name) {
		menuComponents = new ArrayList<>();
		this.name = name;
	}

	@Override
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void print() {
		System.out.println("\n           " + getName());
		System.out.println("--------------------------------");
		for (MenuComponent menuComponent : menuComponents) {
			menuComponent.print();
		}
	}
}
