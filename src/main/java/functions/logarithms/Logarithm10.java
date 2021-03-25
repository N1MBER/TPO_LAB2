package functions.logarithms;

import exceptions.FunctionsException;
import functions.Function;
import services.Transformation;

public class Logarithm10 extends Function {
    public Logarithm10(double accuracy){
        super(accuracy);
    }

    public double calcLog10(double theta, double accuracy) throws FunctionsException {
        return new Transformation().transformLogNToLogK(theta, accuracy, 10);
    }

    @Override
    public double calc(double theta) throws FunctionsException{
        return this.calcLog10(theta, this.accuracy);
    }

    @Override
    public String toString(){
        return "log10(x)";
    }
}
