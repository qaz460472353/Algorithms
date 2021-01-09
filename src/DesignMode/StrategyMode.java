package DesignMode;

/**
 * @Description 策略模式
 * @Author ZY
 * @Date 2021/1/9 17:39
 **/
public class StrategyMode {
    public interface ICalculator {
        public int calculate(String exp);
    }
    public class Minus extends AbstractCalcuator implements ICalculator {
        @Override
        public int calculate(String exp) {
            int arrayInt[] = split(exp,"-");
            return arrayInt[0] - arrayInt[1];
        }
    }
    public static class Plus extends AbstractCalcuator implements ICalculator {

        @Override
        public int calculate(String exp) {
            int arrayInt[] = split(exp,"\\+");
            return arrayInt[0] + arrayInt[1];
        }
    }
    public static class AbstractCalcuator {
        public int[] split(String exp,String opt) {
            String array[] = exp.split(opt);
            int arrayInt[] = new int[2];
            arrayInt[0] = Integer.parseInt(array[0]);
            arrayInt[1] = Integer.parseInt(array[1]);
            return arrayInt;
        }
    }

    public static void main(String[] args) {
        String exp = "2+8";
        ICalculator cal = new Plus();
        int result = cal.calculate(exp);
        System.out.println(result);
    }
}
