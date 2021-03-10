package main.java.stubs.logorithm;

public class Log10Stub {
    public static double calculateLog10(double x){
        return x <= 0 ? Double.NaN: Math.log(x)/Math.log(10);
    }
}
