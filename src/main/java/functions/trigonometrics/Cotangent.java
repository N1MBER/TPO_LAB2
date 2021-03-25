package functions.trigonometrics;

import exceptions.FunctionsException;
import functions.Function;
import services.Transformation;

public class Cotangent extends Function {
    public Cotangent(double accuracy){
        super(accuracy);
    }

    public double calcCtg(double theta, double accuracy) throws FunctionsException {
        return new Transformation().transformCosToCtg(theta, accuracy);
    }

    @Override
    public double calc(double theta) throws FunctionsException {
        return this.calcCtg(theta, this.accuracy);
    }

    @Override
    public String toString(){
        return "ctg(x)";
    }
}
