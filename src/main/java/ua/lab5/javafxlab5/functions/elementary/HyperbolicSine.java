package ua.lab5.javafxlab5.functions.elementary;

import ua.lab5.javafxlab5.functions.core.Composite;
import ua.lab5.javafxlab5.functions.core.Function;
import ua.lab5.javafxlab5.functions.core.Multiplication;

import java.text.NumberFormat;

public class HyperbolicSine extends Composite {

    public HyperbolicSine(Function term) {
        super(term);
    }

    @Override
    public double calculate(double x) {
        return Math.sinh(terms().get(0).calculate(x));
    }

    @Override
    public Function derivative() {
        Function term = terms().get(0);
        return Multiplication.of(HyperbolicCosine.of(term), term.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("sh(%s)", terms().get(0).toPrettyString(nf));
    }

    public static HyperbolicSine of(Function term){
        return new HyperbolicSine(term);
    }

}
