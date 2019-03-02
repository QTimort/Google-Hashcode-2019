package eu.epitech.hashcode_2019.solver;

import eu.epitech.hashcode_2019.InputData;
import eu.epitech.hashcode_2019.model.Slide;

import java.util.List;

public interface ISolver {
    List<Slide> solve(InputData inputData);
}
