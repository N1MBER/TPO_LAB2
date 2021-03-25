package system;

import exceptions.FunctionsException;
import functions.Function;
import functions.logarithms.Logarithm10;
import functions.logarithms.Logarithm3;
import functions.logarithms.Logarithm5;
import functions.logarithms.LogarithmN;
import services.RangeChecker;

public class SecondFunction extends Function {

    public LogarithmN logarithmN;
    public Logarithm3 logarithm3;
    public Logarithm5 logarithm5;
    public Logarithm10 logarithm10;

    public SecondFunction(double accuracy){
        super(accuracy);
        logarithmN = new LogarithmN(accuracy);
        logarithm3 = new Logarithm3(accuracy);
        logarithm5 = new Logarithm5(accuracy);
        logarithm10 = new Logarithm10(accuracy);
    }

    @Override
    public double calc(double x) throws FunctionsException {
        if (new RangeChecker().checkRangeValueSecondFunction(x, this.accuracy))
            throw new FunctionsException("X doesn't math the range of acceptable values");
        return ((((logarithmN.calc(x) * logarithm3.calc(x)) * logarithmN.calc(x)) +
                logarithm3.calc(x)) * ((logarithm10.calc(x)*logarithm5.calc(x)) -
                logarithm5.calc(x))) * logarithm5.calc(x);
    }



    @Override
    public String toString(){
        return "((((ln(x)*log3(x))*ln(x))+log3(x))*((log10(x)*log5(x))−log5(x)))*log5(x)";
    }
}
