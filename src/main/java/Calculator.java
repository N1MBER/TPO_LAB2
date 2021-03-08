package main.java;

import main.java.logorithm.*;
import main.java.trigonometric.*;

public class Calculator {
    private double x;


    public Calculator(double x) {
        this.x = x;
    }

    public double calculate() throws TrigonometricException, LogorithmException {
        if (this.x <= 0)
            return firstFunction(this.x);
        else
            return secondFunction(this.x);
    }

    public static double firstFunction(double x) throws TrigonometricException {
        return Cot.calculateCot(x) + Sin.calculateSin(x) + Sin.calculateSin(x);
    }

    public static double secondFunction(double x) throws LogorithmException{
        return ((((Ln.calculateLn(x) * Log3.calculateLog3(x)) * Ln.calculateLn(x)) + Log3.calculateLog3(x))
                * ((Log10.calculateLog10(x) * Log5.calculateLog5(x)) - Log5.calculateLog5(x))) * Log5.calculateLog5(x);
    }
}
