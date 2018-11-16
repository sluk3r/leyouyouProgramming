package top.itrator.leyouyouProgramming.calc;

import com.google.common.collect.Sets;
import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.Random;
import java.util.Set;

public class CalculatorFactory {

    public Set<Calculator> makeCalculatorSet(int number) {
        Set<Calculator> result = Sets.newHashSet();

        while (result.size() < number) {
            Calculator calculator = makeSingle();
            result.add(calculator);
        }

        return result;
    }

    private Calculator makeSingle() {
        Random r = new Random(432);

        int first = r.nextInt(10);
        int second = r.nextInt(10);

//        int first = r.nextInt(5);
//        int second = r.nextInt(5);

//        RandomDataGenerator generator = new RandomDataGenerator();
//        int first  =  generator.nextInt(5,10);
//        int second  =  generator.nextInt(5,10);

//        return new Calculator(first+5, second+5, Calculator.multiplor);
        return new Calculator(first, second, Calculator.multiplor);
    }

}