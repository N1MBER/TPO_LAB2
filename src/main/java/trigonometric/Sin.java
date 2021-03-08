package main.java.trigonometric;

import java.lang.Math;
import java.lang.Double.*;

public class Sin {

    public static double calculateSin(double x) throws TrigonometricException{
        x = CalibrateX(x);
        Double xn = x;
        Double prevSum = 0.0;
        Double sum = x;
        final Double EPS = 1e-10, INF = 1.0e8;
        for (Integer n = 1; Math.abs(Math.abs(sum) - Math.abs(prevSum)) > EPS; n++) {
            prevSum = sum;
            xn *= -Math.pow(x,2)/((2*n+1)*2*n);
            sum += xn;
        }
        return Math.abs(sum) > INF ? INF : sum;
    }

    private static int getFactorial(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }

    private static Double CalibrateX(Double x) {
        double del = Math.PI * 2;
        if (x < 0)
            del *= -1;
        while (Math.abs(x) > 30.0) {
            x -= del;
        }
        return x;
    }

}
