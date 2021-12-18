import CarSort.Car;
import CarSort.FullsizeCar;

public class FullsizeMain extends Car{

	public static void main(String[] args) {
		Car fullsizecar = new FullsizeCar();
		
		fullsizecar.peformHornOnOff();
		fullsizecar.performLightOnOff();
		fullsizecar.performMovingDirection();
		fullsizecar.performTrunkOpenClose();
		fullsizecar.performWindowOpenClose();
	}

}
