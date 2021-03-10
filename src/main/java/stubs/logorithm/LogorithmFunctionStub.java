package main.java.stubs.logorithm;

import main.java.logorithm.*;

public class LogorithmFunctionStub {
    public static double lnx(double x){
        return LnStub.calculateLn(x);
    }

    public static double log_3x(double x) throws LogorithmException {
        return Log3Stub.calculateLog3(x);
    }

    public static double log_5x(double x) throws LogorithmException {
        return Log5Stub.calculateLog5(x);
    }

    public static double log_10x(double x) throws LogorithmException {
        return Log10Stub.calculateLog10(x);
    }
    public static double calculateExpression(double x) throws LogorithmException {
        return ((((Math.log(x) * Math.log(x)/Math.log(3)) * Math.log(x)) + Math.log(x)/Math.log(3))
                * ((Math.log(x)/Math.log(10) * Math.log(x)/Math.log(5)) - Math.log(x)/Math.log(5))) * Math.log(x)/Math.log(5);
    }
}
