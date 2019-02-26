package eu.epitech.training_hashcode_2019.model;

import javafx.util.Pair;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ○ R (1 ≤ R ≤ 1000) is the number of rows,
 * ○ C (1 ≤ C ≤ 1000) is the number of columns,
 * ○ L (1 ≤ L ≤ 1000) is the minimum number of each ingredient cells in a slice,
 * ○ H (1 ≤ H ≤ 1000) is the maximum total number of cells of a slice
 */
@Data
public class InputData {
    private int rows;
    private int columns;
    private int minIngredients;
    private int maxCellsPerSlice;
    private Ingredient[][] ingredients; // [y][x] | [row][column]

    public void allocIngredients() {
        this.ingredients = new Ingredient[this.rows][this.columns];
    }

    public List<Ingredient> getIngredients(final int row0, final int column0, final int row1, final int column1) {
        final List<Pair<Integer, Integer>> positions = getPositions(row0, column0, row1, column1);
        return (positions
                .stream()
                .map(p -> this.ingredients[p.getKey()][p.getValue()])
                .collect(Collectors.toList()));
    }

    public List<Pair<Integer, Integer>> getPositions(final int row0, final int column0, final int row1, final int column1) {
        final int rowIncr = (row0 < row1) ? (+1) : (-1);
        final int colIncr = (column0 < column1) ? (+1) : (-1);
        final List<Pair<Integer, Integer>> pos = new ArrayList<>();
        int rowIt = row0;
        int colIt = column0;
        do {
            do {
                pos.add(new Pair<>(rowIt, colIt));
                if (colIt != column1) {
                    colIt += colIncr;
                }
            } while (colIt != column1);
            if (rowIt != row1) {
                rowIt += rowIncr;
            }
        } while(rowIt != row1);

        return (pos);
    }

    public List<Pair<Integer, Integer>> getPositions(final Slice slice) {
        return this.getPositions(slice.getRow0(), slice.getColumn0(), slice.getRow1(), slice.getColumn1());
    }

    public List<Ingredient> getIngredients(final Slice slice) {
        return this.getIngredients(slice.getRow0(), slice.getColumn0(), slice.getRow1(), slice.getColumn1());
    }

    @Override
    public String toString() {
        return "InputData{" +
                "rows=" + rows +
                ", columns=" + columns +
                ", minIngredients=" + minIngredients +
                ", maxCellsPerSlice=" + maxCellsPerSlice +
                ", ingredients=" + System.lineSeparator() +
                Arrays.stream(ingredients).map(Arrays::deepToString).collect(Collectors.joining(System.lineSeparator())) +
                '}';
    }
}
