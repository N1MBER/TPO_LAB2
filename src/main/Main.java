package main;

import main.java.functions.Function;
import main.java.functions.logarithms.Logarithm10;
import main.java.functions.logarithms.Logarithm3;
import main.java.functions.logarithms.Logarithm5;
import main.java.functions.logarithms.LogarithmN;
import main.java.functions.trigonometrics.Cosinus;
import main.java.functions.trigonometrics.Cotangent;
import main.java.functions.trigonometrics.Sinus;
import main.java.system.FirstFunction;
import main.java.system.SecondFunction;
import main.java.system.SystemFunctions;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        double accuracy = 1e-8;
        Function function = new LogarithmN(accuracy);
        Function function1 = new Logarithm3(accuracy);
        Function function2 = new Logarithm5(accuracy);
        Function function3 = new Logarithm10(accuracy);
        Function function4 = new Sinus(accuracy);
        Function function5 = new Cosinus(accuracy);
        Function function6 = new Cotangent(accuracy);
        Function function7 = new FirstFunction(accuracy);
        Function function8 = new SecondFunction(accuracy);
        Function function9 = new SystemFunctions(accuracy);
        CSVWriter csvWriter = new CSVWriter("logN.csv", function);
        csvWriter.writeRangeFunctionsValue(0,5,0.1);
    }


}
