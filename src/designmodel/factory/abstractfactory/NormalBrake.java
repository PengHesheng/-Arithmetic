package designmodel.factory.abstractfactory;

/**
 * normal brake
 * @author PHS
 * @create 2019-03-30 15:26
 **/
public class NormalBrake implements IBrake {
    @Override
    public void brake() {
        System.out.println("normal brake");
    }
}
