package ua.lab5.javafxlab5;

import ua.lab5.javafxlab5.functions.MyFunctions;
import ua.lab5.javafxlab5.functions.core.Function;
import ua.lab5.javafxlab5.functions.core.Sum;
import ua.lab5.javafxlab5.functions.elementary.Const;
import ua.lab5.javafxlab5.functions.elementary.Linear;

import java.util.Iterator;
import java.util.List;

public class BackendExample {
    public static void main(String[] args) {
        // f = 5x + 2
        Function f = Sum.of(Linear.of(5), Const.of(2));
        // Here we get list of 11 points (x,y pairs) in range [-1, 3]
        // points = [-1, f(-1), -0.6, f(-0.6), ..., 2.6, f(2.6), 3, f(3)]
        List<Double> points = MyFunctions.getPointsInRange(-1, 3, 11, f);
        // Iterator let us iterate through the list
        Iterator<Double> pointsIter = points.iterator();
        while (pointsIter.hasNext()) {
            // There is always even number of values in list
            // 'cause it consists of pairs of values
            double x = pointsIter.next();
            double y = pointsIter.next();
            System.out.printf("(%.3f; %.3f)%n", x, y);
        }
    }
}

