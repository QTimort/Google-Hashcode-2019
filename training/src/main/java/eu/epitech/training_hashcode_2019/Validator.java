package eu.epitech.training_hashcode_2019;

import eu.epitech.training_hashcode_2019.model.Ingredient;
import eu.epitech.training_hashcode_2019.model.InputData;
import eu.epitech.training_hashcode_2019.model.Slice;
import eu.epitech.training_hashcode_2019.model.Slices;
import javafx.util.Pair;

import java.util.List;

public class Validator {
    private final InputData inputData;

    public Validator(InputData inputData) {
        this.inputData = inputData;
    }

    public static void Assert(boolean predicate) {
        if (!predicate)
            throw new RuntimeException("Assertion failed");
    }

    public void validateSlice(final Slice slice) {
        final List<Ingredient> ingredients = inputData.getIngredients(slice);
        Assert(ingredients.size() <= inputData.getMaxCellsPerSlice());
        final long tomatoCount = ingredients.stream().filter(i -> i == Ingredient.Tomato).count();
        Assert(tomatoCount >= inputData.getMinIngredients());
        final long mushroomCount = ingredients.size() - tomatoCount;
        Assert(mushroomCount >= inputData.getMinIngredients());
    }

    public void validateOverlap(final Slices slices) {
        final boolean[][] used = new boolean[this.inputData.getRows()][this.inputData.getColumns()];

        for (final Slice slice : slices.getSlices()) {
            final List<Pair<Integer, Integer>> positions = inputData.getPositions(slice);
            for (final Pair<Integer, Integer> position : positions) {
                Assert(!used[position.getKey()][position.getValue()]);
                used[position.getKey()][position.getValue()] = true;
            }
        }
    }

    public void validateSlices(final Slices slices) {
        for (Slice slice : slices.getSlices()) {
            this.validateSlice(slice);
        }
        validateOverlap(slices);
    }
}
