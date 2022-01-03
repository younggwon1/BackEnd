package pattern.factory;

/** 
 * 
 * @author mz01-gyk
 *  Robot(abstract class)
	┗ SuperRobot
	┗ PowerRobot

    RobotFactory(abstract class)
	┗ SuperRobotFactory
	┗ ModifiedSuperRobotFactory
	두 종류의 로봇과 두 종류의 로봇공장을 만들 예정
	
	메인 프로그램에서 new 키워드가 없다는 것을 확인할 수 있다. 객체 생성을 팩토리 클래스에 위임한 결과이다.
	또한 메인 프로그램은 어떤 객체가 생성되었는지 신경쓰지 않고 단지 반환된 객체를 사용만하면 된다.
	또한, 새로운 로봇이 추가되고 새로운 팩토리가 추가된다 하더라도 메인 프로그램에서 변경할 코드는 최소화된다.
 *
 **/
public class FactoryMain {
	public static void main(String[] args) {

		RobotFactory rf = new SuperRobotFactory();
		Robot r = rf.createRobot("super");
		Robot r2 = rf.createRobot("power");

		System.out.println("***** SuperRobotFactory *****");
		System.out.println(r.getName());
		System.out.println(r2.getName());

		RobotFactory mrf = new ModifiedSuperRobotFactory();
		Robot r3 =  mrf.createRobot("pattern.factory.SuperRobot");
		Robot r4 =  mrf.createRobot("pattern.factory.PowerRobot");

		System.out.println("***** ModifiedSuperRobotFactory *****");
		System.out.println(r3.getName());
		System.out.println(r4.getName());
	}
}