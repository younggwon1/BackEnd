package pattern.factory;

/**
 * 
 * @author mz01-gyk
 * 아래 클래스는 로봇 클래스의 이름을 String 인자로 받아서 직접 인스턴스를 만들어 낸다.
 *
 */
public class ModifiedSuperRobotFactory extends RobotFactory {
	@Override
	Robot createRobot(String name) {
		try {
			Class<?> cls = Class.forName(name);
			Object obj = cls.newInstance();
			return (Robot)obj;
		} catch (Exception e) {
			return null;
		}
	}
}
