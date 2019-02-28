package eu.epitech.hashcode_2019;

import eu.epitech.hashcode_2019.model.Image;
import eu.epitech.hashcode_2019.model.InputData;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
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

            inputData.setNbPhoto(scanner.nextInt());
            inputData.allocImages();
            scanner.nextLine();
            for (int i = 0; i < inputData.getNbPhoto(); ++i) {
                final String[] s = scanner.nextLine().split(" ");
                final Image image = new Image();
                image.setHorizontal(s[0].equals("H"));
                image.setNbTag(Integer.parseInt(s[1]));
                image.allocTags();
                for (int j = 0; j < image.getNbTag(); ++j) {
                    image.getTags()[j] = s[2 + j];
                }
                inputData.getImages()[i] = image;
            }

            return (inputData);
        }
    }
}
