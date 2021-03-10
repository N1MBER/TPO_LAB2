package main.java.stubs.trigonometric;

import main.java.trigonometric.Cot;

public class TrigonometricFunctionStub {
    public static double sinx(double x) {
        return SinStub.calculateSin(x);
    }

    public static double cosx(double x) {
        return CosStub.calculateCos(x);
    }

    public static double cotx(double x) {
        return CotStub.calculateCot(x);
    }

    public static double calculateExpression(double x) {
        double cot = x % Math.PI == 0 ? Double.NaN: Math.cos(x)/Math.sin(x);
        return cot + Math.sin(x) + Math.sin(x);
    }
}
