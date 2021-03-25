package functions.logarithms;

import exceptions.FunctionsException;
import functions.Function;
import services.Transformation;


public class Logarithm3 extends Function {
    public Logarithm3(double accuracy){
        super(accuracy);
    }

    public double calcLog3(double theta, double accuracy) throws FunctionsException {
        return new Transformation().transformLogNToLogK(theta, accuracy, 3);
    }

    @Override
    public double calc(double theta) throws FunctionsException{
        return this.calcLog3(theta, this.accuracy);
    }

    @Override
    public String toString(){
        return "log3(x)";
    }
}
