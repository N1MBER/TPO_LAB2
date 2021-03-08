package main.java.trigonometric;

public class TrigonometricFunction {
    public static double sinx(double x) throws TrigonometricException {
        return Sin.calculateSin(x);
    }

    public static double cosx(double x) throws TrigonometricException {
        return Cos.calculateCos(x);
    }

    public static double cotx(double x) throws TrigonometricException {
        return Cot.calculateCot(x);
    }

    public static double calculateExpression(double x) throws TrigonometricException {
        return Cot.calculateCot(x) + Sin.calculateSin(x) + Sin.calculateSin(x);
    }
}
