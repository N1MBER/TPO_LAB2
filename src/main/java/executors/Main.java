package executors;

import functions.Function;
import functions.logarithms.Logarithm10;
import functions.logarithms.Logarithm3;
import functions.logarithms.Logarithm5;
import functions.logarithms.LogarithmN;
import functions.trigonometrics.Cosinus;
import functions.trigonometrics.Cotangent;
import functions.trigonometrics.Sinus;
import system.FirstFunction;
import system.SecondFunction;
import system.SystemFunctions;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);
        System.out.println("Ручной ввод?\n" +
                "1. Да\n" +
                "2. Нет");
        String answer = scanner.nextLine();
        int ans = new Integer(answer);
        Executor executor = new Executor();
        if (ans == 1){
            executor.execute();
        }else if (ans == 2){
            double accuracy = 1e-8;
            Function function0 = new LogarithmN(accuracy);
            Function function1 = new Logarithm3(accuracy);
            Function function2 = new Logarithm5(accuracy);
            Function function3 = new Logarithm10(accuracy);
            Function function4 = new Sinus(accuracy);
            Function function5 = new Cosinus(accuracy);
            Function function6 = new Cotangent(accuracy);
            Function function7 = new FirstFunction(accuracy);
            Function function8 = new SecondFunction(accuracy);
            Function function9 = new SystemFunctions(accuracy);
            Function function = function4;
            String file_name = function.getClass().getSimpleName().toString();
            CSVWriter csvWriter = new CSVWriter(file_name + ".csv", function);
            csvWriter.writeRangeFunctionsValue(0.,5.,0.1);
            System.out.println("Finish");
        } else
            System.out.println("Finish");

    }


}
