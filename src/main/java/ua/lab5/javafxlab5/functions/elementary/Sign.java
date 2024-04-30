package ua.lab5.javafxlab5.functions.elementary;

import ua.lab5.javafxlab5.functions.core.Composite;
import ua.lab5.javafxlab5.functions.core.Function;

import java.text.NumberFormat;

public class Sign extends Composite {

    public Sign(Function term) {
        super(term);
    }

    @Override
    public double calculate(double x) {
        double termCalculateResult = terms().get(0).calculate(x);
        if (termCalculateResult > 0) {
            return 1;
        }
        if (termCalculateResult < 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public Function derivative() {
        return Const.ZERO;
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("sign(%s)", terms().get(0).toPrettyString(nf));
    }

    public static Sign of(Function term){
        return new Sign(term);
    }

}
