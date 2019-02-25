package eu.epitech.training_hashcode_2019;

import eu.epitech.training_hashcode_2019.model.Slice;
import eu.epitech.training_hashcode_2019.model.Slices;

public class Score {

    public static int compute(final Slices slices) {
        int score = 0;
        for (final Slice slice : slices.getSlices()) {
            score += slice.getCellCount();
        }
        return (score);
    }

}
