package pattern.factory2;

/**
 * 
 * @author mz01-gyk
 * Factory Class
 * getComputer 메소드를 살펴보면 static 메소드로 구현되었다는 점을 살펴볼 수 있고,
 * 메소드 내부 코드를 보면 type의 값이 "PC"일 경우 PC 클래스의 인스턴스를,
 * "Server"일 경우 Server 클래스의 인스턴스를 리턴하는 것을 볼 수 있다.
 * 
 */
public class ComputerFactory {

	public static Computer getComputer(String type, String ram, String hdd, String cpu) {
		if ("PC".equalsIgnoreCase(type))
			return new PC(ram, hdd, cpu);
		else if ("Server".equalsIgnoreCase(type))
			return new Server(ram, hdd, cpu);

		return null;
	}
}
