package pattern.composite.test;

/**
 * 우선 각각 점심, 저녁, 디저트 메뉴를 생성하였다.
   전체 메뉴를 생성하였다. 전체 메뉴가 Component가 될 것이다.
   점심, 저녁 메뉴에 각 메뉴 아이템을 생성하여 추가한다.
   전체 메뉴에 점심, 저녁 메뉴를 추가한다.
   디저트 메뉴에 디저트 메뉴 아이템들을 추가한다.
   점심, 저녁 메뉴에 디저트 메뉴를 추가한다.
   웨이터는 Component인 allMenus 하나만 알고 있으면 모든 메뉴를 출력할 수 있다.
 */
import pattern.composite.client.Waitress;
import pattern.composite.component.MenuComponent;
import pattern.composite.composite.Menu;
import pattern.composite.leaf.MenuItem;

public class Main {
	public static void main(String[] args) {
		MenuComponent lunchMenu = new Menu("점심 메뉴");
		MenuComponent dinerMenu = new Menu("저녁 메뉴");
		MenuComponent dessertMenu = new Menu("디저트 메뉴");

		MenuComponent allMenus = new Menu("전체 메뉴");

		createLunchAndDinerMenu(lunchMenu, dinerMenu);

		allMenus.add(lunchMenu);
		allMenus.add(dinerMenu);

		createDesserMenu(dessertMenu);

		lunchMenu.add(dessertMenu);
		dinerMenu.add(dessertMenu);

		Waitress waitress = new Waitress(allMenus);
		waitress.printMenu();

	}

	private static void createLunchAndDinerMenu(MenuComponent lunchMenu, MenuComponent dinerMenu) {
		lunchMenu.add(new MenuItem("토스트 세트", "기본 토스트에 아메리카노 포함", 4000));
		lunchMenu.add(new MenuItem("아보카도 토스트 세트", "아보카도와 다양항 야채들이 들어간 샌드위치에 아메리카노 포함", 5000));
		dinerMenu.add(new MenuItem("알리오 올리오 파스타", "베이컨, 마늘, 핫페퍼가 들어간 파스타", 10000));
		dinerMenu.add(new MenuItem("마르게리타 피자", "토마토, 모차렐라, 바질이 들어간 피자", 12000));
	}

	private static void createDesserMenu(MenuComponent dessertMenu) {
		dessertMenu.add(new MenuItem("팥빙수", "팥과 연유가 가득 들어간 빙수", 4000));
		dessertMenu.add(new MenuItem("망고빙수", "망고가 들어간 빙수", 6000));
	}
}
