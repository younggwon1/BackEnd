package CarSort;

import HornOnOffImpl.HornOn;
import LightOnOffImpl.LightOn;
import MovingDirectionImpl.Front;
import TrunkOpenCloseImpl.TrunkOpen;
import WindowOpenCloseImpl.WindowClose;

public class SmallCar extends Car {
	public SmallCar() {
		hornOnOff = new HornOn();
		lightOnOff = new LightOn();
		movingDirection = new Front();
		trunkOpenClose = new TrunkOpen();
		windowOpenClose = new WindowClose();
	}
}
