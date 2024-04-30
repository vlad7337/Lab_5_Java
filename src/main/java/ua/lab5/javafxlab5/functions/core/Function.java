package ua.lab5.javafxlab5.functions.core;

import java.text.NumberFormat;

public interface Function {
    double calculate(double x);

    Function derivative();

    String toPrettyString(NumberFormat nf);
}
