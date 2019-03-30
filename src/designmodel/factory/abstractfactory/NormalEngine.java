package designmodel.factory.abstractfactory;

/**
 * normal engine
 * @author PHS
 * @create 2019-03-30 15:27
 **/
public class NormalEngine implements IEngine {
    @Override
    public void engine() {
        System.out.println("normal engine");
    }
}
