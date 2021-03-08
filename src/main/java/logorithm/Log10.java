package main.java.logorithm;

public class Log10 {

    public static double calculateLog10(double x) throws LogorithmException{
        if (x < 0){
            throw new LogorithmException("Not valid value");
        }
        return Ln.calculateLn(x)/Ln.calculateLn(10);
    }
}
