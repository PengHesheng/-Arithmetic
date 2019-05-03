package designmodel.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author PHS
 * @create 2019-05-03 09:29
 **/
public class Test {
    public static void main(String[] args) {
        DevTechFrontier techFrontier = new DevTechFrontier();
        Coder coder1 = new Coder("coder1");
        Coder coder2 = new Coder("coder2");
        Coder coder3 = new Coder("coder3");

        techFrontier.addObserver(coder1);
        techFrontier.addObserver(coder2);
        techFrontier.addObserver(coder3);

        techFrontier.postNewPublication("the news");
    }


}

/**
 * 观察者 coder
 */
class Coder implements Observer {
    public String name;
    public Coder(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name + ", update content:" + arg);
    }

    @Override
    public String toString() {
        return "coder:" + name;
    }
}

/**
 * 被观察者
 */
class DevTechFrontier extends Observable {
    public void postNewPublication(String content) {
        //标识状态或者内容改变
        setChanged();
        //通知所有观察者
        notifyObservers(content);
    }
}
