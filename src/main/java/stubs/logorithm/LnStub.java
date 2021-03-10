package main.java.stubs.logorithm;

public class LnStub {
    public static double calculateLn(double x){
       return x <= 0 ? Double.NaN: Math.log(x);
    }
}
