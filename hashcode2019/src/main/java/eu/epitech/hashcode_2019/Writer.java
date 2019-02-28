package eu.epitech.hashcode_2019;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Writer {
    public static String submissionToString(final Object solution) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        return (stringBuilder.toString());
    }

    public static void submissionToFile(final String fileName, final boolean append, final Object solution) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(fileName, append))) {
            out.print(submissionToString(solution));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Unable to save submission to file \'" + fileName + "\'");
        }
    }

}
