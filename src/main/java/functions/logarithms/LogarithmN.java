package functions.logarithms;

import exceptions.FunctionsException;
import functions.Function;

public class LogarithmN extends Function {

    public LogarithmN(double accuracy){
        super(accuracy);
    }

    public double calcLogN(double theta, double accuracy) throws FunctionsException {
        if (theta <= 0){
            throw new FunctionsException("Theta must be > 0 to calculate logarithm");
        }
        if (accuracy < 0){
            throw new FunctionsException("The accuracy below zero");
        }
        double result = 0;
        double multiplier = (theta - 1)/(theta + 1);
        double step = multiplier * 2;
        int i;
        for (i = 1; Math.abs(step) > accuracy && i != Integer.MAX_VALUE-2; i+=2){
            step = 2/(float) (i) * Math.pow(multiplier, i);
            result += step;
            if (!Double.isFinite(result) || !Double.isFinite(multiplier)){
                throw new FunctionsException("Can't reach the accuracy");
            }
        }
        if (i == Integer.MAX_VALUE || !Double.isFinite(result)){
            throw new FunctionsException("Can't reach the accuracy");
        }
        return result;
    }

    @Override
    public double calc(double theta) throws FunctionsException {
        return this.calcLogN(theta, this.accuracy);
    }

    @Override
    public String toString(){
        return "logN(x)";
    }
}
