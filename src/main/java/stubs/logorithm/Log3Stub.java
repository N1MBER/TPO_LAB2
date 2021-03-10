package main.java.stubs.logorithm;

public class Log3Stub {
    public static double calculateLog3(double x){
        return x <= 0 ? Double.NaN: Math.log(x)/Math.log(3);
    }
}
