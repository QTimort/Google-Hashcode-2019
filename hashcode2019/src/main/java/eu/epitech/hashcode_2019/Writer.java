package eu.epitech.hashcode_2019;

import eu.epitech.hashcode_2019.model.Slide;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class Writer {
    public static String submissionToString(final List<Slide> solution) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(solution.size()).append("\n");
        solution.forEach(s -> {
            s.getImageIds().forEach(id -> {
                stringBuilder.append(id).append(" "); // todo check if google care about extra-space at the end here
            });
            stringBuilder.append("\n");
        });
        return (stringBuilder.toString());
    }

    public static void submissionToFile(final String fileName, final boolean append, final List<Slide> solution) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(fileName, append))) {
            out.print(submissionToString(solution));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Unable to save submission to file \'" + fileName + "\'");
        }
    }

}
