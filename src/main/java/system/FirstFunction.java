package system;

import exceptions.FunctionsException;
import functions.Function;
import functions.trigonometrics.Cosinus;
import functions.trigonometrics.Cotangent;
import functions.trigonometrics.Sinus;
import services.RangeChecker;

public class FirstFunction extends Function {
    public Cotangent cotangent;
    public Sinus sinus;
    public Cosinus cosinus;

    public FirstFunction(double accuracy){
        super(accuracy);
        cotangent = new Cotangent(accuracy);
        sinus = new Sinus(accuracy);
        cosinus = new Cosinus(accuracy);
    }

    @Override
    public double calc(double x) throws FunctionsException {
        if (new RangeChecker().checkRangeValueFirstFunction(x, this.accuracy))
            throw new FunctionsException("X doesn't math the range of acceptable values");
        return (cotangent.calc(x) + sinus.calc(x)) + sinus.calc(x);
    }

    @Override
    public String toString(){
        return "";
    }


}
