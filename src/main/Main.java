package main;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CSVWriter csvWriter = new CSVWriter();
        Executor executor = new Executor(csvWriter);
        executor.execute();
        csvWriter.finish();
    }


}
