package services;
import java.lang.Math.*;

public class RangeChecker {

    public boolean checkRangeValueFirstFunction(double theta, double accuracy){
        return Math.abs(theta) % (Math.PI / 2) <= accuracy;
    }

    public boolean checkRangeValueSecondFunction(double theta, double accuracy){
        return theta <= 0;
    }
}
