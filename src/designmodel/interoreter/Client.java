package designmodel.interoreter;

import java.util.Stack;

/**
 *
 * @author PHS
 * @create 2019-04-25 11:38
 **/
public class Client {
    public static void main(String[] args) {
        Calculator calculator = new Calculator("1 + 3 + 2");
        System.out.println(calculator.calculate());
    }
}

/**
 * 处理和解释业务
 */
class Calculator {
    private Stack<BaseArithmeticExpression> mExpStack = new Stack<>();

    public Calculator(String expression) {
        BaseArithmeticExpression exp1, exp2;

        String[] elements = expression.split(" ");
        for (int i = 0; i < elements.length; i++) {
            switch (elements[i].charAt(0)) {
                case '+':
                    exp1 = mExpStack.pop();
                    exp2 = new NumExpression(Integer.valueOf(elements[++i]));
                    mExpStack.push(new AdditionExpression(exp1, exp2));
                    break;
                case '-':
                    exp1 = mExpStack.pop();
                    exp2 = new NumExpression(Integer.valueOf(elements[++i]));
                    mExpStack.push(new SubtractionExpression(exp1, exp2));
                    break;
                default:
                    mExpStack.push(new NumExpression(Integer.valueOf(elements[i])));
                    break;
            }
        }
    }

    public int calculate() {
        return mExpStack.pop().interpret();
    }
}

/**
 * 抽象的算术解释器
 **/

abstract class BaseArithmeticExpression {
    /**
     * 抽象的解析方法
     * @return 解析的值
     */
    public abstract int interpret();
}

/**
 * 数字解释器，仅仅用于解释数字
 */
class NumExpression extends BaseArithmeticExpression {
    private int num;

    public NumExpression(int num) {
        this.num = num;
    }

    @Override
    public int interpret() {
        return num;
    }
}

/**
 * 操作符解释器
 */
abstract class BaseOperatorExpression extends BaseArithmeticExpression {
    protected BaseArithmeticExpression exp1, exp2;

    public BaseOperatorExpression(BaseArithmeticExpression exp1, BaseArithmeticExpression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }
}

/**
 * 加法运算解释器
 */
class AdditionExpression extends BaseOperatorExpression {

    public AdditionExpression(BaseArithmeticExpression exp1, BaseArithmeticExpression exp2) {
        super(exp1, exp2);
    }

    @Override
    public int interpret() {
        return exp1.interpret() + exp2.interpret();
    }
}

/**
 * 减法解释器
 */
class SubtractionExpression extends BaseOperatorExpression {

    public SubtractionExpression(BaseArithmeticExpression exp1, BaseArithmeticExpression exp2) {
        super(exp1, exp2);
    }

    @Override
    public int interpret() {
        return exp1.interpret() - exp2.interpret();
    }
}