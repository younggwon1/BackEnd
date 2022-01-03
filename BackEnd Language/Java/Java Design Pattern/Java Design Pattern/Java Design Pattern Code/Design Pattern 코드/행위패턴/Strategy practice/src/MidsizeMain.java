import CarSort.Car;
import CarSort.MidsizeCar;

public class MidsizeMain extends Car{

	public static void main(String[] args) {
		Car midsizecar = new MidsizeCar();
		
		midsizecar.peformHornOnOff();
		midsizecar.performLightOnOff();
		midsizecar.performMovingDirection();
		midsizecar.performTrunkOpenClose();
		midsizecar.performWindowOpenClose();
	}

}
