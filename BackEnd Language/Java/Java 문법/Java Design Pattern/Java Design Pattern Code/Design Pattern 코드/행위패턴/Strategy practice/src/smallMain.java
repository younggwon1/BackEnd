import CarSort.Car;
import CarSort.SmallCar;


public class smallMain {

	public static void main(String[] args) {
		Car smallcar = new SmallCar();
		
		smallcar.peformHornOnOff();
		smallcar.performLightOnOff();
		smallcar.performMovingDirection();
		smallcar.performTrunkOpenClose();
		smallcar.performWindowOpenClose();

	}

}
