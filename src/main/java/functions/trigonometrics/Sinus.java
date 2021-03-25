package functions.trigonometrics;

import exceptions.FunctionsException;
import functions.Function;
import services.Transformation;

public class Sinus extends Function {
    public Sinus(double accuracy){
        super(accuracy);
    }

    public double calcSin(double theta, double accuracy) throws FunctionsException {
        return new Transformation().transformSinToCos(theta, accuracy);
    }

    @Override
    public double calc(double theta) throws FunctionsException {
        return this.calcSin(theta, this.accuracy);
    }

    @Override
    public String toString(){
        return "sin(x)";
    }
}
