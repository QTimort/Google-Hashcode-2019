package eu.epitech.training_hashcode_2019;

import eu.epitech.training_hashcode_2019.model.InputData;
import eu.epitech.training_hashcode_2019.model.Slice;
import eu.epitech.training_hashcode_2019.model.Slices;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {
    private static final String INPUT_PATH = "/input/";
    private static final String OUT_PATH = "./target/";

    public static InputStream getInputResource(final String inputName) {
        return (Main.class.getResourceAsStream(INPUT_PATH + inputName));
    }

    public static void main(String[] args) {
        final String input;
        if (args.length > 0) {
            input = args[0];
        } else {
            input = "a_example.in";
        }

        final List<Slice> sliceList = new ArrayList<Slice>() {{
            add(new Slice(0, 2, 0, 1));
            add(new Slice(0, 2, 2, 2));
            add(new Slice(0, 2, 3, 4));
        }};
        final Slices slices = new Slices(new Vector<>(sliceList));

        final InputData inputData = Parser.toInputData(getInputResource(input));
        System.out.println(inputData);
        // todo solve
        new Validator(inputData).validateSlices(slices);
        System.out.println(Score.compute(slices));
        Writer.submissionToFile(OUT_PATH + "test.out", true, slices);
    }
}
