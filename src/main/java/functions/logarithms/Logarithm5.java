package functions.logarithms;

import exceptions.FunctionsException;
import functions.Function;
import services.Transformation;

public class Logarithm5 extends Function {
    public Logarithm5(double accuracy){
        super(accuracy);
    }

    public  double calcLog5(double theta, double accuracy) throws FunctionsException {
        return new Transformation().transformLogNToLogK(theta, accuracy, 5);
    }

    @Override
    public double calc(double theta) throws FunctionsException{
        return this.calcLog5(theta, this.accuracy);
    }

    @Override
    public String toString(){
        return "log5(x)";
    }
}
