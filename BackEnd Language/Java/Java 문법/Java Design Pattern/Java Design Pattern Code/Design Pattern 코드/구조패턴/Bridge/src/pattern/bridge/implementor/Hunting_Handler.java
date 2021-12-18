package pattern.bridge.implementor;

/**
 * 
 * @author mz01-gyk
 * 동물이 가질 수 있는 '사냥 방식'들이 가져야 할 공통 인터페이스를 정의하고 있습니다.
 *
 */
public interface Hunting_Handler {
	public void Find_Quarry();

	public void Detected_Quarry();

	public void attack();
}
