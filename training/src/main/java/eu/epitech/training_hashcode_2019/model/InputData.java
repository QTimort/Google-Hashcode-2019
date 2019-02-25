package eu.epitech.training_hashcode_2019.model;

import lombok.Data;

import java.util.Arrays;
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
    private Ingredient[][] ingredients; // [y][x]

    public void allocIngredients() {
        this.ingredients = new Ingredient[this.rows][this.columns];
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
