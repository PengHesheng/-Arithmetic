package designmodel.memento;

/**
 * @author PHS
 * @create 2019-05-03 09:44
 **/
public class Test {
    public static void main(String[] args) {
        CallOfDuty game = new CallOfDuty();
        game.play();
        CareMaker careMaker = new CareMaker();
        careMaker.archive(game.createMemoto());
        game.quit();

        CallOfDuty newGame = new CallOfDuty();
        newGame.restore(careMaker.getMemoto());
    }
}

class CallOfDuty {
    private int mCheckPoint = 1;
    private int mLifeValue = 100;
    private String mWeapon = "沙漠之鹰";

    public void play() {
        System.out.println("play " + mCheckPoint);
        mLifeValue -= 10;
        System.out.println("进度升级");
        mCheckPoint++;
        System.out.println("played the " + mCheckPoint);
    }

    public void quit() {
        System.out.println("quit the values " + this.toString());
    }

    public Memoto createMemoto() {
        Memoto memoto = new Memoto();
        memoto.mCheckPoint = mCheckPoint;
        memoto.mLifeValue = mLifeValue;
        memoto.mWeapon = mWeapon;
        return memoto;
    }

    public void restore(Memoto memoto) {
        this.mCheckPoint = memoto.mCheckPoint;
        this.mLifeValue = memoto.mLifeValue;
        this.mWeapon = memoto.mWeapon;
        System.out.println("restore the values:" + this.toString());
    }

    @Override
    public String toString() {
        return "CallOfDuty: CheckPoint " + mCheckPoint + ", LifeValue " + mLifeValue + ", Weapon" + mWeapon;
    }
}

/**
 * 备忘录，记录状态
 */
class Memoto {
    public int mCheckPoint;
    public int mLifeValue;
    public String mWeapon;

    @Override
    public String toString() {
        return "Memoto: CheckPoint " + mCheckPoint + ", LifeValue " + mLifeValue + ", Weapon" + mWeapon;
    }
}

/**
 * 管理Memoto
 */
class CareMaker {
    private Memoto memoto;

    public void archive(Memoto memoto) {
        this.memoto = memoto;
    }

    public Memoto getMemoto() {
        return this.memoto;
    }
}