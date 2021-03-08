package main.java.logorithm;

public class Log3 {

    public static double calculateLog3(double x) throws LogorithmException{
        if (x < 0){
            throw new LogorithmException("Not valid value");
        }
        return Ln.calculateLn(x)/Ln.calculateLn(3);
    }
}
