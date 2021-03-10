package main.java.stubs.trigonometric;

import main.java.trigonometric.TrigonometricException;

public class CotStub {
    public static double calculateCot(double x)  {
        return x % Math.PI == 0? Double.NaN: Math.cos(x) / Math.sin(x);
    }
}
