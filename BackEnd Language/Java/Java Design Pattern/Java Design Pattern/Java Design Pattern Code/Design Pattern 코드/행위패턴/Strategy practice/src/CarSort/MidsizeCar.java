package CarSort;

import HornOnOffImpl.HornOff;
import LightOnOffImpl.LightOff;
import MovingDirectionImpl.Back;
import TrunkOpenCloseImpl.TrunkClose;
import WindowOpenCloseImpl.WindowOpen;

public class MidsizeCar extends Car{
	public MidsizeCar() {
		hornOnOff = new HornOff();
		lightOnOff = new LightOff();
		movingDirection = new Back();
		trunkOpenClose = new TrunkClose();
		windowOpenClose = new WindowOpen();
	}
}
