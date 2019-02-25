package eu.epitech.training_hashcode_2019;

import eu.epitech.training_hashcode_2019.model.InputData;

import java.io.InputStream;

public class Main {
    private static final String INPUT_PATH = "/eu.epitech.training_hashcode_2019/input/";

    public static InputStream getInputResource(final String inputName) {
        return (Main.class.getResourceAsStream(INPUT_PATH + inputName));
    }

    public static void main(String[] args) {
        final String input;
        if (args.length > 0) {
            input = args[0];
        } else {
            input = "b_small.in";
        }
        final InputData inputData = Parser.toInputData(getInputResource(input));
        System.out.println(inputData);
    }
}
