package eu.epitech.training_hashcode_2019;

import eu.epitech.training_hashcode_2019.model.Slices;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

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
}
