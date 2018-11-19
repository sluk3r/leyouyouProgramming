package top.itrator.leyouyouProgramming.calc;

import java.util.Objects;

public class Calculator {
    public static final String multiplor = "×";

    int first;
    int last;

    String operator;

    public Calculator(int first, int last, String operator) {
        this.first = first;
        this.last = last;
        this.operator = operator;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Calculator)) return false;
        Calculator that = (Calculator) o;
        return toString().equals(that.toString());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        return String.format(format, first, operator, last);
    }


    private final String format = "%s %s %s =";
}
