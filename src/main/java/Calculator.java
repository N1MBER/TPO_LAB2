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
            return TrigonometricFunction.calculateExpression(this.x);
        else
            return LogorithmFunction.calculateExpression(this.x);
    }

}
