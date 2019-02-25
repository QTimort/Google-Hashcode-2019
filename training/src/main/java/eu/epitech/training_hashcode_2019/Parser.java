package eu.epitech.training_hashcode_2019;

import eu.epitech.training_hashcode_2019.model.Ingredient;
import eu.epitech.training_hashcode_2019.model.InputData;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class Parser {

    public static InputData toInputData(final File file) {
        return Parser.toInputData(file.getAbsolutePath());
    }

    public static InputData toInputData(final InputStream inputStream) {
        return Parser.toInputData(new Scanner(inputStream));
    }

    public static InputData toInputData(final String content) {
        return Parser.toInputData(new Scanner(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8))));
    }

    public static InputData toInputData(final Scanner scanner) {
        try (final Scanner ignored = scanner) {
            final InputData inputData = new InputData();
            inputData.setRows(scanner.nextInt());
            inputData.setColumns(scanner.nextInt());
            inputData.setMinIngredients(scanner.nextInt());
            inputData.setMaxCellsPerSlice(scanner.nextInt());
            inputData.allocIngredients();
            scanner.nextLine(); // skip new line
            for (int y = 0; y < inputData.getRows(); ++y) {
                final String line = scanner.nextLine();
                for (int x = 0; x < inputData.getColumns(); ++x) {
                    inputData.getIngredients()[y][x] = Ingredient.valueOf(line.charAt(x));
                }
            }

            return (inputData);
        }
    }
}
