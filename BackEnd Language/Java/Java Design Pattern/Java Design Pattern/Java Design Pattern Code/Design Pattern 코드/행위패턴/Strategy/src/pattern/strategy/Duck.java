package pattern.strategy;

public abstract class Duck {

	FlyBehavior flyBehavior;

	QuackBehavior quackBehavior;

	public void swim() {

		System.out.println("물에 떠있습니다.");

	}

	public abstract void display();

	public void performQuack() {

		quackBehavior.quack();

	}

	public void performFly() {

		flyBehavior.fly();

	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {

		this.flyBehavior = flyBehavior;

	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {

		this.quackBehavior = quackBehavior;

	}

}
