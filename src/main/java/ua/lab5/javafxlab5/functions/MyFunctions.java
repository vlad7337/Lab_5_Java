package ua.lab5.javafxlab5.functions;

import javafx.geometry.Point2D;
import ua.lab5.javafxlab5.functions.core.Function;
import ua.lab5.javafxlab5.functions.core.Multiplication;
import ua.lab5.javafxlab5.functions.core.Sum;
import ua.lab5.javafxlab5.functions.elementary.*;

import java.util.ArrayList;
import java.util.List;

public class MyFunctions {

    private static final double A = 0.1;
    private static final double B = -0.5;

    public static Function firstFunction() {
        return Sum.of(
            Cosine.of(
                NaturalLogarithm.of(
                    Absolute.of(
                        Tangent.of(
                            Linear.of(A)
                        )
                    )
                )
            ),
            Multiplication.of(
                Const.NEGATIVE_ONE,
                Power.of(
                    NaturalLogarithm.of(
                        Absolute.of(
                            Sum.of(
                                Linear.of(B),
                                Const.of(-A)
                            )
                        )
                    ),
                    Const.of(2)
                )
            )
        );
    }

    public static Function secondFunction() {
        return Multiplication.of(
            Linear.X,
            Power.of(
                HyperbolicSine.of(
                    Absolute.of(
                        Multiplication.of(
                            Const.of(A),
                            Power.of(
                                Cosine.of(
                                    Linear.of(B)
                                ),
                                Const.of(1.0 / 3.0)
                            )
                        )
                    )
                ),
                Const.of(2)
            )
        );
    }

    /**
     * Calculates the f function values at n evenly distributed
     * points in range [a,b].
     * @return List of points as [x1,y1,x2,y2,...,xn,yn]
     */
    public static List<Double> getPointsInRange(double a, double b, int n, Function f) {
        List<Double> points = new ArrayList<>();

        double dx = (b - a) / (n-1);
        for (int i = 0; i < n; i++) {
            double x = a + i*dx;
            double y = f.calculate(x);
            points.add(x);
            points.add(y);
        }

        return points;
    }
}
