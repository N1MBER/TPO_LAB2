package main.java.stubs.tests;

import main.CSVWriter;
import main.java.stubs.executors.Third;

public class ThirdStageTest {
    public static void main(String[] args){
        CSVWriter csvWriter = new CSVWriter();
        Third third = new Third(csvWriter);
        third.execute();
        csvWriter.finish();
    }
}
