package designmodel.factory.abstractfactory;

/**
 * 抽象工厂
 * @author PHS
 * @create 2019-03-30 15:21
 **/
public abstract class CarFactory {
    public abstract ITire createTire();

    public abstract IEngine createEngine();

    public abstract IBrake createBrake();
}
