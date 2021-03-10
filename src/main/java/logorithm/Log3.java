package main.java.logorithm;

public class Log3 {

    public static double calculateLog3(double x){
        if (x < 0){
            return Double.NaN;
        }
        return Ln.calculateLn(x)/Ln.calculateLn(3);
    }
}
