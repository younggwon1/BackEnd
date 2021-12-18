package pattern.prototype2;

/**
 * 
 * @author mz01-gyk
 * 다음 코드를 보게되면 clone() 메소드를 재정의하기 위해 Cloneable 인터페이스를 구현
 * 즉, 복제를 구현하기 위해서 Cloneable 인터페이스를 구현한다.
 * Cloneable 구현 시 clone 메소드를 오버라이드하여 정의 해주어야한다.
 * object를 반환하는 타입으로 clone()을 정의하고, 기능은 객체를 복제한 결과를 반환하는 구조이다.
 *
 * Prototype
 * 
 */
public class Cookie implements Cloneable{
	private String name;
	
	public Cookie() {
		System.out.println("prototype call");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Object clone() {
		try {
			Cookie copy = (Cookie)super.clone();
			return copy;
		}
		catch(CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String toString() {
		return "Cookie [name=" + this.name + "]";
	}
}
