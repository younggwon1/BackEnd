package pattern.factory;

/** 
 * 
 * @author mz01-gyk
 * 팩토리 메소드 패턴의 꽃은 팩토리 클래스이다.
 * 다음 코드는 기본 팩토리 클래스이다.
 *
 */
public abstract class RobotFactory {
	abstract Robot createRobot(String name);
}
