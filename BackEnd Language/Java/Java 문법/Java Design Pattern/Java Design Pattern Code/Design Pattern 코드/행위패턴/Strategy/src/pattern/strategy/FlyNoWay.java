package pattern.strategy;

public class FlyNoWay implements FlyBehavior{

    @Override

    public void fly(){

        System.out.println("날지못해요.");

    }

}
