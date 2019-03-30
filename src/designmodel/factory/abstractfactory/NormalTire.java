package designmodel.factory.abstractfactory;

/**
 * normal tire
 * @author PHS
 * @create 2019-03-30 15:24
 **/
public class NormalTire implements ITire {
    @Override
    public void tire() {
        System.out.println("normal tire");
    }
}
