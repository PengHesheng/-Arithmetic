package designmodel.command;

/**
 * 俄罗斯方块游戏
 * @author PHS
 * @create 2019-04-29 16:04
 **/
public class Player {
}

class TetrisMachine {
    /**
     * 真正处理向左的逻辑
     */
    public void toLeft() {
        System.out.println("left");
    }

    public void toRight() {
        System.out.println("right");
    }

    public void fastToBottom() {
        System.out.println("fast to bottom");
    }

    public void transform() {
        System.out.println("transform");
    }
}

interface Command {
    /**
     * 命令执行方法
     */
    void execute();
}

/**
 * 左移
 */
class LeftCommand implements Command {
    private TetrisMachine machine;

    public LeftCommand(TetrisMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.toLeft();
    }
}

/**
 * 右移
 */
class RightCommand implements Command {
    private TetrisMachine machine;

    public RightCommand(TetrisMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.toRight();
    }
}

/**
 * 加速下落
 */
class FastDownCommand implements Command {
    private TetrisMachine machine;

    public FastDownCommand(TetrisMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.fastToBottom();
    }
}

/**
 * 变换
 */
class TransformCommand implements Command {
    private TetrisMachine machine;

    public TransformCommand(TetrisMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.transform();
    }
}

/**
 * 对应命令相关的按键
 */
class Buttons {
    private LeftCommand leftCommand;
    private RightCommand rightCommand;
    private FastDownCommand fastDownCommand;
    private TransformCommand transformCommand;

    public void setLeftCommand(LeftCommand leftCommand) {
        this.leftCommand = leftCommand;
    }

    public void setFastDownCommand(FastDownCommand fastDownCommand) {
        this.fastDownCommand = fastDownCommand;
    }

    public void setRightCommand(RightCommand rightCommand) {
        this.rightCommand = rightCommand;
    }

    public void setTransformCommand(TransformCommand transformCommand) {
        this.transformCommand = transformCommand;
    }

    public void toLeft() {
        leftCommand.execute();
    }

    public void toRight() {
        rightCommand.execute();
    }

    public void fall() {
        fastDownCommand.execute();
    }

    public void transform() {
        transformCommand.execute();
    }
}
