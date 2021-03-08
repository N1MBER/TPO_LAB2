package main.java.trigonometric;

import java.lang.Math;
import main.java.trigonometric.Sin;

public class Cos {
    public static double calculateCos(double x) throws TrigonometricException {
        try {
            double res = 1 - Math.pow(Sin.calculateSin(x), 2);
            if (res < 0) {
                return Double.NaN;
            }
            return Math.sqrt(res);
        }catch (Exception e){
            System.out.println("Not valid result");
            return Double.NaN;
        }
    }
}
