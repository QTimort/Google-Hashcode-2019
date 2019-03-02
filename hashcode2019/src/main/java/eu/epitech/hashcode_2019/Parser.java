package eu.epitech.hashcode_2019;

import eu.epitech.hashcode_2019.model.Image;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;


public class Parser {

    public static InputData parse(final File file) {
        return Parser.parse(file.getAbsolutePath());
    }

    public static InputData parse(final InputStream inputStream) {
        return Parser.parse(new Scanner(inputStream));
    }

    public static InputData parse(final String content) {
        return Parser.parse(new Scanner(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8))));
    }

    public static InputData parse(final Scanner scanner) {
        try (final Scanner ignored = scanner) {
            final int nbImages = scanner.nextInt();
            final InputData inputData = new InputData(nbImages);
            scanner.nextLine();
            for (int i = 0; i < nbImages; ++i) {
                final String[] s = scanner.nextLine().split(" ");
                final Image image = new Image();
                image.setHorizontal(s[0].equals("H"));
                image.setId(i);
                final int imageId = inputData.addImage(image);
                final int nbTags = Integer.parseInt(s[1]);
                image.setTags(new ArrayList<>(nbTags));
                for (int j = 0; j < nbTags; ++j) {
                    final String tag = s[2 + j];
                    final int tagId = inputData.addTag(imageId, tag);
                    image.getTags().add(tagId);
                }
            }
            inputData.fillNbsTagsImage();
            return inputData;
        }
    }
}
