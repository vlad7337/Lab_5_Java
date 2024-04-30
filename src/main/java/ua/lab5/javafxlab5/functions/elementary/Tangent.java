package ua.lab5.javafxlab5.functions.elementary;

import ua.lab5.javafxlab5.functions.core.Composite;
import ua.lab5.javafxlab5.functions.core.Function;
import ua.lab5.javafxlab5.functions.core.Multiplication;

import java.text.NumberFormat;

public class Tangent extends Composite {

    public Tangent(Function term) {
        super(term);
    }

    @Override
    public double calculate(double x) {
        return Math.tan(terms().get(0).calculate(x));
    }

    @Override
    public Function derivative() {
        Function term = terms().get(0);
        return new Multiplication(Power.of(Cosine.of(term), Const.of(-2)), term.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("tg(%s)", terms().get(0).toPrettyString(nf));
    }

    public static Tangent of(Function term){
        return new Tangent(term);
    }

}
