package eu.epitech.training_hashcode_2019;

import eu.epitech.training_hashcode_2019.model.InputData;
import eu.epitech.training_hashcode_2019.model.Slices;
import eu.epitech.training_hashcode_2019.solver.FirstSolver;
import eu.epitech.training_hashcode_2019.solver.ISolver;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String INPUT_PATH = "/input/";
    private static final String OUT_PATH = "./target/";

    public static InputStream getInputResource(final String inputName) {
        return (Main.class.getResourceAsStream(INPUT_PATH + inputName));
    }

    public static void main(String[] args) {
        final List<String> inputs = new ArrayList<>(Arrays.asList(args));
        final ISolver solver = new FirstSolver();
        if (inputs.isEmpty()) {
            inputs.add("a_example.in");
            inputs.add("b_small.in");
            inputs.add("c_medium.in");
            inputs.add("d_big.in");
        }

        inputs.forEach(input -> {
            final InputData inputData = Parser.toInputData(getInputResource(input));
            //System.out.println(inputData);
            final Slices slices = solver.solve(inputData);
            new Validator(inputData).validateSlices(slices);
            System.out.println(Score.compute(slices));
            Writer.submissionToFile(
                    OUT_PATH + input.substring(0, input.lastIndexOf('.')).concat(".out"), true, slices
            );
        });
    }
}
