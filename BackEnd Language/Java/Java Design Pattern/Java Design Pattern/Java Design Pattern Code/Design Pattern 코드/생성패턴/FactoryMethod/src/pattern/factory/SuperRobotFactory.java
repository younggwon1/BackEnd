package pattern.factory;

/**
 * 
 * @author mz01-gyk
 * 아래 클래스는 기본 팩토리 클래스를 상속받아 실제 로직을 구현한 팩토이다.
 *
 */
public class SuperRobotFactory extends RobotFactory{
	@Override
	Robot createRobot(String name) {
		switch (name) {
		case "super":
			return new SuperRobot();
		case "power":
			return new PowerRobot();
		}
		return null;
	}
}
