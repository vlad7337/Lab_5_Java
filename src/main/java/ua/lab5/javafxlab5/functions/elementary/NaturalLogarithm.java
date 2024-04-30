package ua.lab5.javafxlab5.functions.elementary;

import ua.lab5.javafxlab5.functions.core.Composite;
import ua.lab5.javafxlab5.functions.core.Function;
import ua.lab5.javafxlab5.functions.core.Multiplication;

import java.text.NumberFormat;

public class NaturalLogarithm extends Composite {

    public NaturalLogarithm(Function term) {
        super(term);
    }

    @Override
    public double calculate(double x) {
        return Math.log(terms().get(0).calculate(x));
    }

    @Override
    public Function derivative() {
        Function term = terms().get(0);
        return new Multiplication(Power.of(term, Const.NEGATIVE_ONE), term.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("ln(%s)", terms().get(0).toPrettyString(nf));
    }

    public static NaturalLogarithm of(Function term){
        return new NaturalLogarithm(term);
    }

}
