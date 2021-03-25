package services;

import exceptions.FunctionsException;
import functions.logarithms.LogarithmN;
import functions.trigonometrics.Cosinus;
import java.lang.Math.*;

public class Transformation {
    
    public double transformSinToCos(double theta, double accuracy) throws FunctionsException {
        return new Cosinus(accuracy).calcCos(Math.PI/2 - theta, accuracy);
    }

    public double transformCosToCtg(double theta, double accuracy) throws FunctionsException {
        double divisor = new Cosinus(accuracy).calcCos(theta,accuracy);
        if (Math.abs(divisor) <= accuracy) throw new FunctionsException("Division by zero");
        if (Math.abs((theta % Math.PI)) == 0)
            throw new FunctionsException("Infinity break point");
        double result = divisor / Math.sqrt(1 - Math.pow(divisor,2));
        return result;
    }

    public double transformLogNToLogK(double theta, double accuracy, int base) throws FunctionsException {
        if (base == 1){
            throw new FunctionsException("Division by zero");
        }
        return new LogarithmN(accuracy).calcLogN(theta, accuracy)/new LogarithmN(accuracy).calcLogN(base, accuracy);
    }
}
