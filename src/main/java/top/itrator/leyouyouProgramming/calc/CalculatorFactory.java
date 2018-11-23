package top.itrator.leyouyouProgramming.calc;

import com.google.common.collect.Lists;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Random;

public class CalculatorFactory {
    Logger logger = LogManager.getLogger(CalculatorFactory.class);

    public List<Calculator> makeCalculatorSet(int number) {
        List<Calculator> result = Lists.newArrayList();

        logger.info("about to loop");
        while (result.size() < number) {
            logger.info(String.format("set size[%s], mumber[%s]", result.size(), number));
            Calculator calculator = makeSingle();
            result.add(calculator);
        }

        logger.info("end while loop");

        return result;
    }

    private Calculator makeSingle() {
        return new Random().nextBoolean() ? makeByCalculator() : makeObelusCalculator();
    }

    private Calculator makeObelusCalculator() {
        int first = new Random().nextInt(6) + 2;
        int second = new Random().nextInt(8) + 2;
        while (second % first != 0 || first == second) {
            first = new Random().nextInt(6) + 2;
            second = new Random().nextInt(8) + 2;
        }
        String operator = Calculator.Obelus;

        Calculator result  = new Calculator(second, first, operator);
        logger.info(result.toString());
        return result;

    }

    private Calculator makeByCalculator() {
        int first = new Random().nextInt(6) + 2;
        int second = new Random().nextInt(8) + 2;
        String operator = Calculator.multiplor;

        Calculator result  = new Calculator(second, first, operator);
        logger.info(result.toString());
        return result;
    }

}
