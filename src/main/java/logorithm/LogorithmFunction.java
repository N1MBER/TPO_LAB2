package main.java.logorithm;

public class LogorithmFunction {
    public static double lnx(double x){
        return Ln.calculateLn(x);
    }

    public static double log_3x(double x) throws LogorithmException {
        return Log3.calculateLog3(x);
    }

    public static double log_5x(double x) throws LogorithmException {
        return Log5.calculateLog5(x);
    }

    public static double log_10x(double x) throws LogorithmException {
        return Log10.calculateLog10(x);
    }
    public static double calculateExpression(double x) throws LogorithmException {
        return ((((Ln.calculateLn(x) * Log3.calculateLog3(x)) * Ln.calculateLn(x)) + Log3.calculateLog3(x))
                * ((Log10.calculateLog10(x) * Log5.calculateLog5(x)) - Log5.calculateLog5(x))) * Log5.calculateLog5(x);
    }
}
