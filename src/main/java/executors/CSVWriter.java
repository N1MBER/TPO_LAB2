package executors;

import exceptions.FunctionsException;
import functions.Function;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter implements AutoCloseable {
    private FileWriter fileWriter;
    private File file;
    private Function function;

    public CSVWriter(String fileName, Function function)  {
        try{
            file = new File(fileName);
            if (!file.exists()){
                file.createNewFile();
            }
            this.fileWriter = new FileWriter(file, true);
            this.function = function;
        }catch (IOException e){
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }

    public CSVWriter(String fileName){
        try{
            file = new File(fileName);
            if (!file.exists()){
                file.createNewFile();
            }
            this.fileWriter = new FileWriter(file, true);
        }catch (IOException e){
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }

    public void addHeader() throws IOException {
        fileWriter.write("x, " + function.toString() + "\n");
        fileWriter.flush();
    }


    public void writeRangeFunctionsValue(Double start, Double end, Double step) throws IOException {
        double y;
        for (double x = start; x < end; x+=step) {
            try {
                y = function.calc(x);
            } catch (FunctionsException e) {
                y = Double.NaN;
            }
            fileWriter.write(function.getClass().getSimpleName() + ": x=" + x + ", y=" + y + "\n");
        }
        fileWriter.flush();
    }

    public void writeFunctionsValue(Double val, Function function) throws IOException{
        double y;
        try{
            y = function.calc(val);
        } catch (FunctionsException e){
            y = Double.NaN;
        }
        fileWriter.write(function.getClass().getSimpleName() + ": x=" + val + ", y=" + y + "\n");
        fileWriter.flush();
    }

    @Override
    public void close() throws Exception {
        fileWriter.close();
    }


}
