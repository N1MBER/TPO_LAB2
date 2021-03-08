package main.java.logorithm;

public class Log5 {

    public static double calculateLog5(double x) throws LogorithmException{
        if (x < 0){
            throw new LogorithmException("Not valid value");
        }
        return Ln.calculateLn(x)/Ln.calculateLn(5);
    }
}
