package designmodel.factory.abstractfactory;

/**
 * @author PHS
 * @create 2019-03-30 15:22
 **/
public class AbstrctFactory {
}

abstract class CarFactory {
    public abstract ITire createTire();

    public abstract IEngine createEngine();

    public abstract IBrake createBrake();
}

/**
 * 制动相关
 **/
interface IBrake {
    void brake();
}

/**
 * 发动机相关
 **/
interface IEngine {
    void engine();
}

/**
 * 轮胎
 **/
interface ITire {
    void tire();
}

/**
 * normal brake
 **/
class NormalBrake implements IBrake {
    @Override
    public void brake() {
        System.out.println("normal brake");
    }
}

/**
 * normal engine
 **/
class NormalEngine implements IEngine {
    @Override
    public void engine() {
        System.out.println("normal engine");
    }
}

/**
 * normal tire
 **/
class NormalTire implements ITire {
    @Override
    public void tire() {
        System.out.println("normal tire");
    }
}

class NormalFactory extends CarFactory {

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


