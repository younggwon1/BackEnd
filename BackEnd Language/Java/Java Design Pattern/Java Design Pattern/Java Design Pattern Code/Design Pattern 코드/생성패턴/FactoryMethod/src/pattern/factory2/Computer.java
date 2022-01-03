package pattern.factory2;

/**
 * 
 * @author mz01-gyk 
 * Super Class. Super Class를 만들었으니 
 * PC, Server라는 이름의 서브 클래스를 생성해보자.
 *
 */
public abstract class Computer {

	public abstract String getRAM();

	public abstract String getHDD();

	public abstract String getCPU();

	@Override
	// toString() : 인자를 취하지 않고 문자열을 반환한다.
	public String toString() {
		return "RAM= " + this.getRAM() + ", HDD=" + this.getHDD() + ", CPU=" + this.getCPU();
	}
}
