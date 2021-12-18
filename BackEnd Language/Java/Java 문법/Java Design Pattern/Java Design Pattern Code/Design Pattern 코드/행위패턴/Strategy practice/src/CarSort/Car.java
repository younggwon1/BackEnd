package CarSort;

import Interfacedomain.HornOnOff;
import Interfacedomain.LightOnOff;
import Interfacedomain.MovingDirection;
import Interfacedomain.TrunkOpenClose;
import Interfacedomain.WindowOpenClose;

public abstract class Car {
	
	HornOnOff hornOnOff;
	LightOnOff lightOnOff;
	MovingDirection movingDirection;
	TrunkOpenClose trunkOpenClose;
	WindowOpenClose windowOpenClose;
	
	public void peformHornOnOff() {
		hornOnOff.hornOnOff();
	}
	
	public void performLightOnOff() {
		lightOnOff.lightOnOff();
	}
	
	public void performMovingDirection() {
		movingDirection.movingDirection();
	}
	
	public void performTrunkOpenClose() {
		trunkOpenClose.trunkOpenClose();
	}
	
	public void performWindowOpenClose() {
		windowOpenClose.windowOpenClose();
	}

	public void setHornOnOff(HornOnOff hornOnOff) {
		this.hornOnOff = hornOnOff;
	}

	public void setLightOnOff(LightOnOff lightOnOff) {
		this.lightOnOff = lightOnOff;
	}

	public void setMovingDirection(MovingDirection movingDirection) {
		this.movingDirection = movingDirection;
	}

	public void setTrunkOpenClose(TrunkOpenClose trunkOpenClose) {
		this.trunkOpenClose = trunkOpenClose;
	}

	public void setWindowOpenClose(WindowOpenClose windowOpenClose) {
		this.windowOpenClose = windowOpenClose;
	}
}
