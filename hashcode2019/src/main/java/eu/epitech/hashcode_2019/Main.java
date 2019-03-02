package eu.epitech.hashcode_2019;

import eu.epitech.hashcode_2019.model.Slide;
import eu.epitech.hashcode_2019.solver.ISolver;
import eu.epitech.hashcode_2019.solver.SolverImpl;

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
        if (inputs.isEmpty()) {
            inputs.add("a_example.txt");
            inputs.add("b_lovely_landscapes.txt");
            inputs.add("c_memorable_moments.txt");
            inputs.add("d_pet_pictures.txt");
            inputs.add("e_shiny_selfies.txt");
        }

        inputs.forEach(input -> {
            final InputData inputData = Parser.parse(getInputResource(input));
            System.out.println("Input " + input + " contains: ");
            System.out.println("\t Tags: " + inputData.getTagCount());
            System.out.println("\t Images: " + inputData.getImageArray().size());
            //System.out.println(inputData);

            final ISolver solver = new SolverImpl();
            final List<Slide> solution = solver.solve(inputData);
            //new Validator(inputData).validate(solution);
            //System.out.println(Score.compute(solution));
            final String inputName =  input.substring(0, input.lastIndexOf('.'));
            Writer.submissionToFile(OUT_PATH + inputName.concat(".out"), false, solution);
        });
    }
}
