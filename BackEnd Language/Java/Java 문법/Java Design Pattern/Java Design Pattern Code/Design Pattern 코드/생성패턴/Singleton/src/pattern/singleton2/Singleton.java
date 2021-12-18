package pattern.singleton2;

/**
 * 
 * @author mz01-gyk
 * 
 * Eager Initialization(이른 초기화)
 * static 키워드의 특징을 이용해서 클래스 로더가 초기화하는 시점에서 정적 바인딩을 통해
 * 해당 인스턴스를 메모리에 등록해서 사용하는 것이다.
 * 
 * 클래스 로더에 의해 클래스가 최초로 로딩될 때 객체가 생성되기 때문에 Thread-safe하다.
 * 
 * 아래와 같은 방식으로 singleton을 정적 팩토리 방식으로 생성하면, 간결하다는 장점이 존재한다.
 * 하지만 Reflection에 의해서 객체의 인스턴스는 단 1개만 보장한다는 방식이 파괴되어, 
 * 직렬화 과정에서 같은 객체라는 보장이 되지 않는다.
 * Reflection : JVM에서 실행되는 애플리케이션의 런타임 동작을 검사하거나 수정할 수 있는 기능이 필요한 프로그램에서 사용된다.
 *              클래스, 인터페이스, 메소드들을 찾을 수 있고, 객체를 생성하거나 변수를 변경할 수 있고 메소드를 호출할 수 있다.
 * 
 */
public class Singleton {
	private static Singleton singleton = new Singleton();
	private Singleton() {
		System.out.println("인스턴스를 생성하였습니다.");
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
}
