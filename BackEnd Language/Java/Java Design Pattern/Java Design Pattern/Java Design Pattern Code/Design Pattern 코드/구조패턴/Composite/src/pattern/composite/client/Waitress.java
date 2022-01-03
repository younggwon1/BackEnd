package pattern.composite.client;

/**
 * 클라이언트인 Waitress는 MenuComponent만을 참조하여 모든 메뉴들을 출력할 수 있다.
 */
import pattern.composite.component.MenuComponent;

public class Waitress {
	MenuComponent allMenus;

	public Waitress(MenuComponent getAllMenus) {
		this.allMenus = getAllMenus;
	}

	public void printMenu() {
		allMenus.print();
	}
}
