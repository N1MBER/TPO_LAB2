package main.java.trigonometric;

public class Cot {
    public static double calculateCot(double x) throws TrigonometricException{
        double sin = Sin.calculateSin(x);
        double cos = Cos.calculateCos(x);
        if (sin == 0){
            return Double.NaN;
        }
        return cos/sin;
    }
}
