package pattern.composite.component;

/**
 * 
 * @author mz01-gyk
 * MenuComponent가 Component가 된다.
 * Composite와 Leaf가 가질 수 있는 모든 행동을 가진다.
 * 만약 하위 클래스들이 이 행동을 구현하지 않는다면 예외를 던지도록 설계하였다.
 * 
 */
public abstract class MenuComponent {
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }


    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}
