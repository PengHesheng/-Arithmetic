package designmodel.factory.abstractfactory;

/**
 * normal工厂的具体实现
 * @author PHS
 * @create 2019-03-30 15:27
 **/
public class NormalFactory extends CarFactory {

    @Override
    public ITire createTire() {
        return new NormalTire();
    }

    @Override
    public IEngine createEngine() {
        return new NormalEngine();
    }

    @Override
    public IBrake createBrake() {
        return new NormalBrake();
    }
}
