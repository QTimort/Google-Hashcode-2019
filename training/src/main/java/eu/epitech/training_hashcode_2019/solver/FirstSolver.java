package eu.epitech.training_hashcode_2019.solver;

import eu.epitech.training_hashcode_2019.model.Ingredient;
import eu.epitech.training_hashcode_2019.model.InputData;
import eu.epitech.training_hashcode_2019.model.Slice;
import eu.epitech.training_hashcode_2019.model.Slices;

public class FirstSolver implements ISolver {

    private static Slice findInLine(
            int atX,
            int atY,
            int vecX,
            int vecY,
            int max,
            InputData inputData

    ) {
        for (int i = 0 ; i < max; ++i) {
            final int x1 = atX + vecX * i;
            final int y1 = atY + vecY * i;
            if (x1 < 0 || x1 >= inputData.getColumns() || y1 < 0 || y1 >= inputData.getRows())
                return null;

            if (i >= (inputData.getMinIngredients() * 2)) {
                final long t = inputData.getIngredientCount(atY, atX, y1, x1, Ingredient.Tomato);
                final long m = i - t;
                if (t >= inputData.getMinIngredients() && m >= inputData.getMinIngredients()) {
                    // todo if not a multiple then we can try to go further
                    return new Slice(atY, y1, atX, x1);
                }
            }
        }
        return (null);
    }

    @Override
    public Slices solve(final InputData inputData) {
        final int min = inputData.getMinIngredients();
        final int max = inputData.getMaxCellsPerSlice();
        final Slices slices = new Slices();
        int x = 0;
        int y = 0;
        while (y < inputData.getRows()) {
            int longest = 1;
            while (x < inputData.getColumns()) {
                final Slice slice = findInLine(y, x, 0, 1, inputData.getMaxCellsPerSlice(), inputData);
                if (slice != null) {
                    slices.getSlices().add(slice);
                    if (slice.getCellCount() > longest) {
                        longest = slice.getCellCount();
                    }
                    break;
                }
                ++x;
            }
            x = 0;
            y += longest;
        }
        return (slices);
    }
}
