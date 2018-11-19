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
        int first = new Random().nextInt(2) + 2;
        int second = new Random().nextInt(8) + 2;

        logger.info(String.format("first[%s], second[%s]", first, second));

//        int first = r.nextInt(5);
//        int second = r.nextInt(5);

//        RandomDataGenerator generator = new RandomDataGenerator();
//        int first  =  generator.nextInt(5,10);
//        int second  =  generator.nextInt(5,10);

//        return new Calculator(first+5, second+5, Calculator.multiplor);
        return new Calculator(first, second, Calculator.multiplor);
    }

}
