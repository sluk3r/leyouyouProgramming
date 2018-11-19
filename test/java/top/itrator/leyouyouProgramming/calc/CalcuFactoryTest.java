package top.itrator.leyouyouProgramming.calc;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

public class CalcuFactoryTest {

    @Test
    public void test_make() {
        CalculatorFactory factory = new CalculatorFactory();

        int groupNum = 10;

        StringBuffer  buffer = new StringBuffer();
        buffer.append("========================================================================");
        for (int i=0;i<groupNum;i++) {
            buffer.append("\n\n\n\n\n\n\n\n\n");

            buffer.append(singleGroup(factory));

            buffer.append("\n\n\n\n\n\n\n\n\n");
            buffer.append("========================================================================");
        }

        System.out.println(buffer.toString());

    }


    private String singleGroup(CalculatorFactory factory ) {
        List<Calculator> calculatorSet = factory.makeCalculatorSet(100);

        int columnNum = 4;

        List<Calculator> calculatorList = Lists.newArrayList(calculatorSet);

        List<List<Calculator>> subLists = Lists.partition(calculatorList, columnNum);


        StringBuffer  buffer = new StringBuffer();
        for(List<Calculator> c: subLists) {
            buffer.append(Joiner.on("\t\t\t\t").join(c));
            buffer.append("\n");
        }
        return buffer.toString();
    }

}
