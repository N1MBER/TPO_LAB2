package main.java.logorithm;

public class Ln {
    private static final int k = 10;
    private static final double EPS = 1.0e-7;
    private static final Double ln10 = 2.302585092994045684017991454684364207601101488628772976033;

    public static double calculateLn(double x){
        if (x <= 0){
            return Double.NaN;
        }
        double res = 0;
        double tmp = 1;
        if (x > 1) {
            while (x > 1) {
                res += ln10;
                x = x/10;
            }
        }

        for (Double n = 1.0; Math.abs(tmp) > EPS; n++) {
            tmp = Math.pow((-1), (n+1)) * Math.pow((x - 1.0), n) / n ;
            res += tmp;
        }
//        for (int i = 1; i <= k; i++){
//            res += Math.pow(-1, i - 1) * (Math.pow(x - 1, i)/i);
//        }
        return res;
    }
}
