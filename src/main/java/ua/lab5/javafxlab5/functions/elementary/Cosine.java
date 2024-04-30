package ua.lab5.javafxlab5.functions.elementary;

import ua.lab5.javafxlab5.functions.core.Composite;
import ua.lab5.javafxlab5.functions.core.Function;
import ua.lab5.javafxlab5.functions.core.Multiplication;

import java.text.NumberFormat;

public class Cosine extends Composite {

    public Cosine(Function term) {
        super(term);
    }

    @Override
    public double calculate(double x) {
        return Math.cos(terms().get(0).calculate(x));
    }

    @Override
    public Function derivative() {
        Function term = terms().get(0);
        return new Multiplication(Const.NEGATIVE_ONE, Sine.of(term), term.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("cos(%s)", terms().get(0).toPrettyString(nf));
    }

    public static Cosine of(Function term){
        return new Cosine(term);
    }

}