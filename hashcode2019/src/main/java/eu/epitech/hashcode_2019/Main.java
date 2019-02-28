package eu.epitech.hashcode_2019;

import com.google.common.collect.Lists;
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
        final ISolver solver = new SolverImpl();
        if (inputs.isEmpty()) {
            inputs.add("a_example.txt");
            inputs.add("b_lovely_landscapes.txt");
            inputs.add("c_memorable_moments.txt");
            inputs.add("d_pet_pictures.txt");
            inputs.add("e_shiny_selfies.txt");
        }

        inputs.forEach(input -> {
            Parser.parse(getInputResource(input));
            //System.out.println(inputData);
            final List<Slide> solution = solver.solve();
            final Slide slide = new Slide();
            slide.setImageIds(Arrays.asList(0, 42));
            solution.add(slide);
            //new Validator(inputData).validate(solution);
            //System.out.println(Score.compute(solution));
            final String inputName =  input.substring(0, input.lastIndexOf('.'));
            Writer.submissionToFile(OUT_PATH + inputName.concat(".out"), false, solution);
        });
    }
}
