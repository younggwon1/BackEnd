package CarSort;

import HornOnOffImpl.HornOn;
import LightOnOffImpl.LightOff;
import MovingDirectionImpl.Left;
import TrunkOpenCloseImpl.TrunkOpen;
import WindowOpenCloseImpl.WindowClose;

public class FullsizeCar extends Car{
	public FullsizeCar() {
		hornOnOff = new HornOn();
		lightOnOff = new LightOff();
		movingDirection = new Left();
		trunkOpenClose = new TrunkOpen();
		windowOpenClose = new WindowClose();
		
	}
}
