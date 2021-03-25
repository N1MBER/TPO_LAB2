package system;

import exceptions.FunctionsException;
import functions.Function;

public class SystemFunctions extends Function {

    public FirstFunction firstFunction;
    public SecondFunction secondFunction;

    public SystemFunctions(double accuracy){
        firstFunction = new FirstFunction(accuracy);
        secondFunction = new SecondFunction(accuracy);
    }

    @Override
    public double calc(double theta) throws FunctionsException {
        if (theta <= 0) return firstFunction.calc(theta);
        else return secondFunction.calc(theta);
    }

    @Override
    public String toString(){
        return "(cot(x)+sin(x))+sin(x)_if_x<=0_((((ln(x)*log3(x))*ln(x))+log3(x))*((log10(x)*log5(x))−log5(x)))*log5(x)_if_x>0";
    }
}
