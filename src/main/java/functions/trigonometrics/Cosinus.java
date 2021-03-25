package functions.trigonometrics;

import exceptions.FunctionsException;
import functions.Function;

public class Cosinus extends Function {

    public Cosinus(double accuracy){
        super(accuracy);
    }

    public double calcCos(double theta, double accuracy) throws FunctionsException {
        if (accuracy < 0){
            throw new FunctionsException("The accuracy below zero");
        }
        double theta_norm = Math.abs(theta);
        theta_norm -= Math.floor(theta_norm/Math.PI/2)*2*Math.PI;
        double result = 1;
        double step = 1;
        int i;
        for (i = 1; step > accuracy && i != Integer.MAX_VALUE; i++){
            step = step*theta_norm*theta_norm/(2*i-1)/(2*i);
            if (i % 2 == 1){
                result -= step;
            } else {
                result += step;
            }
        }
        if (!Double.isFinite(result) || i == Integer.MAX_VALUE-1){
            throw new FunctionsException("Too many iterations");
        }
        return result;
    }

    @Override
    public double calc(double theta) throws FunctionsException {
        return this.calcCos(theta, this.accuracy);
    }

    @Override
    public String toString(){
        return "cos(x)";
    }
}
