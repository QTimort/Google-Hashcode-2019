package eu.epitech.training_hashcode_2019;

import eu.epitech.training_hashcode_2019.model.InputData;
import eu.epitech.training_hashcode_2019.model.Slice;
import eu.epitech.training_hashcode_2019.model.Slices;
import javafx.util.Pair;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class Writer {
    public static String submissionToString(final Slices slices) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(slices.getSlices().size())
                .append("\n");
        slices.getSlices().forEach(s ->
                stringBuilder
                        .append(s.getRow0()).append(" ")
                        .append(s.getRow1()).append(" ")
                        .append(s.getColumn0()).append(" ")
                        .append(s.getColumn1()).append(" ")
                        .append("\n"));
        return (stringBuilder.toString());
    }


    public static void submissionToFile(final String fileName, final boolean append, final Slices slices) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(fileName, append))) {
            out.print(submissionToString(slices));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Unable to save submission to file \'" + fileName + "\'");
        }
    }

    public static void writePizzaUsage(final String fileName, final InputData inputData, final Slices slices) {
        final boolean[][] used = new boolean[inputData.getRows()][inputData.getColumns()];

        for (final Slice slice : slices.getSlices()) {
            final List<Pair<Integer, Integer>> positions = inputData.getPositions(slice);
            for (final Pair<Integer, Integer> position : positions) {
                used[position.getKey()][position.getValue()] = true;
            }
        }

        try (PrintWriter out = new PrintWriter(new FileOutputStream(fileName, false))) {
            for (int y = 0; y < used.length; y++) {
                for (int x = 0; x < used[y].length; x++) {
                    if (used[y][x]) {
                        out.print('.');
                    }
                    out.print(' ');
                }
                out.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Unable to save pizza usage to file \'" + fileName + "\'");
        }
    }
}
